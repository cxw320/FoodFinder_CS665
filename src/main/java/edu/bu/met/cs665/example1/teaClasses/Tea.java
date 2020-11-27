package edu.bu.met.cs665.example1.teaClasses;

/*
    Tea is a subclass of Beverage.
    We assume Tea is made without sugar and milk so these properties are static null.
    Setter and getter methods are provided since MenuOrder class calls this.
 */


import edu.bu.met.cs665.example1.Beverage;

public abstract class Tea extends Beverage{
    private static int sugar_count=0;
    private static int milk_count=0;

    public int get_sugar_count() {
        return sugar_count;
    }

    public int set_sugar_count(int sugCount){
        sugar_count = sugCount;
        return sugCount;
    }

    public int get_milk_count() {
        return milk_count;
    }

    public int set_milk_count(int milkCount){
        sugar_count = milkCount;
        return sugar_count;
    }


}