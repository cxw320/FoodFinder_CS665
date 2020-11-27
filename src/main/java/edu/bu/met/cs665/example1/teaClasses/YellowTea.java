package edu.bu.met.cs665.example1.teaClasses;

/*
    The Yellow Tea class is a subclass of Tea.
    Price is the unique static property of this class.
 */

public class YellowTea extends Tea{
    private static double price = 1.99;

    public double getPrice(){
        return price;
    }
}
