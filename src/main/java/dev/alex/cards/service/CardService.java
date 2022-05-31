package dev.alex.cards.service;

import java.util.List;

import dev.alex.cards.model.Card;

public interface CardService {
	void saveNewCard(Card card);
	void deleteCard(Card card);
	void updateCard(Card card);
	Card getCardById(int id);
	List<Card>getThemeCards();
}
