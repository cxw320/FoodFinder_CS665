package edu.bu.met.cs665.example1.teaClasses;
/*
    The Green Tea class is a subclass of Tea.
    Price is the unique static property of this class.
 */

public class GreenTea extends Tea{
    private static double price = 1.5;

    public double getPrice(){
        return price;
    }
}
