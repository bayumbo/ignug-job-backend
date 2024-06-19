package com.bolsaempleo.backend.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bolsaempleo.backend.app.entities.job_board.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long>{

    @Query("select u from Category u where u.category=:category")
    List<Category> getSubCategoriesById(@Param("category")Category id);

    @Query("select u from Category u where u.id=:id")
    Category findCategoriesById(@Param("id")Long id);
    
}
