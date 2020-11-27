package edu.bu.met.cs665;

import edu.bu.met.cs665.example1.Beverage;
import edu.bu.met.cs665.example1.MenuOrder;
import edu.bu.met.cs665.example1.coffeeClasses.Americano;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class MenuOrderTest {

    @Test
    public void createOrderTest() {

        Beverage testBeverage = new Americano();
        testBeverage.set_milk_count(2);
        testBeverage.set_sugar_count(2);
        testBeverage.setBeverageType("Coffee");
        testBeverage.setBeverageSubType("Americano");

        MenuOrder testOrder = new MenuOrder();
        testOrder.setBeverageType("Coffee");
        testOrder.setBeverageSubType("Americano");
        testOrder.setMilk_count(2);
        testOrder.setSugar_count(2);

        assertEquals(testBeverage.getBeverageSubType(),testOrder.createOrder().getBeverageSubType());
    }

    @Test
    public void setOrderAttributesTest() {

        Beverage testBeverage = new Americano();
        testBeverage.set_milk_count(2);
        testBeverage.set_sugar_count(2);
        testBeverage.setBeverageType("Coffee");
        testBeverage.setBeverageSubType("Americano");

        MenuOrder testOrder = new MenuOrder();

        assertEquals(testBeverage,testOrder.setOrderAttributes(testBeverage));
    }
}