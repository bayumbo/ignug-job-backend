package com.bolsaempleo.backend.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bolsaempleo.backend.app.entities.authentication.Users;
import com.bolsaempleo.backend.app.repositories.UsersRepository;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

@Service
public class JpaUserDetailsService implements UserDetailsService {


    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Users users = usersRepository.findByUsername(username);
        
        if (users.equals(null)) {
            throw new UsernameNotFoundException(String.format("Username %s no existe en el sistema!", username));
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new User(users.getUsername(),
                users.getPassword(),
                true,
                true,
                true,
                true,
                authorities);

    }
//$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS
}
