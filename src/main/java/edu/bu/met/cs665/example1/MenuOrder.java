package edu.bu.met.cs665.example1;
import edu.bu.met.cs665.example1.coffeeClasses.*;
import edu.bu.met.cs665.example1.teaClasses.*;

/*
    The MenuOrder class's purpose is to ask the customer for details of order.
    Then, these details are stored in a MenuOrder object as properties.
    These details are used to create a Beverage object that can be extended to Coffee and Tea subclasses.
 */

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;


public class MenuOrder {

    private String beverageType;
    private String beverageSubType;
    private int sugar_count;
    private int milk_count;

    public void setBeverageType(String beverageType) {
        this.beverageType = beverageType;
    }

    public void setBeverageSubType(String beverageSubType){
        this.beverageSubType = beverageSubType;
    }

    public void setSugar_count(int sugarCount){
        this.sugar_count = sugarCount;
    }

    public void setMilk_count(int milkCount){
        this.milk_count = milkCount;
    }
    // This method stores customer's choice of Coffee or Tea
    public void selectBeverage(){

        while(this.beverageType==null) {
            Scanner user_input = new Scanner(System.in);
            System.out.println("Welcome to the Fully Automatic Beverage Vending Machine!"+
                               "\nTo select Coffee, enter 1."+
                               "\nTo select Tea, please enter 2.");
            System.out.print("Enter Selection Here:");

            try {
                switch (user_input.nextInt()) {
                    case 1:
                        System.out.println("You picked Coffee.");
                        this.beverageType = "Coffee";
                        break;
                    case 2:
                        System.out.println("You picked tea.");
                        this.beverageType = "Tea";
                        break;
                    default:
                        System.out.println("Option is not on the menu. Please try again.\n----------\n\n");
                        break;
                }
            }catch (InputMismatchException e){
                System.out.println("Please try again and enter only a number.\n----------\n\n");
            }
        }

    }

