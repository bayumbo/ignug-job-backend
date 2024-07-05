package com.bolsaempleo.backend.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.bolsaempleo.backend.app.entities.job_board.Offer;


@Repository
public interface OffersRepository extends JpaRepository<Offer, Long>{

        @Query("select u from Offer u where u.deletedAt IS NULL")
        List<Offer> findAllOffers();
}

