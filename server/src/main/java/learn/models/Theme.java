package learn.models;

import java.util.Objects;

public class Theme {
    int themeId;
    String themeName;
    String themeDescription;
    String themeUrl;

    public Theme(){
    }

    public Theme(int themeId, String themeName, String themeDescription, String themeUrl) {
        this.themeId = themeId;
        this.themeName = themeName;
        this.themeDescription = themeDescription;
        this.themeUrl = themeUrl;
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

    public String getThemeDescription() {
        return themeDescription;
    }

    public void setThemeDescription(String themeDescription) {
        this.themeDescription = themeDescription;
    }

    public String getThemeUrl() {
        return themeUrl;
    }

    public void setThemeUrl(String themeUrl) {
        this.themeUrl = themeUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Theme theme = (Theme) o;
        return themeId == theme.themeId && Objects.equals(themeName, theme.themeName) && Objects.equals(themeDescription, theme.themeDescription) && Objects.equals(themeUrl, theme.themeUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(themeId, themeName, themeDescription, themeUrl);
    }
}
