package dev.alex.cards.service;

import java.util.List;

import dev.alex.cards.model.Theme;

public interface ThemeService {
	void addTheme(Theme theme);
	void deletTheme(Theme theme);
	void updateTheme(Theme theme);
	List<Theme> getAllThemes();
	Theme getThemeById(int id);
}
