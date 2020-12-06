package edu.bu.met.cs665.database;

public class Restaurant {

    private int id;
    private String name;
    private String location;
    private String cuisine_type;
    private String price_range;

    public Restaurant(){}

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCuisine_type(String cuisine_type) {
        this.cuisine_type = cuisine_type;
    }

    public void setPrice_range(String price_range) {
        this.price_range = price_range;
    }

    public int getId() {
        return id;
    }

    public String getName() {return name;}

    public String getLocation() {
        return location;
    }

    public String getCuisine_type() {
        return cuisine_type;
    }

    public String getPrice_range() {
        return price_range;
    }

}
