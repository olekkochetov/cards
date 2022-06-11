package dev.alex.cards.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.alex.cards.model.Box;
import dev.alex.cards.model.Card;
import dev.alex.cards.repository.BoxRepository;

@Service
public class BoxServiceImpl implements BoxService {
    @Autowired
    BoxRepository boxRepository;
    private LocalDateTime creationTime;
    private int numberCards = 10;
    Box box;

    public BoxServiceImpl() {
        super();
    }

    public BoxServiceImpl(BoxRepository boxRepository) {
        super();
        this.boxRepository = boxRepository;
    }

    @Override
    public List<Card> getCardsToLearn() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getElementsNumber(long boxId) {
        box = getBoxById(boxId);
        box.getElementsCounter();
        return 0;
    }

    @Override
    public void saveBox(Box box) {
        // boxRepository.findBy(null, null)
        boxRepository.save(box);
    }

    @Override
    public List<Card> getAllCardsInBox(long boxId) {
        Box box = getBoxById(boxId);
        return box.getCards();
    }

    @Override
    public Box getBoxById(long boxId) {
        Optional<Box> optional = boxRepository.findById(boxId);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new RuntimeException("there is no Box with this id: " + boxId);
        }
    }

    @Override
    public long countBoxes() {
        return boxRepository.count();
    }

    @Override
    public List<Box> getAllBoxes() {
        return boxRepository.findAll();
    }

    @Override
    public void addCardToBox(long boxId, Card card) {
        box = getBoxById(boxId);
        card.setBox(box);
    }
}
