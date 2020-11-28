package edu.bu.met.cs665.database;

import edu.bu.met.cs665.FoodSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.stream.Collectors;

public class SQLFilter {

    HashMap<String, String> searchCriteria;


    public SQLFilter(FoodSearch search){
        this.searchCriteria = search.getSearchCriteria();
    }


    public String createSQLFilterStatement() {


       ArrayList<String> statements = new ArrayList<String>();

      /*  searchCriteria.forEach((k, v) -> statements.add(String.format("%s = %s",k,v)));*/


       String sqlStatement = searchCriteria.entrySet().stream().map(e -> e.getKey() + " = '" + e.getValue()+"' ")
                .collect(Collectors.joining("AND "));

        System.out.println(sqlStatement);

    /*    StringBuilder sb = new StringBuilder();
        for (String s : statements)
        {
            sb.append(s);
        }*/

      /*  String sqlStatement = sb.toString();*/

     //   String sqlStatement = "WHERE price_range = 'Less than $20' AND cuisine_type ='italian' ";


        return sqlStatement;

    }

}
