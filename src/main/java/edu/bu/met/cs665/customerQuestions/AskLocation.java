package edu.bu.met.cs665.customerQuestions;

import edu.bu.met.cs665.database.CategoryQuery;
import edu.bu.met.cs665.database.Query;
import edu.bu.met.cs665.database.QueryResults;
import edu.bu.met.cs665.searchBuilder.FoodSearch;
import edu.bu.met.cs665.searchBuilder.SearchBuilder;

import java.util.ArrayList;
import java.util.Scanner;

public class AskLocation extends QuestionCommand {

    private SearchBuilder searchBuilder;
    private ArrayList<String> locationOptions;

    public AskLocation(SearchBuilder searchBuilder){
        this.searchBuilder = searchBuilder;
        Query categoryQuery = new CategoryQuery("location");
        QueryResults queryResults = categoryQuery.executeQuery();
        this.locationOptions = queryResults.getCategoryResults();



        //this.locationOptions = new ArrayList<String>();
     /*   Syntax categorySyntax = new CategoryQuerySyntax();
        categorySyntax.setCategory("location");
        Query categoryQuery = new CategoryQuery(categorySyntax);
        categoryQuery.executeSQL();
        this.locationOptions = categoryQuery.getCategoryResults();
        //System.out.println(locationOptions.get(0));*/
    }

    public SearchBuilder execute(){
        questionScript();
        Scanner scanner2 = new Scanner(System.in);  // Create a Scanner object
        int userInput2 = scanner2.nextInt();  // Read user input
        FoodSearch foodSearch = this.searchBuilder.setLocation(locationOptions.get(userInput2-1));
        return searchBuilder;
    }

    public void questionScript(){
        System.out.println("To find local restaurants near you, please enter a location below:");
        int orderNum = 1;

        for(String locationOption: locationOptions){
            System.out.println(orderNum + " - "+ locationOption);
            orderNum++;
        }
    }

}
