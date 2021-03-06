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
        model.addAttribute("subtitle", card.getTheme().getName());
        model.addAttribute("pageTitle", card.getQuestion());
        model.addAttribute("card", card);

        return "card";
    }

    @PostMapping("/saveCard")
    public String saveCard(@ModelAttribute("card") Card card) {
    	String stringToReturn = "";
        Theme theme = card.getTheme();
        String themeName = theme.getName();
        long themeId = theme.getId();
        
        if(cardService.cardExists(card)) {
        	stringToReturn = "redirect:/" + themeName + "/box-" + card.getBox().getId();
        }
        else {
        	stringToReturn = "redirect:/theme-" + themeId + "/" + themeName;
        }
        
        cardService.saveNewCard(card);
        return stringToReturn;
    }
    
    
    @GetMapping("/deleteCard/{themeName}/{id}")
    public String deleteCard(@PathVariable(value="id") long id, @PathVariable(value="themeName") String themeName) {
    	Theme theme = themeServcie.findThemeByName(themeName);
    	Card card = cardService.getCardById(id);
    	cardService.deleteCard(card);
    	return "redirect:/" + themeName + "/box-" + card.getBox().getId();
    }
    
    @GetMapping("/updateCardForm/{themeName}/{id}")
    public String showUpdateCardForm(@PathVariable(value="id") long id, @PathVariable(value="themeName") String themeName, Model model) {
    	Theme theme = themeServcie.findThemeByName(themeName);
    	Card card = cardService.getCardById(id);
    	model.addAttribute("card", card);
    	model.addAttribute("theme", theme);
    	return "update_card";
    }
    
    @PostMapping("/updateCard/{themeName}/{id}")
    public String updateCard(@PathVariable(value="id") long id, @PathVariable(value="themeName") String themeName) {
    	Theme theme = themeServcie.findThemeByName(themeName);
    	Card card = cardService.getCardById(id);
    	cardService.saveNewCard(card);
    	return "redirect:/" + themeName + "/box-" + card.getBox().getId();
    }
}
