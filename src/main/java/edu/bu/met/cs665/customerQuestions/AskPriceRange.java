package edu.bu.met.cs665.customerQuestions;

import edu.bu.met.cs665.FoodSearch;
import edu.bu.met.cs665.SearchBuilder;

import java.util.ArrayList;
import java.util.Scanner;

public class AskPriceRange extends QuestionCommand{

    SearchBuilder searchBuilder;
    //HASHMAP OF CUISINETYPES / MAYBE THIS IS A NEW CLASS
    ArrayList<String> priceRanges = new ArrayList<String>();

    public AskPriceRange(SearchBuilder searchBuilder){
        this.searchBuilder = searchBuilder;
        priceRanges.add("Less than $20");
        priceRanges.add("$20 - $30");
        priceRanges.add("$30+");

    }

    public SearchBuilder execute(){

        System.out.println("Would you like to add a price range to your search?"+
                "\nType 1 for Yes"+
                "\nType 2 for No");

        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        int userInput = scanner.nextInt();  // Read user input

        if(userInput==1){
            questionScript();
        }else if(userInput==2){
        }else{
            System.out.println("Invalid input. Please try again:");
            execute();
        }
        return searchBuilder;
    }


    public void questionScript(){
        System.out.println("Please select an average price range per person:"+
                "\n 1 - Less than $20"+
                "\n 2 - $20 - $30"+
                "\n 3 - $30+");
        Scanner scanner2 = new Scanner(System.in);  // Create a Scanner object
        int userInput2 = scanner2.nextInt();  // Read user input
        FoodSearch foodSearch = this.searchBuilder.setPriceRange(priceRanges.get(userInput2-1));

    }
}
