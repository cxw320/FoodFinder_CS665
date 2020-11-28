package edu.bu.met.cs665;

public class FoodSearch {

    private String location;
    private String cuisineType;
    private String priceRange;
    private String menuItem;
    private String vegetarian;

    public FoodSearch(){}

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    public String getLocation() {
        return location;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public String getPriceRange() {
        return priceRange;
    }
}
