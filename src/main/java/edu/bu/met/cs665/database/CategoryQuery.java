package edu.bu.met.cs665.database;

import edu.bu.met.cs665.database.sql.CategoryQuerySyntax;
import edu.bu.met.cs665.database.sql.Syntax;

public class CategoryQuery extends Query{

    private String columnName;
    private Syntax categoryQuerySyntax;

    public CategoryQuery(String columnName){
        this.columnName = columnName;
        this.categoryQuerySyntax = new CategoryQuerySyntax(this.columnName);
    }

    public QueryResults executeQuery(){
        return categoryQuerySyntax.executeSQL();
    }

}
