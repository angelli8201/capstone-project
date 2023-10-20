package learn.models;

import java.util.Objects;

public class LegoSet {
    String legoSetId;
    String setName;
    int amountOfPieces;
    double price;
    String ages;
    String imageUrl;
    int themeId;
    String description;
    double rating;

    public LegoSet(){}
    public LegoSet(String legoSetId, String setName, int amountOfPieces, double price, String ages, String imageUrl, int themeId, String description, double rating) {
        this.legoSetId = legoSetId;
        this.setName = setName;
        this.amountOfPieces = amountOfPieces;
        this.price = price;
        this.ages = ages;
        this.imageUrl = imageUrl;
        this.themeId = themeId;
        this.description = description;
        this.rating = rating;
    }

    public String getLegoSetId() {
        return legoSetId;
    }

    public void setLegoSetId(String legoSetId) {
        this.legoSetId = legoSetId;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public int getAmountOfPieces() {
        return amountOfPieces;
    }

    public void setAmountOfPieces(int amountOfPieces) {
        this.amountOfPieces = amountOfPieces;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAges() {
        return ages;
    }

    public void setAges(String ages) {
        this.ages = ages;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LegoSet legoSet = (LegoSet) o;
        return amountOfPieces == legoSet.amountOfPieces && Double.compare(price, legoSet.price) == 0 && themeId == legoSet.themeId && Double.compare(rating, legoSet.rating) == 0 && Objects.equals(legoSetId, legoSet.legoSetId) && Objects.equals(setName, legoSet.setName) && Objects.equals(ages, legoSet.ages) && Objects.equals(imageUrl, legoSet.imageUrl) && Objects.equals(description, legoSet.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(legoSetId, setName, amountOfPieces, price, ages, imageUrl, themeId, description, rating);
    }
}
