package learn.data;

import learn.models.Theme;

import java.util.List;

public interface ThemeRepository {
    List<Theme> findAll();
    Theme findById(int themeId);
}
