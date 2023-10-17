package learn.models;

import java.util.Objects;

public class LegoMiniFigure {
    int figureId;
    String figureName;
    int amountOfPieces;
    String imageUrl;
    int themeId;


    public LegoMiniFigure(){
    }

    public LegoMiniFigure(int figureId, String figureName, int amountOfPieces, String imageUrl, int themeId) {
        this.figureId = figureId;
        this.figureName = figureName;
        this.amountOfPieces = amountOfPieces;
        this.imageUrl = imageUrl;
        this.themeId = themeId;
    }

    public int getFigureId() {
        return figureId;
    }

    public void setFigureId(int figureId) {
        this.figureId = figureId;
    }

    public String getFigureName() {
        return figureName;
    }

    public void setFigureName(String figureName) {
        this.figureName = figureName;
    }

    public int getAmountOfPieces() {
        return amountOfPieces;
    }

    public void setAmountOfPieces(int amountOfPieces) {
        this.amountOfPieces = amountOfPieces;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getThemeId() {
        return themeId;
    }

    public void setThemeId(int themeId) {
        this.themeId = themeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LegoMiniFigure that = (LegoMiniFigure) o;
        return figureId == that.figureId && amountOfPieces == that.amountOfPieces && themeId == that.themeId && Objects.equals(figureName, that.figureName) && Objects.equals(imageUrl, that.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(figureId, figureName, amountOfPieces, imageUrl, themeId);
    }
}
