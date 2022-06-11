package dev.alex.cards.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.alex.cards.model.Box;

@Repository
public interface BoxRepository extends JpaRepository<Box, Long> {

}
