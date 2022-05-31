package dev.alex.cards.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="learning_cards")
public class Card {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String question;
	private String answer;
	@ManyToOne
	@JoinColumn(name="theme_id")
	private Theme theme;
	
	public Card() {}
	public Card(String question, String answer, Theme theme) {
		super();
		this.question = question;
		this.answer = answer;
		this.theme = theme;
	}
	
	public Card(String question, Theme theme) {
		this(question, null, theme);
	}

	public long getId() {
		return id;
	}

	public String getQuestion() {
		return question;
	}

	public String getAnswer() {
		return answer;
	}
	
}
