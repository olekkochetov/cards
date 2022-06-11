package dev.alex.cards.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import dev.alex.cards.model.Box;
import dev.alex.cards.service.BoxService;

@Controller
public class BoxController {
    @Autowired
    BoxService boxService;
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

    @GetMapping("")
    public String showAllCardsInBox() {
        return "";
    }
}
