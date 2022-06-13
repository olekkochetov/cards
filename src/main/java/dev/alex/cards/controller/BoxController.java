package dev.alex.cards.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import dev.alex.cards.model.Box;
import dev.alex.cards.model.Card;
import dev.alex.cards.model.Theme;
import dev.alex.cards.service.BoxService;
import dev.alex.cards.service.ThemeService;

@Controller
public class BoxController {
    @Autowired
    BoxService boxService;
    @Autowired
    ThemeService themeService;
    
    private int totalAmountBoxes = 5;

    @GetMapping("/createBoxes")
    public String createBoxes() {
        if (boxService.countBoxes() != totalAmountBoxes) {
            boxService.saveBox(new Box("New Cards", 0));
            boxService.saveBox(new Box("Next Day", 1));
            boxService.saveBox(new Box("Day 4", 4));
            boxService.saveBox(new Box("Next Week", 7));
            boxService.saveBox(new Box("Next Month", 30));
        }
        return "redirect:/";
    }

    @GetMapping("/{theme}/box-{boxId}")
    public String showAllCardsInBox(@PathVariable(value="theme") String themeName, @PathVariable(value="boxId") long boxId, Model model) {
    	Box box = boxService.getBoxById(boxId);
    	Theme theme =themeService.findThemeByName(themeName);
    	List<Card> cardsOfTheBox = box.getCardsByTheme(theme);
    	model.addAttribute(theme);
    	model.addAttribute("pageTitle", theme.getName());
    	model.addAttribute("cardList", cardsOfTheBox);
        return "cards_list";
    }
}
