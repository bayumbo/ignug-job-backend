package com.bolsaempleo.backend.app.entities.authentication;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;


    @Column(unique = true)
    @Getter
    @Setter
    private String username;


    @Getter
    @Setter
    private String password;

    @Column(unique = true)
    @Getter
    @Setter
    private String email;

    

    

}
