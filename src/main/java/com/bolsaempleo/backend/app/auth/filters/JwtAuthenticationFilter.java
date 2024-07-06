package com.bolsaempleo.backend.app.auth.filters;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import com.bolsaempleo.backend.app.dto.LoginJWTResponseDto;
import com.bolsaempleo.backend.app.entities.authentication.Users;
import com.bolsaempleo.backend.app.utility.ComunEnum;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

    private AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {

        Users users = null;
        String username = null;
        String password = null;
        
        try {
            users = new ObjectMapper().readValue(request.getInputStream(), Users.class);
            username = users.getUsername();
            password = users.getPassword();

            //logger.info("Username desde request InputStream (raw) " + username);
            //logger.info("Password desde request InputStream (raw) " + password);

        } catch (StreamReadException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);
        return authenticationManager.authenticate(authToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authResult) throws IOException, ServletException {

        String username = ((org.springframework.security.core.userdetails.User) authResult.getPrincipal())
                .getUsername();

        //String originalInput = ComunEnum.SECRET_KEY+":" + username;
        //String token = Base64.getEncoder().encodeToString(originalInput.getBytes());

        String token = Jwts.builder()
                        .setSubject(username)// pasamos como payload el username
                        .signWith(ComunEnum.SECRET_KEY)
                        .setIssuedAt(new Date())
                        .setExpiration(new Date(System.currentTimeMillis() + 3600000))//tiempo que dura el tocken en milisegundos
                        .compact();

        response.addHeader("Authorization", "Bearer " + token);

        Map<String, Object> bodyToken = new HashMap<>();
        bodyToken.put("token", token);

        LoginJWTResponseDto body = new LoginJWTResponseDto();
        body.setCode(ComunEnum.CORRECTO.toString());
        body.setMessage(username+" "+ComunEnum.MENSAJELOGINSUCCESSFUL.getDescripcion());
        body.setData(bodyToken);
        response.getWriter().write(new ObjectMapper().writeValueAsString(body));
        response.setStatus(200);
        response.setContentType("application/json");
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException failed) throws IOException, ServletException {

        LoginJWTResponseDto body = new LoginJWTResponseDto();
        body.setCode(ComunEnum.CORRECTO.toString());
        body.setMessage(ComunEnum.MENSAJELOGINUNSUCCESSFUL.getDescripcion());
        body.setData(null);
        response.getWriter().write(new ObjectMapper().writeValueAsString(body));
        response.setStatus(401);
        response.setContentType("application/json");
    }
}
