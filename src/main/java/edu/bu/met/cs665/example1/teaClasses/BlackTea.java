package edu.bu.met.cs665.example1.teaClasses;

/*
    The Black Tea class is a subclass of Tea.
    Price is the unique static property of this class.
 */

public class BlackTea extends Tea{
    private static double price = 1.75;

    public double getPrice(){
        return price;
    }
}
