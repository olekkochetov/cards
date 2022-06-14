package dev.alex.cards.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.alex.cards.model.Card;
import dev.alex.cards.repository.CardRepository;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    CardRepository cardRepository;

    @Override
    public void saveNewCard(Card card) {
        cardRepository.save(card);
    }

    @Override
    public void deleteCard(Card card) {
        cardRepository.delete(card);
    }

    @Override
    public Card getCardById(long id) {
        Card card;
        Optional<Card> optional = cardRepository.findById(id);

        if (optional.isPresent()) {
            card = optional.get();
        } else {
            throw new RuntimeException(String.format("no this card: %d", id));
        }
        return card;
    }

    @Override
    public List<Card> getThemeCards() {
        return cardRepository.findAll();
    }

	@Override
	public boolean cardExists(Card card) {
		Optional<Card> opt = cardRepository.findById(card.getId());
		if(opt.isPresent()) {
			System.out.println("EXISTS!!!!!!!!!!!!");
			return true;
		}
		return false;
	}

}
