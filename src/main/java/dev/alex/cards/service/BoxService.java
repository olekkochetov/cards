package dev.alex.cards.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.alex.cards.model.Box;
import dev.alex.cards.model.Card;

@Service
public interface BoxService {
    long countBoxes();

    List<Box> getAllBoxes();

    int getElementsNumber(long boxId);

    List<Card> getCardsToLearn();

    List<Card> getAllCardsInBox(String themeName, long boxId);

    Box getBoxById(long boxId);

    void addCardToBox(long boxId, Card card);

    void saveBox(Box box);
}
