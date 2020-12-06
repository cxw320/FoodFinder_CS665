package edu.bu.met.cs665.database.sql;

import edu.bu.met.cs665.database.QueryResults;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CategoryQuerySyntax extends Syntax {

    String columnName;
    String sqlStatement;
    ArrayList<String> categoryResults;
    QueryResults queryResults;

    public CategoryQuerySyntax(String columnName){
        this.columnName = columnName;
        this.categoryResults = new ArrayList<String>();
        this.queryResults = new QueryResults();

    }


    public void createSQLStatement(){
        this.sqlStatement = ("SELECT DISTINCT "
                + columnName  + " from restaurants;");
    }

    public QueryResults executeSQL(){

        createSQLStatement();

        SQLConnection sqlConn = new SQLConnection();

        try{
            Connection conn = sqlConn.getConnection();
            PreparedStatement statement = conn.prepareStatement(sqlStatement);
            ResultSet result = statement.executeQuery();

            while(result.next()){
                categoryResults.add(result.getString(columnName));
            }

        }catch(Exception e){
            System.out.println(e);
        }

        queryResults.setCategoryResults(categoryResults);
        return queryResults;

    }
}
