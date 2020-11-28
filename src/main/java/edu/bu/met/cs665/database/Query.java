package edu.bu.met.cs665.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Query {

    public static void get() throws Exception{

        SQLConnection sqlConn = new SQLConnection();
        try{
            Connection conn = sqlConn.getConnection();
            PreparedStatement statement = conn.prepareStatement(
                    "SELECT * from restaurants"
            );

            ResultSet result = statement.executeQuery();

            ArrayList<String> restaurants = new ArrayList<String>();
            while(result.next()){
                int


            }


        }catch(Exception e){
            System.out.println(e);
        }

    }

}
