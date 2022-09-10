package com.clashdados.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clashdados.models.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {

}
