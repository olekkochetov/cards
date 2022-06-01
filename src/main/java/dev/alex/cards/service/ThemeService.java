package dev.alex.cards.service;

import java.util.List;

import dev.alex.cards.model.Theme;

public interface ThemeService {
	void saveTheme(Theme theme);
	void deleteTheme(Theme theme);
	List<Theme> getAllThemes();
	Theme getThemeById(long id);
}
