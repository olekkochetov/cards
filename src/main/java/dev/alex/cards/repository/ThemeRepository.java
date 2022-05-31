package dev.alex.cards.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.alex.cards.model.Theme;

public interface ThemeRepository extends  JpaRepository<Theme, Long>{

}
