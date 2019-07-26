package com.company;

import java.util.Scanner; //Will use to take user input

//All foods must have a showCalorie for debugging purposes.
interface food {
   void showCalorie();
}

//Properties of ingredients such as weight and calorie count, also the type of food.
//This can be vegetable or fruit in this version of the software
class ingredientProperties implements food{
    static double calorieCount;
    static int gramWeight;
    static String foodType;


    //Getters and setters so classes outside can access such information
    double getCalorieCount() { return calorieCount;}
    int getGramWeight() { return gramWeight;}
    String getFoodType() {return  foodType;}
    static void setCalorieCount(double calorie) { calorieCount = calorie;}
    static void setGramWeight(int gram) { gramWeight = gram;}
    static void setFoodType(String type) { foodType = type;}

    //This will show the total calorie of an ingrdient dependant on the default input.
    //This does not calculate from a certain weight
    public void showCalorie() {
        System.out.println("Total calorie of your ingredient is " + calorieCount + " calories.");
    }
}

//Object ingredient
//Contains the declaration and composition of what is an ingredient
//This is the calorie, gram and type
class ingredient extends ingredientProperties {
    ingredient(String type, double calorie, int gram) {
        ingredient.setCalorieCount(calorie);
        ingredient.setGramWeight(gram);
        ingredient.setFoodType(type);
    }

    //getter for calorie, weight and type
    double whatIsCalorie() {return getCalorieCount();}
    int whatIsWeight() {return getGramWeight();}
    String whatIsType() {return getFoodType();}

    //calculates total calorie of an ingredient with calculation depeandant off the user
    //inputted weight. This allows for custom inputs and outputs.
    double totalCalorie(int userGram) {
        //This is a proportion calculation. It is very simple.
        System.out.println("That is " + ((userGram * getCalorieCount()) / getGramWeight()) + " grams.");
        return 1;
    }

}

//This class will be composed of declaring ingredients
//There are two, vegetable and fruit.
class ingredientOptions extends ingredientProperties{
    //Declared vegetables objects
    static class vegetable {
        static ingredient carrot = new ingredient("vegetable", 41.35, 100);
        static ingredient eggplant = new ingredient("vegetable", 20, 82);
        static ingredient onion = new ingredient("vegetable", 44, 110);

    }

    //Declared fruit objects
    static class fruit {
        static ingredient apple = new ingredient("fruit", 95, 182);
        static ingredient banana = new ingredient("fruit", 105, 118);
        static ingredient grape = new ingredient("fruit", 62, 92);
    }

    //Array of the fruits plus a system log print for the user
    static void fruitList() {
        String[] fruitList = new String[3];
        fruitList[0] = "apple";
        fruitList[1] = "banana";
        fruitList[2] = "grape";
        for(int i = 0; i < fruitList.length; i++){
            System.out.println(fruitList[i]);
        }
    }

    //Array of the vegetables plus a ssytem log print for the user
    static void vegetableList(){
        String[] vegetableList = new String[3];
        vegetableList[0] = "carrot";
        vegetableList[1] = "eggplant";
        vegetableList[2] = "onion";
        for(int i = 0; i < vegetableList.length; i++){
            System.out.println(vegetableList[i]);
        }

    }
}

class createMeal extends ingredientOptions{
    //Initiate the keyboard scanner
    static Scanner keyboard = new Scanner(System.in);

    //booleans for keeping a temp state to pass certain gates
    static boolean typeChoiceCheck = false;
    static boolean ingredientChoiceCheck = false;

    //These are the variables that keep the user's responses
    //Used for gates and checks for while and do loops
    private static String userTypeChoice;
    private static String userIngredientChoice;
    private static String userFruitChoice;
    private static String userVegetableChoice;
    private static int caseNum = 0;

    public String getUserTypeChoice(){ return userTypeChoice;}


