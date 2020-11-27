package edu.bu.met.cs665.example1.coffeeClasses;
import edu.bu.met.cs665.example1.Beverage;

public abstract class Coffee extends Beverage{

    private int sugar_count;
    private int milk_count;

    public int get_sugar_count() {
        return this.sugar_count;
    }

    public int set_sugar_count(int sugCount){
        this.sugar_count = sugCount;
        return sugCount;
    }

    public int get_milk_count() {
        return this.milk_count;
    }

    public int set_milk_count(int milkCount){
        this.sugar_count = milkCount;
        return sugar_count;
    }
}



