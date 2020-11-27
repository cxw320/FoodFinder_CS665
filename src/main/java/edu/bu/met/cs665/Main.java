package edu.bu.met.cs665;

import edu.bu.met.cs665.example1.MenuOrder;
import edu.bu.met.cs665.example1.*;

import org.apache.log4j.Logger;
// import org.apache.log4j.PropertyConfigurator;

public class Main {

  private static Logger logger = Logger.getLogger(Main.class);


  /**
   * A main method to run examples.
   *
   * @param args not used
   *
   */



  public static void main(String[] args) {

    // This configuration is for setting up the log4j properties file.
    // It is better to set this using java program arguments.
    // PropertyConfigurator.configure("log4j.properties");

    // Let us create an object of the Main class.
    Main m = new Main();

    //New menu order is created
    MenuOrder newOrder = new MenuOrder();

    // User selects and customizes a beverage
    newOrder.selectBeverage();
    newOrder.customizeBeverage();

    /* Using the properties of the MenuOrder object, a tea or coffee subclass object is created.
       It is passed back to this main method and stored as "finalOrder".
       Since coffee and tea subclasses all extend the abstract class Beverage, we do not have to specify whether this is tea or coffee in the main method.
    */
    Beverage finalOrder = newOrder.createOrder();

    // Print out confirmation that the beverage object has been created and prints out price
    System.out.println("Your final order is "+finalOrder.getBeverageSubType() +
            " and it costs " + finalOrder.getPrice());


    /*
    logger.info(m.doIt());

    logger.trace("Trace Message!");
    logger.debug("Debug Message!");
    logger.info("Info Message!");
    logger.warn("Warn Message!");
    logger.error("Error Message!");
    logger.fatal("Fatal Message!");*/

  }




}
