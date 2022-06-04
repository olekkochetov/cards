package dev.alex.cards.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "learning_cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String question;
    private String answer;
    @ManyToOne
    @JoinColumn(name = "theme_id")
    private Theme theme;

    public Card() {
    }

    public Card(String question, String answer, Theme theme) {
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

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
    
}
