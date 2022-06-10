package dev.alex.cards.service;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.alex.cards.model.Card;

@Service
public interface BoxService {
	long getAmountElements();
	int getAmountElementsToLearn();
	List<Card> getCardsToLearn();
	List<Card> getAllCardsInBox();
	LocalDateTime getTimeSpan();
	LocalDateTime getStartDate();
	
}
