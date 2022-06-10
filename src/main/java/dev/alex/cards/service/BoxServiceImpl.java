package dev.alex.cards.service;

import java.time.LocalDateTime;
import java.util.List;

import dev.alex.cards.model.Card;
import dev.alex.cards.repository.BoxRepository;

public class BoxServiceImpl implements BoxService{
	
	BoxRepository boxRepository;
	
	
	
	public BoxServiceImpl() {
		super();
	}

	public BoxServiceImpl(BoxRepository boxRepository) {
		super();
		this.boxRepository = boxRepository;
	}

	@Override
	public long getAmountElements() {
		return boxRepository.count();
	}

	@Override
	public List<Card> getCardsToLearn() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Card> getAllCardsInBox() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocalDateTime getTimeSpan() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAmountElementsToLearn() {
		// TODO amount words after the date to learn
		return 0;
	}

	@Override
	public LocalDateTime getStartDate() {
		// TODO Auto-generated method stub
		return null;
	}

}
