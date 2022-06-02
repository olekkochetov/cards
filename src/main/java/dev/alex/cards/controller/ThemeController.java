package dev.alex.cards.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dev.alex.cards.model.Theme;
import dev.alex.cards.service.ThemeService;

@Controller
public class ThemeController {
    @Autowired
    ThemeService themeService;

    @GetMapping("/")
    public String getAllThemes(Model model) {
        List<Theme> themes = themeService.getAllThemes();
        model.addAttribute("listThemes", themes);
        return "index";
    }

    @GetMapping("/theme-{id}/{name}")
    public String getTheme(@PathVariable(value = "id") long id, @PathVariable(value = "name") String name,
            Model model) {
        Theme theme = themeService.getThemeById(id);
        model.addAttribute("theme", theme);
        model.addAttribute("listThemeCards", theme.getCards());
        return "theme";
    }
    
    @GetMapping("/addNewTheme")
    public String addNewTheme(Model model) {
    	Theme theme = new Theme();
    	model.addAttribute("theme", theme);
    	return "add_theme";
    }
    
    @PostMapping("/saveTheme")
    public String saveTheme(@ModelAttribute("t") Theme theme) {
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
