package edu.bu.met.cs665.customerQuestions;

import edu.bu.met.cs665.database.CategoryQuery;
import edu.bu.met.cs665.database.Query;
import edu.bu.met.cs665.database.QueryResults;
import edu.bu.met.cs665.searchBuilder.FoodSearch;
import edu.bu.met.cs665.searchBuilder.SearchBuilder;

import java.util.ArrayList;
import java.util.Scanner;

public class AskCuisineType extends QuestionCommand{

    SearchBuilder searchBuilder;
    //HASHMAP OF CUISINETYPES / MAYBE THIS IS A NEW CLASS
    ArrayList<String> cuisineOptions;


    public AskCuisineType(SearchBuilder searchBuilder){
        this.searchBuilder = searchBuilder;
        //this.cuisineOptions = new ArrayList<String>();

        Query categoryQuery = new CategoryQuery("cuisine_type");
        QueryResults queryResults = categoryQuery.executeQuery();
        this.cuisineOptions = queryResults.getCategoryResults();

     /*   Syntax categorySyntax = new CategoryQuerySyntax();
        categorySyntax.setCategory("cuisine_type");
        Query categoryQuery = new CategoryQuery(categorySyntax);
        categoryQuery.executeSQL();
        this.cuisineOptions = categoryQuery.getCategoryResults();*/




    }

    public SearchBuilder execute(){

        System.out.println("Would you like to add a cuisine type to your search?"+
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
        System.out.println("Please enter a number for your requested Cuisine type:");

        int orderNum = 1;

        for(String cuisineOption: cuisineOptions){
            System.out.println(orderNum + " - "+cuisineOption);
            orderNum++;
        }

        Scanner scanner2 = new Scanner(System.in);  // Create a Scanner object
        int userInput2 = scanner2.nextInt();  // Read user input
        FoodSearch foodSearch = this.searchBuilder.setCuisineType(cuisineOptions.get(userInput2-1));

    }

}
