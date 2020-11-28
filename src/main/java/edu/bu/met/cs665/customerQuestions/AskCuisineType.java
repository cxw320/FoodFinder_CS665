package edu.bu.met.cs665.customerQuestions;

import edu.bu.met.cs665.FoodSearch;
import edu.bu.met.cs665.SearchBuilder;

import java.util.ArrayList;
import java.util.Scanner;

public class AskCuisineType extends QuestionCommand{

    SearchBuilder searchBuilder;
    //HASHMAP OF CUISINETYPES / MAYBE THIS IS A NEW CLASS
    ArrayList<String> cuisineOptions = new ArrayList<String>();


    public AskCuisineType(SearchBuilder searchBuilder){
        this.searchBuilder = searchBuilder;
        cuisineOptions.add("American");
        cuisineOptions.add("Italian");
        cuisineOptions.add("Mexican");
        cuisineOptions.add("Chinese");
    }

    public SearchBuilder execute(){

        System.out.println("Would you like to add a cuisine type to your search?"+
                "\nType 1 for Yes"+
                "\nType 2 for No");

        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        int userInput = scanner.nextInt();  // Read user input

        if(userInput==1){
            questionScript();
        }else if(userInput==2){
        }else{
            System.out.println("Invalid input. Please try again:");
            execute();
        }
        return searchBuilder;
    }


    public void questionScript(){
        System.out.println("Please enter a number for your requested Cuisine type:"+
                "\n 1 - American Fast Food (Burgers, Sandwiches, etc.)"+
                "\n 2 - Italian & Pizza"+
                "\n 3 - Mexican"+
                "\n 4 - Chinese");
        Scanner scanner2 = new Scanner(System.in);  // Create a Scanner object
        int userInput2 = scanner2.nextInt();  // Read user input
        FoodSearch foodSearch = this.searchBuilder.setCuisineType(cuisineOptions.get(userInput2-1));

    }

}