    public static void main(String args[]) {
        //This is the start of the program
        //Will go over what it does
        //It is to make the input for the user simple
        System.out.println("Hello, this program is a demo that will assist you in calculating\n" +
                " how many calories your meal will use. At the moment it will ask you to input\n" +
                " the amount of grams of an ingredient to determine the amount of calories.\n");

        while(!typeChoiceCheck) {
            System.out.println("What ingredient type would you like to determine the calories of?\n");
            System.out.println("FRUIT\tOR\tVEGETABLE\n");
            System.out.println("Type your choice and then press enter.");
            System.out.println("Your Choice: ");

            String userTypeInput = keyboard.next();

            if(userTypeInput.equalsIgnoreCase("Fruit")) {
                typeChoiceCheck = true;
                caseNum = 1;
                userTypeChoice = userTypeInput;
            }
            else if(userTypeInput.equalsIgnoreCase("Vegetable")) {
                typeChoiceCheck = true;
                caseNum = 2;
                userTypeChoice = userTypeInput;
            }
            else {
                System.out.println("Sorry wrong input. Please try again!\n\n\n\n\n");
                //repeat
                //nothing
            }

        }

        //Switch case based on what the user has answered previously
        //Dependant on if they chose fruit or vegetable
        //Branches to 3 fruits or 3 vegetables
        switch (caseNum) {
            case 1:
                do {
                    System.out.println("Which fruit ingredient will you calculate?");
                    ingredientOptions.fruitList();
                    System.out.println("\nYour Choice: ");
                    String userFruitInput = keyboard.next();
                    if(userFruitInput.equalsIgnoreCase("banana")) {
                        ingredientChoiceCheck = true;
                        userIngredientChoice = userFruitInput;
                    }
                    else if(userFruitInput.equalsIgnoreCase("apple")) {
                        ingredientChoiceCheck = true;
                        userIngredientChoice = userFruitInput;
                    }
                    else if(userFruitInput.equalsIgnoreCase("grape")){
                        ingredientChoiceCheck = true;
                        userIngredientChoice = userFruitInput;
                    }
                    else {
                        System.out.println("Sorry wrong input. Please try again!\n\n\n\n\n");
                        //repeat
                        //nothing
                    }
                } while(!ingredientChoiceCheck);
                break;


            case 2:
                do {
                    System.out.println("Which vegetable ingredient will you calculate?");
                    ingredientOptions.vegetableList();
                    System.out.println("\nYour Choice: ");
                    String userVegetableInput = keyboard.next();
                    if(userVegetableInput.equalsIgnoreCase("banana")) {
                        ingredientChoiceCheck = true;
                        userIngredientChoice = userVegetableInput;
                    }
                    else if(userVegetableInput.equalsIgnoreCase("carrot")) {
                        ingredientChoiceCheck = true;
                        userIngredientChoice = userVegetableInput;
                    }
                    else if(userVegetableInput.equalsIgnoreCase("onion")){
                        ingredientChoiceCheck = true;
                        userIngredientChoice = userVegetableInput;
                    }
                    else {
                        System.out.println("Sorry wrong input. Please try again!\n\n\n\n\n");
                        //repeat
                        //nothing
                    }
                } while(!ingredientChoiceCheck);
                break;

            default:
                System.out.println("Invalid. Restart program.");
        }


        //All if statements below wil check what you chose : type than ingredient
        //From there it will calculate your total calorie with the weight you input in grams
        //Your output would be the total calorie count
        if(userIngredientChoice.equalsIgnoreCase("apple")){
            System.out.println("How many grams are there of the " + userIngredientChoice + "?");
            System.out.println("\nUser Choice: ");
            int gram = keyboard.nextInt();
            fruit.apple.totalCalorie(gram);
        }
        if(userIngredientChoice.equalsIgnoreCase("banana")){
            System.out.println("How many grams are there of the " + userIngredientChoice + "?");
            System.out.println("\nUser Choice: ");
            int gram = keyboard.nextInt();
            fruit.banana.totalCalorie(gram);
        }
        if(userIngredientChoice.equalsIgnoreCase("grape")){
            System.out.println("How many grams are there of the " + userIngredientChoice + "?");
            System.out.println("\nUser Choice: ");
            int gram = keyboard.nextInt();
            fruit.grape.totalCalorie(gram);
        }
        if(userIngredientChoice.equalsIgnoreCase("carrot")){
            System.out.println("How many grams are there of the " + userIngredientChoice + "?");
            System.out.println("\nUser Choice: ");
            int gram = keyboard.nextInt();
            vegetable.carrot.totalCalorie(gram);
        }
        if(userIngredientChoice.equalsIgnoreCase("onion")){
            System.out.println("How many grams are there of the " + userIngredientChoice + "?");
            System.out.println("\nUser Choice: ");
            int gram = keyboard.nextInt();
            vegetable.onion.totalCalorie(gram);
        }
        if(userIngredientChoice.equalsIgnoreCase("eggplant")){
            System.out.println("How many grams are there of the " + userIngredientChoice + "?");
            System.out.println("\nUser Choice: ");
            int gram = keyboard.nextInt();
            vegetable.eggplant.totalCalorie(gram);
        }

    }
}

