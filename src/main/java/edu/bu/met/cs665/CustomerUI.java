package edu.bu.met.cs665;

import edu.bu.met.cs665.customerQuestions.AskCuisineType;
import edu.bu.met.cs665.customerQuestions.AskLocation;
import edu.bu.met.cs665.customerQuestions.AskPriceRange;
import edu.bu.met.cs665.customerQuestions.QuestionCommand;
import edu.bu.met.cs665.database.Query;
import edu.bu.met.cs665.database.Restaurant;
import edu.bu.met.cs665.database.SQLFilter;

import java.util.ArrayList;

public class CustomerUI {

    SearchBuilder searchBuilder;
    ArrayList<QuestionCommand> customerQuestions;
    FoodSearch foodSearch;
    ArrayList<Restaurant> restaurantResults;

    public CustomerUI(){
        SearchBuilder newSearch = new SearchBuilder();
        this.searchBuilder = newSearch;

        AskLocation askLocation = new AskLocation(searchBuilder);
        AskCuisineType askCuisineType = new AskCuisineType(searchBuilder);
        AskPriceRange askPriceRange = new AskPriceRange(searchBuilder);
        customerQuestions = new ArrayList<QuestionCommand>();
        customerQuestions.add(askLocation);
        customerQuestions.add(askCuisineType);
        customerQuestions.add(askPriceRange);
    }

    public void takeCustomerOrder() throws Exception {

        for(QuestionCommand questionCommand: customerQuestions){
           this.searchBuilder = questionCommand.execute();
        }
        printSummary();

        SQLFilter sqlFilter = new SQLFilter(foodSearch);
        Query query = new Query(sqlFilter);
        restaurantResults = query.get();
        System.out.println(restaurantResults.get(0).getName());
    }

    public void printSummary(){
        foodSearch = searchBuilder.build();
        System.out.println("Your order is: "+
                foodSearch.getCuisineType() + " and your price range is "+foodSearch.getPriceRange());
    }

}
