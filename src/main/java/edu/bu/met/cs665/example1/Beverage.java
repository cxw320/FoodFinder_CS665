package edu.bu.met.cs665.example1;

public abstract class Beverage{

    private String beverageType;
    private String beverageSubType;
    private double price;

    public String getBeverageType(){
        return beverageType;
    }
    public void setBeverageType(String bevType){
        beverageType = bevType;
    }
    public String getBeverageSubType(){
        return beverageSubType;
    }

    public void setBeverageSubType(String bevSubType){
        beverageSubType = bevSubType;
    }

    public abstract double getPrice();
    public abstract int set_sugar_count(int sugar_count);
    public abstract int set_milk_count(int milk_count);
}
