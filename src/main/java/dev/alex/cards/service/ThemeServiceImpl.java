package dev.alex.cards.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.alex.cards.model.Theme;
import dev.alex.cards.repository.ThemeRepository;

@Service
public class ThemeServiceImpl implements ThemeService {
    @Autowired
    ThemeRepository themeRepository;

    @Override
    public void saveTheme(Theme theme) {
        themeRepository.save(theme);
    }

    @Override
    public void deleteTheme(Theme theme) {
        themeRepository.delete(theme);
    }

    @Override
    public List<Theme> getAllThemes() {
        return themeRepository.findAll();
    }

    @Override
    public Theme getThemeById(long id) {
        Optional<Theme> optional = themeRepository.findById(id);
        Theme theme;
        if (optional.isPresent()) {
            theme = optional.get();
        } else {
            throw new RuntimeException(String.format("No this theme: %d", id));
        }

        return theme;
    }

	@Override
	public Theme findThemeByName(String name) {
		return themeRepository.findThemeByName(name);
	}
}
