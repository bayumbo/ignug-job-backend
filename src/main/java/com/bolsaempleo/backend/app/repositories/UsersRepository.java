package com.bolsaempleo.backend.app.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.bolsaempleo.backend.app.entities.authentication.Users;


@Repository
public interface UsersRepository extends CrudRepository<Users,Long>{


        @Query("select u from Users u where u.deletedAt IS NULL")
        List<Users> findAllUsers();

        @Query("select u from Users u where u.id=:id and u.deletedAt IS NULL")
        Users findUserById(@Param("id")Long id);


}
