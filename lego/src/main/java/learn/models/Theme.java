package learn.models;

import java.util.Objects;

public class Theme {
    int themeId;
    String themeName;

    public Theme(){
    }

    public Theme(int themeId, String themeName) {
        this.themeId = themeId;
        this.themeName = themeName;
    }

    public int getThemeId() {
        return themeId;
    }

    public void setThemeId(int themeId) {
        this.themeId = themeId;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Theme theme = (Theme) o;
        return themeId == theme.themeId && Objects.equals(themeName, theme.themeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(themeId, themeName);
    }
}
