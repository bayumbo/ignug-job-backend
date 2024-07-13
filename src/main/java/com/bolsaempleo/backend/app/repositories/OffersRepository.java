package com.bolsaempleo.backend.app.repositories;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bolsaempleo.backend.app.entities.job_board.Offer;


@Repository
public interface OffersRepository extends JpaRepository<Offer, UUID>{

        //@Query("select u from Offer u where u.deletedAt IS NULL")
        //List<Offer> findAllOffers();
}

