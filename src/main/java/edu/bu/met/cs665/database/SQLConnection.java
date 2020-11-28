package edu.bu.met.cs665.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLConnection {

    public static Connection getConnection() throws Exception{
        try{
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/restaurants";
            String username = "db_user";
            String password = "db_user";
            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url,username,password);
            System.out.println("Connection successful");
            return conn;

        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
}
