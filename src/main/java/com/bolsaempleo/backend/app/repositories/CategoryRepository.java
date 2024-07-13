package com.bolsaempleo.backend.app.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.bolsaempleo.backend.app.entities.job_board.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category,UUID>{


    @Query("select c from Category c where c.id=:id AND c.deletedAt IS NULL")
    Category findCategoryById(@Param("id")UUID id);

    @Query("select c from Category c where c.category=:category AND c.deletedAt IS NULL")
    List<Category> getSubCategoriesById(@Param("category")Category id);

    @Query("select c from Category c where c.id=:id OR c.category=:category AND c.deletedAt IS NULL")
    List<Category> getCategoriesAndSubCategoriesById(@Param("id")UUID id,@Param("category")Category ids);

}
