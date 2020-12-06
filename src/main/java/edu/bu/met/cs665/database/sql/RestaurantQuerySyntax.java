package edu.bu.met.cs665.database.sql;

import edu.bu.met.cs665.database.QueryResults;
import edu.bu.met.cs665.database.Restaurant;
import edu.bu.met.cs665.searchBuilder.FoodSearch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class RestaurantQuerySyntax extends Syntax {

    private HashMap<String, String> searchCriteria;
    private FoodSearch foodSearch;
    private String sqlStatement;
    private ArrayList<Restaurant> restaurantResults;
    private QueryResults queryResults;

    public RestaurantQuerySyntax(FoodSearch foodSearch){
        this.foodSearch= foodSearch;
        this.restaurantResults = new ArrayList<Restaurant>();
        this.searchCriteria = foodSearch.getSearchCriteria();
        this.queryResults = new QueryResults();

    }

    public void createSQLStatement(){

        String filter = searchCriteria.entrySet().stream().map(e -> e.getKey() + " = '" + e.getValue()+"' ")
                .collect(Collectors.joining("AND "));

        this.sqlStatement = ("SELECT * from restaurants WHERE "
                + filter + ";");
    }

    public QueryResults executeSQL(){

        createSQLStatement();

        SQLConnection sqlConn = new SQLConnection();

        try{
            Connection conn = sqlConn.getConnection();

            PreparedStatement statement = conn.prepareStatement(sqlStatement);

            ResultSet result = statement.executeQuery();


            while(result.next()){
                int id = result.getInt("id");
                String name = result.getString("name");
                String location = result.getString("location");
                String cuisine_type = result.getString("cuisine_type");
                String price_range = result.getString("price_range");

                Restaurant restaurant = new Restaurant();
                restaurant.setId(id);
                restaurant.setName(name);
                restaurant.setLocation(location);
                restaurant.setCuisine_type(cuisine_type);
                restaurant.setPrice_range(price_range);

                restaurantResults.add(restaurant);
            }


        }catch(Exception e){
            System.out.println(e);
        }

        QueryResults queryResults = new QueryResults();
        queryResults.setRestaurantResults(restaurantResults);
        return queryResults;

    }

}
