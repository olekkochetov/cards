package dev.alex.cards.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.alex.cards.model.Theme;

@Repository
public interface ThemeRepository extends  JpaRepository<Theme, Long>{

}
