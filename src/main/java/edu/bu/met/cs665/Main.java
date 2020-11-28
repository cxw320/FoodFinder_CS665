package edu.bu.met.cs665;

// import org.apache.log4j.PropertyConfigurator;

import edu.bu.met.cs665.database.Query;
import edu.bu.met.cs665.database.SQLConnection;

public class Main {


  public static void main(String[] args) throws Exception {

    Query query = new Query();
    query.get();

    CustomerUI customerUI = new CustomerUI();

    System.out.println("Welcome to the FoodFinder!");
    customerUI.takeCustomerOrder();


  }

}
