package edu.bu.met.cs665.database;

import edu.bu.met.cs665.database.sql.RestaurantQuerySyntax;
import edu.bu.met.cs665.database.sql.SQLConnection;
import edu.bu.met.cs665.database.sql.Syntax;
import edu.bu.met.cs665.searchBuilder.FoodSearch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RestaurantQuery extends Query {

    private FoodSearch foodSearch;
    private Syntax restaurantQuerySyntax;

    public RestaurantQuery(FoodSearch foodSearch){
        this.foodSearch = foodSearch;
        this.restaurantQuerySyntax = new RestaurantQuerySyntax(foodSearch);
    }

    public QueryResults executeQuery(){
        return restaurantQuerySyntax.executeSQL();
    }

}
