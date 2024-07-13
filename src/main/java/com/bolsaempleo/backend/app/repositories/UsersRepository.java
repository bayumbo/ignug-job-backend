package com.bolsaempleo.backend.app.repositories;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.bolsaempleo.backend.app.entities.authentication.Users;


@Repository
public interface UsersRepository extends JpaRepository<Users,UUID>{


        @Query("select u from Users u where u.deletedAt IS NULL")
        List<Users> findAllUsers();

        @Query("select u from Users u where u.id=:id and u.deletedAt IS NULL")
        Users findUserById(@Param("id")UUID id);

        @Query("select u from Users u where u.username=:userName and u.deletedAt IS NULL")
        Users findByUsername(@Param("userName") String userName);

        //Optional<Users> findByUserNa (String userName);

        //@Query("select u from Users u where u.username=:uName and u.deletedAt IS NULL")
        //Optional<Users> getUserByUserName (String uName);



}
