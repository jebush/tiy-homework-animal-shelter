/**
 * Created by rush on 8/16/16.
 */
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.exit;

public class MenuService {

    //These are the indicators for the main menu
    public static final int Add_Animal = 1;
    public static final int Manage_Animal = 2;
    public static final int Manage_AnimalTypes = 3;
    public static final int QUIT = 4;


    //This is my scanner
    Scanner scanner = new Scanner(System.in);


    public int promptForMainMenuSelection() {
        System.out.println("\n-- Main Menu --\n" +
                "\n" +
                "1) Add animal\n" +
                "2) Manage an animal\n" +
                "3) Manage animal Types\n" +
                "4) Quit\n");

        return waitForInt("Please choose an option:");
    }

    public int promptFoAnimalSearch() {
        System.out.println("\n-- Search for animals --\n" +
                "\n" +
                "1) Type\n" +
                "2) Name\n" +
                "3) ID\n" +
                "4) All animals\n" +
                "5) Return to Menu\n");

        return waitForInt("How do you wish to search? ");
    }

    private int waitForInt(String message) {


        System.out.println(message);

        String input = scanner.nextLine();

        int value;
        try {
            value = Integer.parseInt(input);

        } catch (Exception e) {
            System.out.println("\nPlease provide a number.\n");

            value = waitForInt(message);
        }

        return value;
    }

    private String waitForString(String message, boolean needIt) {
        System.out.println(message);

        String value =  scanner.nextLine();

        if(needIt && value.trim().length() == 0){
            System.out.println("\nPlease provide a value.\n");

            value = waitForString(message, needIt);
        }

        return value.trim();
    }

    public String waitForString2(String message, boolean needIt) {
        System.out.println(message);

        String value =  scanner.nextLine();

        if(needIt && value.trim().length() == 0){
            System.out.println("\nPlease provide a value.\n");

            value = waitForString(message, needIt);
        }

        return value.trim();
    }

    private String waitForString(String message, String defaultValue){
        String value = waitForString(message, false);

        if(value.isEmpty()){
            return defaultValue;
        } else {
            return value;
        }
    }

    public int promptForAnimalIndex() {
        return waitForInt("What is the numeric ID of the animal you want to view?: ");
    }

    public int promptForAnimalIndex(String message) {
        return waitForInt(message);
    }


    //
    public void listAnimals(ArrayList<Animal> littleAnimals) {
        System.out.println("\n-- List of animals --\n");

        if (littleAnimals.size() == 0){
            System.out.println("There are no animals. Please create one.");
        } else {
            for (int x = 0; x < littleAnimals.size(); x++) {
                Animal ani = littleAnimals.get(x);
                System.out.println(ani.getAnimalID() + ")" + ani.getName() + "        " + ani.getSpecies() + " \n");
            }
        }

    }

    public void listAnimalType(ArrayList<AnimalType> littleAnimals) {
        System.out.println("\n-- List of animals --\n");

        if (littleAnimals.size() == 0){
            System.out.println("There are no animals. Please create one.");
        } else {
            for (int x = 0; x < littleAnimals.size(); x++) {
                AnimalType ani = littleAnimals.get(x);
                System.out.println(ani.getAnimalTypeId() + ")" + ani.getAnimalType() + " \n");
            }
        }

    }

  public Animal createAnimal() {
      System.out.println("\n-- Create a Animal -- \n");


      String name = waitForString(("Animal Name: "), true);


      int species = waitForInt(("Species: "));



      String breed = waitForString(("Breed (optional): "), false);



      String description = waitForString(("Description: "), true);

      return new Animal(name, species, breed, description);
  }

    public void displayAnimal(ArrayList<Animal> littleAnimals) {
        System.out.println("--- Animal Details ---");

        if (littleAnimals.size() == 0){
            System.out.println("There are no animals. Please create one.");
        } else {
            for (int x = 0; x < littleAnimals.size(); x++) {
                Animal myAnimal = littleAnimals.get(x);

                //This displays the Animal data
                System.out.println("ID: " + myAnimal.getAnimalID());
                System.out.println("Name: " + myAnimal.getName());
                System.out.println("Species: " + myAnimal.getSpecies());
                System.out.println("Breed: " + myAnimal.getBreed());
                System.out.println("Description: " + myAnimal.getDescription());
                }
        }



    }

    public void displayNoAnimal(){
        System.out.println("Sorry, that animal does not exist");
    }

  //  public Animal editAnimal(Animal animal) {
  //      System.out.println("\n-- Edit a Animal -- \n");
//
//
  //      String name = waitForString(
  //              String.format("Animal Name [%s]: ", animal.getName()),
  //              animal.getName());
//
//
  //      String species = waitForString(
  //              String.format("Species [%s]: ", animal.getSpecies()),
  //              animal.getSpecies());
//
//
//
  //      String breed = waitForString(
  //              String.format("Breed [%s]: ", animal.getBreed()),
  //              animal.getBreed());
//
//
//
  //      String description = waitForString(
  //              String.format("Description [%s]: ", animal.getDescription()),
  //              animal.getDescription());
//
  //      System.out.println("Success: The animal has been updated");
//
  //      return new Animal(name, species, breed, description);
//
  //  }


    public boolean deleteAnimal(){
        String deleteIT = waitForString("Do you want to delete this animal?(yes/no)", true);
        boolean deleteAni = false;
        if (deleteIT.equals("yes")){
                 System.out.println("Success you deleted the animal!");
                 deleteAni = true;
                 return deleteAni;
             }else if (deleteIT.equals("no")){
                 deleteAni = false;
                 return deleteAni;
             }else {
                 System.out.println("Try again yes or no!");
                 deleteAnimal();
                return deleteAni;
             }
    }


    public void quit(){
        System.out.println("--- Quit ---");

        String quitIt = waitForString("Are you sure you want to quit?(yes/no): ", true);

        switch (quitIt) {
            case "yes":
                System.out.println("Goodbye!");
                exit(0);
                break;
            case "no":
                break;
            default:
                System.out.println("You need to try harder than that! Try Again!");
                quit();
        }
    }
}

