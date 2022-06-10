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
	int getAmountElementsToLearn();
	List<Card> getCardsToLearn();
	List<Card> getAllCardsInBox(long boxId);
	Box getBoxById(long boxId);
	LocalDateTime getEndDate(Card card);
	LocalDateTime getStartDate(Card card);
	LocalDateTime getTodayDate();
	void saveBox(Box box);
}
