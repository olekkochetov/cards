package dev.alex.cards.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class  Box {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(name="repeat_in")
	private int amountDays;
    @OneToMany(mappedBy = "box", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Card> cards = new ArrayList<>();
	@Transient
	private int elementsCounter;
	
	public Box() {}
	public Box(String name, int amountDays) {
		super();
		this.name = name;
		this.amountDays = amountDays;
	}
	
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getAmountDays() {
		return amountDays;
	}
	public void setAmountDays(int amountDays) {
		this.amountDays = amountDays;
	}

	public int getElementsCounter() {
		return elementsCounter;
	}
	public void setElementsCounter(int elementsCounter) {
		this.elementsCounter = elementsCounter;
	}
	public List<Card> getCards() {
		return cards;
	}
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
}
