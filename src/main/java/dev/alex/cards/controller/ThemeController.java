package dev.alex.cards.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
	
	@GetMapping("/{id}")
	public String getTheme(@PathVariable(value="id") long id, Model model) {
		Theme theme = themeService.getThemeById(id);
		model.addAttribute("theme", theme);
		model.addAttribute("listThemeCards", theme.getCards());
		return "theme";
	}
}
