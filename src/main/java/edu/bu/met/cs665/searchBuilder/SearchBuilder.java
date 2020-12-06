package edu.bu.met.cs665.searchBuilder;

import edu.bu.met.cs665.searchBuilder.FoodSearch;

public class SearchBuilder {

    private FoodSearch foodSearch;

    public SearchBuilder(){
        this.foodSearch = new FoodSearch();
    }

    public FoodSearch setLocation(String location){
        this.foodSearch.setLocation(location);
        return this.foodSearch;
    }

    public FoodSearch setCuisineType(String cuisine){
        this.foodSearch.setCuisineType(cuisine);
        return this.foodSearch;
    }

    public FoodSearch setPriceRange(String priceRange){
        this.foodSearch.setPriceRange(priceRange);
        return this.foodSearch;
    }

    public FoodSearch build(){
        return this.foodSearch;
    }

}
