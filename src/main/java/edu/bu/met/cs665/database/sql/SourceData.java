package edu.bu.met.cs665.database.sql;
import edu.bu.met.cs665.database.Restaurant;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class SourceData {

    public void clearData(){
        SQLConnection sqlConn = new SQLConnection();

        try{
            Connection conn = sqlConn.getConnection();

            PreparedStatement statement = conn.prepareStatement(
                    "DELETE from restaurants"
            );

            statement.executeUpdate();

        }catch(Exception e){
            System.out.println(e);
        }

    }

    public void readFile() throws FileNotFoundException{
        File file = new File("src/main/java/edu/bu/met/cs665/rawData");
        Scanner input = new Scanner(file);
        int key = 60;
        while(input.hasNextLine()){

            String line = input.nextLine();

            String[] record = line.split(",");
            String name = record[0];
            String location = record[1];
            String cuisine_type = record[2];
            String price_range = record[3];

            Restaurant restaurant = new Restaurant();
            restaurant.setId(key);
            restaurant.setName(name);
            restaurant.setLocation(location);
            restaurant.setCuisine_type(cuisine_type);
            restaurant.setPrice_range(price_range);

            saveData(restaurant);
            key++;
        }

    }

    public void saveData(Restaurant record){
        SQLConnection sqlConn = new SQLConnection();

        try{
            Connection conn = sqlConn.getConnection();

            PreparedStatement statement = conn.prepareStatement(
                    "INSERT INTO restaurants VALUES(?,?,?,?,?)"
            );

            statement.setInt(1,record.getId());
            statement.setString(2,record.getName());
            statement.setString(3,record.getLocation());
            statement.setString(4,record.getCuisine_type());
            statement.setString(5,record.getPrice_range());

            statement.executeUpdate();


        }catch(Exception e){
            System.out.println(e);
        }

    }


}
