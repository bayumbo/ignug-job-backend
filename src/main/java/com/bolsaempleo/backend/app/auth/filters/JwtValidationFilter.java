package com.bolsaempleo.backend.app.auth.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.bolsaempleo.backend.app.dto.TokenResponseDto;
import com.bolsaempleo.backend.app.utility.ComunEnum;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


 
public class JwtValidationFilter extends BasicAuthenticationFilter {

    public JwtValidationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        String header = request.getHeader(ComunEnum.HEADER_AUTHORIZATION);
        if (header == null || !header.startsWith(ComunEnum.PREFIX_TOKEN)) {// no todos los endpoints vienen con la cabecera authorization
            chain.doFilter(request, response);
            return;
        }
        String token = header.replace(ComunEnum.PREFIX_TOKEN, "");
        try {
            /*esta parte es para validar el token */
            Claims claims = Jwts.parser()
                            .setSigningKey(ComunEnum.SECRET_KEY)// aqui valida la firma con la misma llave que fue generado
                            .build()
                            .parseClaimsJws(token)
                            .getBody();//con getbody obtenemos los claims y con los claims los datos

            String claimsUserName = claims.getSubject();
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(claimsUserName, null,
                    authorities);
                    //Con este setAuthentication nos autenticamos y dejamos pasar al recurso invocado
            SecurityContextHolder.getContext().setAuthentication(authentication);
            chain.doFilter(request, response);
        } catch (JwtException e) {
            TokenResponseDto body = new TokenResponseDto();
            body.setCode(ComunEnum.INCORRECTO.toString());
            body.setMessage(ComunEnum.MENSAJETOKENINVALIDO.getDescripcion());
            body.setData(e.getMessage());
            response.getWriter().write(new ObjectMapper().writeValueAsString(body));
            response.setStatus(ComunEnum.INCORRECTO);
            response.setContentType("application/json");
        }
    }

}


