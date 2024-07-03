package com.bolsaempleo.backend.app.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.bolsaempleo.backend.app.entities.job_board.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long>{


    @Query("select c from Category c where c.id=:id AND c.deletedAt IS NULL")
    Category findCategoryById(@Param("id")Long id);

    @Query("select c from Category c where c.category=:category AND c.deletedAt IS NULL")
    List<Category> getSubCategoriesById(@Param("category")Category id);

    @Query("select c from Category c where c.id=:id OR c.category=:category AND c.deletedAt IS NULL")
    List<Category> getCategoriesAndSubCategoriesById(@Param("id")Long id,@Param("category")Category ids);

}
