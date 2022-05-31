package dev.alex.cards.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.alex.cards.model.Card;

public interface CardRepository extends JpaRepository<Card, Long>{

}
