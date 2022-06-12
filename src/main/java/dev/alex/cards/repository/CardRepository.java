package dev.alex.cards.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dev.alex.cards.model.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    @Query("Select c from Card c where c.theme = :theme and c.box = :box")
    List<Card> findCardByThemeAndBox(@Param("box") int boxId, @Param("theme") int themeId);
}
