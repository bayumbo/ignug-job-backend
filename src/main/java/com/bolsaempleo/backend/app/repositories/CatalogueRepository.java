package com.bolsaempleo.backend.app.repositories;


import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.bolsaempleo.backend.app.entities.core.Catalogue;

@Repository
public interface CatalogueRepository extends CrudRepository<Catalogue, Long>{


    @Query("select c from Catalogue c where c.id=:id AND c.deletedAt IS NULL")
    Catalogue findCatalogueById(@Param("id")Long id);

    @Query("select c from Catalogue c where UPPER(c.type) like UPPER(?1) AND c.deletedAt IS NULL")
    List<Catalogue> findByTypeDescription(@Param("type")String type);

}
