package dev.alex.cards.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.alex.cards.model.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long>{

}
