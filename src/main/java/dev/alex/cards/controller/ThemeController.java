package dev.alex.cards.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dev.alex.cards.model.Box;
import dev.alex.cards.model.Card;
import dev.alex.cards.model.Theme;
import dev.alex.cards.service.BoxService;
import dev.alex.cards.service.ThemeService;

@Controller
public class ThemeController {
    @Autowired
    ThemeService themeService;
    @Autowired
    BoxService boxService;

    @GetMapping("/")
    public String getAllThemes(Model model) {
        List<Theme> themes = themeService.getAllThemes();
        model.addAttribute("pageTitle", "Home");
        model.addAttribute("listThemes", themes);
        return "index";
    }

    @GetMapping("/theme-{id}/{name}")
    public String getTheme(@PathVariable(value = "id") long id, @PathVariable(value = "name") String name,
            Model model) {
        Theme theme = themeService.getThemeById(id);
        Box box = boxService.getBoxById(1);
        Card card = new Card();
        model.addAttribute("theme", theme);
        model.addAttribute("subtitle", "Theme");
        model.addAttribute("pageTitle", name);
        model.addAttribute("card", card);
        model.addAttribute("listThemes", themeService.getAllThemes());
        model.addAttribute("listBoxes", boxService.getAllBoxes());
        model.addAttribute("box", box);
        card.setBox(box);
        card.setTheme(theme);
        return "theme";
    }

    @GetMapping("/addNewTheme")
    public String addNewTheme(Model model) {
        Theme theme = new Theme();
        model.addAttribute("pageTitle", "Add New Theme");
        model.addAttribute("theme", theme);
        return "add_theme";
    }

    @PostMapping("/saveTheme")
    public String saveTheme(@ModelAttribute("theme") Theme theme) {
        themeService.saveTheme(theme);
        return "redirect:/";
    }

    @GetMapping("/deleteTheme/{id}")
    public String deleteTheme(@PathVariable("id") long id) {
        Theme theme = themeService.getThemeById(id);
        themeService.deleteTheme(theme);
        return "redirect:/";
    }

}
