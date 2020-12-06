package edu.bu.met.cs665.customerQuestions;

import edu.bu.met.cs665.database.CategoryQuery;
import edu.bu.met.cs665.database.Query;
import edu.bu.met.cs665.database.QueryResults;
import edu.bu.met.cs665.searchBuilder.FoodSearch;
import edu.bu.met.cs665.searchBuilder.SearchBuilder;

import java.util.ArrayList;
import java.util.Scanner;

public class AskPriceRange extends QuestionCommand{

    SearchBuilder searchBuilder;
    //HASHMAP OF CUISINETYPES / MAYBE THIS IS A NEW CLASS
    ArrayList<String> priceRanges;

    public AskPriceRange(SearchBuilder searchBuilder){
        this.searchBuilder = searchBuilder;
        Query categoryQuery = new CategoryQuery("price_range");
        QueryResults queryResults = categoryQuery.executeQuery();
        this.priceRanges = queryResults.getCategoryResults();

        //this.priceRanges = new ArrayList<String>();
    /*    Syntax categorySyntax = new CategoryQuerySyntax();
        categorySyntax.setCategory("price_range");
        Query categoryQuery = new CategoryQuery(categorySyntax);
        categoryQuery.executeSQL();
        this.priceRanges= categoryQuery.getCategoryResults();*/

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
        System.out.println("Please select an average price range per person:");

        int orderNum = 1;

        for(String priceRange: priceRanges){
            System.out.println(orderNum + " - "+ priceRange);
            orderNum++;
        }
        Scanner scanner2 = new Scanner(System.in);  // Create a Scanner object
        int userInput2 = scanner2.nextInt();  // Read user input
        FoodSearch foodSearch = this.searchBuilder.setPriceRange(priceRanges.get(userInput2-1));

    }
}