    //This method stores customer's choices for type of coffee and type of tea.
    public void customizeBeverage() {

        while (this.beverageSubType == null) {
            Scanner user_input = new Scanner(System.in);
            switch (this.beverageType) {
                case "Coffee":
                    System.out.println("\nSelect below your coffee type:");
                    System.out.println("Espresso (Enter 1)\n" +
                            "Americano (Enter 2)\n" +
                            "Latte Macchiato (Enter 3)\n");
                    System.out.print("Enter Selection Number here:");

                    try {
                        switch (user_input.nextInt()) {
                            case 1:
                                System.out.println("You picked Espresso.");
                                this.beverageSubType = "Espresso";
                                break;
                            case 2:
                                System.out.println("You picked Americano.");
                                this.beverageSubType = "Americano";
                                break;
                            case 3:
                                System.out.println("You picked Latte Macchiato.");
                                this.beverageSubType = "Latte Macchiato";
                                break;
                            default:
                                System.out.println("Option is not on the menu. Please try again.\n----------\n\n");
                                break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Please try again and enter only a number.\n----------\n\n");
                    }
                    break;

                case "Tea":
                    System.out.println("Select below your tea type:");
                    System.out.println("Black Tea (Enter 1)\n" +
                            "Green Tea (Enter 2)\n" +
                            "Yellow Tea (Enter 3)\n" +
                            "Type Selection Number here:");

                    try {
                        switch (user_input.nextInt()) {
                            case 1:
                                System.out.println("You picked Black Tea.");
                                this.beverageSubType = "Black Tea";
                                break;
                            case 2:
                                System.out.println("You picked Green Tea.");
                                this.beverageSubType = "Green Tea";
                                break;
                            case 3:
                                System.out.println("You picked Yellow Tea.");
                                this.beverageSubType = "Yellow Tea";
                                break;
                            default:
                                System.out.println("Option is not on the menu. Please try again.\n----------\n\n");
                                break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Please try again and enter only a number.\n----------\n\n");
                    }
                    break;
                default:
                    break;
            }
        }

        /* The requirements say the coffee machine gives sugar and milk.
           We assume sugar and milk is only available for coffee.
           If coffee is chosen, the below code will execute methods to add sugar and add milk if customer wants to customize this.
         */
        if (this.beverageType.equals("Coffee")) {

            Scanner user_input = new Scanner(System.in);

            System.out.println("Your current coffee order has:\n"+
                    this.sugar_count+" tablespoons of sugars\n"+
                    this.milk_count+" tablespoons milk\n"+
                    "If you would like more sugar, type 1\n"+
                    "If you are fine with the sugar amount, type 2 to continue.");

            try {
                switch (user_input.nextInt()) {
                    case 1:
                        addSugar();
                        break;
                    case 2:
                        addMilk();
                        break;
                    default:
                        addSugar();
                        break;
                }
            } catch (InputMismatchException e) {
            System.out.println("Please try again and enter only a number.\n----------\n\n");
            }

        }else{
            //If customer chose Tea, customer skips to the final step of receiving an order summary
            summarizeOrder();
        }
    }

    /*Below method ensures sugar does not exceed 3 tablespoons and is not negative tablespoons.
      Customer can increment or decrement until exiting the loop.
     */
    public void addSugar(){
        Scanner user_input = new Scanner(System.in);

        boolean continueAdding = true;


        while(continueAdding) {
            System.out.println("Please enter the number of tablespoons of sugar you'd like to add.\n"+
                "Note: You can have a max number of 3 tablespoons of sugar. You currently have "+sugar_count+"." +
                    "\nTo decrease amount of sugar, put a minus sign in front of your value.");
            System.out.print("Enter amount here:");

            try {
                int new_sugar = user_input.nextInt();
                if (new_sugar + this.sugar_count <= 3 && new_sugar + this.sugar_count >=0) {
                    this.sugar_count += new_sugar;
                    System.out.println("You added "+new_sugar+" tablespoons of sugar.\n"+
                            "You now have "+this.sugar_count+" total tablespoons of sugar.\n"+
                            "Would you like to add more sugar?\n" +
                            "Enter 1 for yes.\nEnter 2 for no.");
                    Scanner user_input2 = new Scanner(System.in);
                    if (user_input2.nextInt() == 2) {
                        continueAdding = false;

                    }

                } else if(new_sugar + this.sugar_count > 3){
                    System.out.println("Your order exceeds the maximum 3 tablespoons of sugar. Try again:\n\n");

                }else if(new_sugar+this.sugar_count <0 ){
                    System.out.println("You cannot have less than 0 tablespoons of sugar. Try again:\n\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please try again and enter only a number.\n----------\n\n");
            }
        }

        //Once sugar customization is complete, user is automatically taken to milk customization
        addMilk();

    }

    /*Below method ensures milk does not exceed 3 tablespoons and is not negative tablespoons.
      Customer can increment or decrement until exiting the loop.
     */
    public void addMilk(){
        Scanner user_input = new Scanner(System.in);

        System.out.println("Your current coffee order has:\n"+
                this.sugar_count+" tablespoons of sugars\n"+
                this.milk_count+" tablespoons milk\n"+
                "If you would like more milk, type 1\n"+
                "If you are fine with the milk amount, type 2 to continue.");

        try {
            if(user_input.nextInt()==1) {
                boolean continueAdding = true;
                while(continueAdding) {
                    System.out.println("Please enter the number of tablespoons of milk you'd like to add.\n" +
                            "Note: You can have a max number of 3 tablespoons of milk. You currently have " + milk_count + "." +
                            "\nTo decrease amount of milk, put a minus sign in front of your value.");
                    System.out.print("Enter amount here:");

                    try {
                        int new_milk = user_input.nextInt();
                        if (new_milk + this.milk_count <= 3 && new_milk + this.milk_count >= 0) {
                            this.milk_count += new_milk;
                            System.out.println("You added " + new_milk + " tablespoons of milk.\n" +
                                    "You now have " + this.milk_count + " total tablespoons of milk.\n" +
                                    "Would you like to add more milk?\n" +
                                    "Enter 1 for yes.\nEnter 2 for no.");
                            Scanner user_input2 = new Scanner(System.in);
                            if (user_input2.nextInt() == 2) {
                                continueAdding = false;

                            }

                        } else if (new_milk + this.milk_count > 3) {
                            System.out.println("Your order exceeds the maximum 3 tablespoons of milk. Try again:\n\n");

                        } else if (new_milk + this.milk_count < 0) {
                            System.out.println("You cannot have less than 0 tablespoons of milk. Try again:\n\n");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Please try again and enter only a number.\n----------\n\n");
                    }

                }

            }else{
                //After milk customization is complete, user is given a final summary of order
                summarizeOrder();
            }
        } catch (InputMismatchException e) {
            System.out.println("Please try again and enter only a number.\n----------\n\n");
        }

    }

    // Below method print order summary with sugar and milk details.
    public void summarizeOrder(){
            System.out.println("Thank you for placing your order! You have ordered:");
            if(this.beverageType.equals("Coffee")){
                System.out.println("One "+this.beverageSubType+ " with "+this.sugar_count+" TBS of sugar"+
                        " and "+this.milk_count+" TBS of milk. Please wait while we create your order.");
            }else{
                System.out.println("One "+this.beverageSubType+ ". Please wait while we create your order.");
            }
        }

    /*Below method creates a Coffee or Tea subclass object per specifications of the order.
      Case statement controls which subtype is created. This subtype object is assigned to a Beverage object.
      The setOrderAttribute method passes properties from MenuOrder into the Beverage object.
      This Beverage object is passed back to the Main class.
    */
    public Beverage createOrder() {

        Beverage newOrder;

        switch (this.beverageSubType) {
            case "Espresso":
                Espresso newEspresso = new Espresso();
                newOrder = newEspresso;
                break;
            case "Americano":
                Americano newAmericano = new Americano();
                newOrder = newAmericano;
                break;
            case "Latte Macchiato":
                LatteMacchiato newLatte = new LatteMacchiato();
                newOrder = newLatte;
                break;
            case "Black Tea":
                BlackTea newBlackTea = new BlackTea();
                newOrder = newBlackTea;
                break;
            case "Green Tea":
                GreenTea newGreenTea = new GreenTea();
                newOrder = newGreenTea;
                break;
            case "Yellow Tea":
                YellowTea newYellowTea = new YellowTea();
                newOrder = newYellowTea;
                break;
            default:
                LatteMacchiato newLatteDefault = new LatteMacchiato();
                newOrder = newLatteDefault;
                break;


        }


        return setOrderAttributes(newOrder);



    }

    public Beverage setOrderAttributes(Beverage newOrder){
        newOrder.setBeverageType(this.beverageType);
        newOrder.setBeverageSubType(this.beverageSubType);
        newOrder.set_sugar_count(this.sugar_count);
        newOrder.set_milk_count(this.milk_count);
        return newOrder;
    }


}




