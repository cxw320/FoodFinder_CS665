package edu.bu.met.cs665.customerQuestions;

import edu.bu.met.cs665.FoodSearch;
import edu.bu.met.cs665.SearchBuilder;

import java.util.Scanner;

public class AskLocation extends QuestionCommand {

    SearchBuilder searchBuilder;

    public AskLocation(SearchBuilder searchBuilder){
        this.searchBuilder = searchBuilder;
    }

    public SearchBuilder execute(){
        questionScript();
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        String userInput = scanner.nextLine();  // Read user input
        FoodSearch foodSearch = this.searchBuilder.setLocation(userInput);
        return searchBuilder;
    }

    public void questionScript(){
        System.out.println("To find local restaurants near you, please enter a location below:");
    }

}
