package edu.bu.met.cs665.customerQuestions;

import edu.bu.met.cs665.searchBuilder.SearchBuilder;

public abstract class QuestionCommand {

    //SearchBuilder searchBuilder;

    public QuestionCommand(){
    }

    public abstract SearchBuilder execute();

    public abstract void questionScript();

}
