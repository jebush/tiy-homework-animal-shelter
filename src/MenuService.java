/**
 * Created by rush on 8/16/16.
 */
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.exit;

public class MenuService {

    //These are the indicators for the main menu
    public static final int LIST_Animal = 1;
    public static final int CREATE_Animal = 2;
    public static final int VIEW_Animal = 3;
    public static final int EDIT_Animal = 4;
    public static final int DELETE_Animal = 5;
    public static final int QUIT = 6;


    //Probally need to take out
    AnimalsService animalService = new AnimalsService();

    //This is my scanner
    Scanner scanner = new Scanner(System.in);


    public int promptForMainMenuSelection() {
        System.out.println("\n-- Main Menu --\n" +
                "\n" +
                "1) List animals\n" +
                "2) Create an animal\n" +
                "3) View animal details\n" +
                "4) Edit an animal\n" +
                "5) Delete an animal\n" +
                "6) Quit\n");

        return waitForInt("Please choose an option:");
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
                System.out.println((x) + ")" + ani.getName() + "        " + ani.getSpecies() + " \n");
            }
        }

    }

    public Animal createAnimal() {
        System.out.println("\n-- Create a Animal -- \n");


        String name = waitForString(("Animal Name: "), true);


        String species = waitForString(("Species: "), true);



        String breed = waitForString(("Breed (optional): "), false);



        String description = waitForString(("Description: "), true);

        return new Animal(name, species, breed, description);
    }

    public void displayAnimal(Animal myAnimal) {

        //This displays the Animal data
        System.out.println("Name: " + myAnimal.getName());
        System.out.println("Species: " + myAnimal.getSpecies());
        System.out.println("Breed: " + myAnimal.getBreed());
        System.out.println("Description: " + myAnimal.getDescription());

    }

    public void displayNoAnimal(){
        System.out.println("Sorry, that animal does not exist");
    }

    public Animal editAnimal(Animal animal) {
        System.out.println("\n-- Edit a Animal -- \n");


        String name = waitForString(
                String.format("Animal Name [%s]: ", animal.getName()),
                animal.getName());


        String species = waitForString(
                String.format("Species [%s]: ", animal.getSpecies()),
                animal.getSpecies());



        String breed = waitForString(
                String.format("Breed [%s]: ", animal.getBreed()),
                animal.getBreed());



        String description = waitForString(
                String.format("Description [%s]: ", animal.getDescription()),
                animal.getDescription());

        System.out.println("Success: The animal has been updated");

        return new Animal(name, species, breed, description);

    }

    private String deleteAnimalString(String message, boolean needIt) {
        System.out.println(message);

        String value =  scanner.nextLine();

        if(needIt && value.trim().length() == 0){
            System.out.println("\nPlease provide a yes/no.\n");

            value = waitForString(message, needIt);
        }

        return value.trim();
    }

    public void delAnimal(ArrayList<Animal> animal) {

        System.out.println("----- Delete Animal -----");
        int index = promptForAnimalIndex("What is the animal you want to Delete?");

        int arraySize = animal.size();

        Animal myAnimal = animalService.getAnimal(index);

        System.out.println(myAnimal);

        if (index < arraySize) {

            String deleteIT = scanner.nextLine();

            switch (deleteIT) {
                case "yes":
                    animalService.removeAnimal(index);
                    System.out.println("Goodbye Deletion is successful!");

                    break;
                case "no":
                    System.out.println("You canceled the deletion.");
                    delAnimal(animal);

                    break;

                default:
                    System.out.println("Try Again!");
            }
        } else {
            delAnimal(animal);
        }
    //   if (deleteIT.equals("yes")){
    //       System.out.println("Goodbye!");
    //       deleteAni = true;
    //       return deleteAni;
    //   }else if (deleteIT.equals("no")){
    //       deleteAni = false;
    //       return deleteAni;
    //   }else {
    //       System.out.println("Try again yes or no!");
    //       delAnimal();
    //       return deleteAni;
    //   }

    }

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
    private int waitForIntDelete(String message) {


        //verify animal records exist first
        ArrayList<Animal> animal = animalService.getListAnimals();
        int arraySize = animal.size();
        if (arraySize > 2) {
            System.out.printf("[0] total animal(s) are on record.\n");
            return -1;
        }


        //interface with user
        System.out.println(message);
        String input = scanner.nextLine();

        //process input
        int value;
        try {
            value = Integer.parseInt(input);
        } catch (Exception e) {
            System.out.printf("Please try again, \"%s\" is not a valid number!\n", input);
            value = waitForInt(message);
        }
        if ((value < 0) ||
                ((value > animalService.getListAnimals().size()))) {
            System.out.printf("Please try again. \"%s\" is not a valid number!\n", input);
            value = waitForInt(message);
        }
        return value;
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

