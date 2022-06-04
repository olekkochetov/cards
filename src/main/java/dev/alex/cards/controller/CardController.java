package dev.alex.cards.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dev.alex.cards.model.Card;
import dev.alex.cards.model.Theme;
import dev.alex.cards.service.CardService;
import dev.alex.cards.service.ThemeService;

@Controller
public class CardController {
    @Autowired
    CardService cardService;
    
    @Autowired
    ThemeService themeServcie;
    @GetMapping("card-{id}")
    public String getCard(@PathVariable(value = "id") long id, Model model) {
        Card card = cardService.getCardById(id);
        model.addAttribute("card", card);
        return "card";
    }
    
    @GetMapping("/theme-{id}/newCard")
    public String addNewcard(@PathVariable(value="id") long id, Model model) {
        Theme theme =  themeServcie.getThemeById(id);
        Card card = new Card();
        model.addAttribute("theme", theme );
        model.addAttribute("card", card );
        card.setTheme(theme);
    	return "add_card";
    }
    
    @PostMapping("/saveCard")
    public String saveCard(@ModelAttribute("card") Card card) {
    	cardService.saveNewCard(card);
    	return "redirect:/";
    }
}
