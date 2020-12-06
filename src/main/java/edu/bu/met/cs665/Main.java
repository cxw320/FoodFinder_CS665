package edu.bu.met.cs665;

import edu.bu.met.cs665.database.sql.SourceData;

public class Main {

  public static void main(String[] args) throws Exception {

    //Read restaurant data from text file and store to Database
    SourceData sourceData = new SourceData();
    sourceData.clearData();
    sourceData.readFile();

    //Execute the user-facing portion of the program
    CustomerUI customerUI = new CustomerUI();
    System.out.println("Welcome to the FoodFinder!");
    customerUI.takeCustomerOrder();

  }

}
