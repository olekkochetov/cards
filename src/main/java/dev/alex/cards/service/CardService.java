package dev.alex.cards.service;

import java.util.List;

import dev.alex.cards.model.Card;

public interface CardService {
    void saveNewCard(Card card);

    void deleteCard(Card card);

    Card getCardById(long id);

    List<Card> getThemeCards();
}
