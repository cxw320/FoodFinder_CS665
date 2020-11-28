package edu.bu.met.cs665.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Query {

    ArrayList<Restaurant> restaurantList;
    String sqlFilterStatement;


    public Query(SQLFilter sqlfilter){
        ArrayList<Restaurant> restaurantList = new ArrayList<Restaurant>();
        this.restaurantList = restaurantList;
        this.sqlFilterStatement = sqlfilter.createSQLFilterStatement();
    }

    public ArrayList<Restaurant> get() throws Exception{

        SQLConnection sqlConn = new SQLConnection();
        try{
            Connection conn = sqlConn.getConnection();

            PreparedStatement statement = conn.prepareStatement(
                    "SELECT * from restaurants WHERE " + sqlFilterStatement + ";"
            );

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

                restaurantList.add(restaurant);
            }


        }catch(Exception e){
            System.out.println(e);
        }

        return restaurantList;

    }

}
