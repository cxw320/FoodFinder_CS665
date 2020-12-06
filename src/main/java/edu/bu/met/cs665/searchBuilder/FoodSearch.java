package edu.bu.met.cs665.searchBuilder;

import java.util.ArrayList;
import java.util.HashMap;

public class FoodSearch {

    HashMap<String,String> searchCriteria;

    public FoodSearch(){
      searchCriteria = new HashMap<String,String>();
    }

    public void setLocation(String location) {
        searchCriteria.put("location",location);
    }

    public void setCuisineType(String cuisineType) {
        searchCriteria.put("cuisine_type",cuisineType);
    }

    public void setPriceRange(String priceRange) {
        searchCriteria.put("price_range",priceRange);
    }

    public String getLocation() {
        return searchCriteria.get("location");
    }

    public String getCuisineType() {
        return searchCriteria.get("cuisine_type");
    }

    public String getPriceRange() {
        return searchCriteria.get("price_range");
    }

    public HashMap<String, String> getSearchCriteria(){
        return searchCriteria;
    }
}
