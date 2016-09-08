
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.exit;

public class MenuService {

    //These are the indicators for the main menu
    public static final int Add_Animal = 1;
    public static final int Manage_Animal = 2;
    public static final int Manage_AnimalTypes = 3;
    public static final int QUIT = 4;

    //This is the menu callers for Animal Search
    public static final int TYPE = 1;
    public static final int NAME = 2;
    public static final int ID = 3;
    public static final int ALL_Animals = 4;
    public static final int RETURN_Main_Menu = 5;


    //This is the menu callers for Animal Manage
    public static final int EDIT_Animal = 1;
    public static final int DELETE_Animal = 2;
    public static final int ADD_Note = 3;
    public static final int RETURN_Menu = 4;

    //This is the menu callers for Animal Type Manage
    public static final int View_Animal_Type = 1;
    public static final int Add_Animal_Type = 2;
    public static final int RETURN_To_Menu = 3;

    //This is my scanner
    Scanner scanner = new Scanner(System.in);


    private AnimalRepository animalRepository;

    private AnimalTypeRepository animalTypeRepository;

    private NoteRepository noteRepository;

    private AnimalsService animalsService;

    public MenuService() throws SQLException {
    }

    public MenuService(AnimalRepository animalRepository, AnimalTypeRepository animalTypeRepository, NoteRepository noteRepository, AnimalsService animalsService) throws SQLException {
        this.animalRepository = animalRepository;
        this.animalTypeRepository = animalTypeRepository;
        this.noteRepository = noteRepository;
        this.animalsService = animalsService;
    }


    public int promptForMainMenuSelection() {
        System.out.println("\n-- Main Menu --\n" +
                "\n" +
                "1) Add animal\n" +
                "2) Manage an animal\n" +
                "3) Manage animal Types\n" +
                "4) Quit\n");

        return waitForInt("Please choose an option:");
    }

    public int promptForAnimalSearch() {
        System.out.println("\n-- Search for animals --\n" +
                "\n" +
                "1) Type\n" +
                "2) Name\n" +
                "3) ID\n" +
                "4) All animals\n" +
                "5) Return to Main Menu\n");

        return waitForInt("How do you wish to search? ");
    }

    public int promptForAnimalManage() {
        System.out.println("\n-- Please Select an Option --\n" +
                "\n" +
                "1) Edit Animal\n" +
                "2) Delete animal\n" +
                "3) Add note\n" +
                "4) Return to Previous Menu\n");

        return waitForInt("What do you want to do? ");
    }

    public int promptForAnimalTypeManage() {
        System.out.println("\n-- Please Select an Option --\n" +
                "\n" +
                "1) View Animal Types\n" +
                "2) Add Animal Type\n" +
                "3) Return to Main Menu\n");

        return waitForInt("What do you want to do? ");
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

    public void listAnimalType(ArrayList<Animal> littleAnimals) {
        System.out.println("\n-- List of animals --\n");

        if (littleAnimals.size() == 0){
            System.out.println("There are no animals. Please create one.");
        } else {
            for (int x = 0; x < littleAnimals.size(); x++) {
                Animal ani = littleAnimals.get(x);
                System.out.println(ani.getAnimalTypeId() + ")" + ani.getAnimalType() + " \n");
            }
        }
    }

    public String listAnimalTypeAsString(ArrayList<Animal> littleAnimals) {
        String result = "";

        if (littleAnimals.size() == 0){
            System.out.println("There are no animals. Please create one.");
        } else {
            for (int i = 0; i < littleAnimals.size(); i++) {
                Animal ani = littleAnimals.get(i);
                if ((i + 1) != littleAnimals.size()){
                    result = result + ani.getAnimalType() + ", ";
                } else {
                    result = result + " " + ani.getAnimalType();
                }
            }
        }
        return "(" + result.trim() + ")";
    }

  public Animal createAnimal(ArrayList<Animal> animalType) {

      System.out.println("\n-- Create a Animal -- \n");


      String name = waitForString(("Animal Name: "), true);


      System.out.print(listAnimalTypeAsString(animalType));
      String species = waitForString(("Species: "), true);


      String breed = waitForString(("Breed (optional): "), false);



      String description = waitForString(("Description: "), true);

      return new Animal(name, species, breed, description);
  }

    public void displayAnimal(ArrayList<Animal> littleAnimals) throws SQLException {
        System.out.println("--- Animal Details ---");

        if (littleAnimals.size() == 0){
            System.out.println("There are no animals. Please create one.");
        } else {
            for (int x = 0; x < littleAnimals.size(); x++) {
                Animal myAnimal = littleAnimals.get(x);

                //This displays the Animal data
                System.out.println("ID: " + myAnimal.getAnimalID());
                System.out.println("Name: " + myAnimal.getName());
                System.out.println("Species: " + animalsService.getSpecificAnimalType(myAnimal.getSpecie()));
                System.out.println("Breed: " + myAnimal.getBreed());
                System.out.println("Description: " + myAnimal.getDescription());
                }
        }
    }


    public void displayNoAnimal(){
        System.out.println("Sorry, that animal does not exist");
    }

    public Animal updateAnimal(Animal animal) throws SQLException {
        System.out.println("\n-- Edit a Animal -- \n");

        String name = waitForString(String.format("Animal Name [%s]: ", animal.getName()), animal.getName());

        int species = waitForInt(String.format("Species [%s]: ", animalsService.getSpecificAnimalType(animal.getSpecie())));


        String breed = waitForString(String.format("Breed [%s]: ", animal.getBreed()), animal.getBreed());


        String description = waitForString(String.format("Description [%s]: ", animal.getDescription()), animal.getDescription());
        System.out.println("Success: The animal has been updated");
        return new Animal(animal.getAnimalID(), name, species, breed, description);
    }

    public Animal addAnimalType(){
        String type = waitForString("Add new animal type: ", true);

        return new Animal(type);
    }


    //This is a prompt to ask if you want to delete the animal
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


    public void quit() {
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

    public Note addNote(){
        //interface with user
        System.out.printf("\n--- Add note ---\n");

        String noteText = waitForString("Please enter text for note: ", true);

        return new Note(noteText);

    }

    public void displayAnimalNotes(ArrayList<Note> animalNotes) {
        System.out.println("--- Animal Notes ---");

        if (animalNotes.size() == 0){
            System.out.println("There are no notes on this animal. Please create one if desired.");
        } else {
            for (int x = 0; x < animalNotes.size(); x++) {
                Note myAnimalNotes = animalNotes.get(x);

                //This displays the Animal data
                System.out.println("ID: " + myAnimalNotes.getId());
                System.out.println("Note: " + myAnimalNotes.gettext());
                System.out.println("Date: " + myAnimalNotes.getDate());
            }
        }
    }

}

