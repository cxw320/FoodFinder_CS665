package edu.bu.met.cs665.database;

import java.util.ArrayList;

public class QueryResults {

    private ArrayList<String> categoryResults;
    private ArrayList<Restaurant> restaurantResults;

    public QueryResults(){}

    public void setCategoryResults(ArrayList<String> categoryResults) {
        this.categoryResults = categoryResults;
    }

    public void setRestaurantResults(ArrayList<Restaurant> restaurantResults) {
        this.restaurantResults = restaurantResults;
    }

    public ArrayList<String> getCategoryResults() {
        return categoryResults;
    }

    public ArrayList<Restaurant> getRestaurantResults() {
        return restaurantResults;
    }
}
