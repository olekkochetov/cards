package dev.alex.cards.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import dev.alex.cards.model.Card;
import dev.alex.cards.service.CardService;

@Controller
public class CardController {
	@Autowired
	CardService cardService;
	
	@GetMapping("card-{id}")
	public String getCard(@PathVariable(value="id") long id, Model model) {
		Card card = cardService.getCardById(id);
		model.addAttribute("card", card);
		return "card";
	}
}
