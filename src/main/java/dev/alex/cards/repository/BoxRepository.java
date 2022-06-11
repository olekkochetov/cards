package dev.alex.cards.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dev.alex.cards.model.Box;
import dev.alex.cards.model.Card;

@Repository
public interface BoxRepository extends JpaRepository<Box, Long> {

}
