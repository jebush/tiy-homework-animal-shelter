/**
 * Created by rush on 8/16/16.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class MenuService {
    AnimalsService service = new AnimalsService();
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

    //
    public void listAnimals() {
        System.out.println("\n-- List of animals --\n");

        //This creates an new instance of a array by getting the array from AnimalsService
        ArrayList<Animal> littleAnimals = service.getListAnimals();

        for (int x = 0; x < littleAnimals.size(); x++) {
            Animal ani = littleAnimals.get(x);
            System.out.println((x + 1) + ")" + ani.getName() + "        " + ani.getSpecies() + " \n");
        }


    }

    public void createAnimal() {

        Animal myAnimal = new Animal();

        //This creates an new instance of a array by getting the array from AnimalsService
        ArrayList<Animal> littleAnimals = service.getListAnimals();


        System.out.println("Animal Name: ");
        String name = scanner.nextLine();
        myAnimal.setName(name);

        System.out.println("Species: ");
        String species = scanner.nextLine();
        myAnimal.setSpecies(species);

        System.out.println("Breed (optional): ");
        String breed = scanner.nextLine();
        myAnimal.setBreed(breed);

        System.out.println("Description: ");
        String description = scanner.nextLine();
        myAnimal.setDescription(description);
        littleAnimals.add(myAnimal);
        service.setListAnimals(littleAnimals);
    }

    public void getAnimal() {
        System.out.println("What is the numeric ID of the animal you want to view?: ");

        //This scans in the number
        int numIndex = scanner.nextInt();

        Animal myAnimal = service.getAnimal(numIndex);


        System.out.println("Name: " + myAnimal.getName());
        System.out.println("Species: " + myAnimal.getSpecies());
        System.out.println("Breed: " + myAnimal.getBreed());
        System.out.println("Description: " + myAnimal.getDescription());

    }

    public void editAnimal() {
        System.out.println("What is the numeric ID of the animal you want to edit?: ");
        int numIndex = scanner.nextInt();

        Animal myAnimal = service.getAnimal(numIndex);

        System.out.println("Animal Name [" + myAnimal.getName() + "]: ");
        if (scanner.hasNextLine()) {
            String name = scanner.nextLine();
            myAnimal.setName(name);
        } else {

        }

        System.out.println("Species [" + myAnimal.getSpecies() + "]: ");
        if (scanner.hasNextLine()) {
            String species = scanner.nextLine();
            myAnimal.setSpecies(species);
        } else {

        }

        System.out.println("Breed (optional) [" + myAnimal.getBreed() + "]: ");
        if (scanner.hasNextLine()) {
            String breed = scanner.nextLine();
            myAnimal.setBreed(breed);
        } else {

        }

        System.out.println("Description [" + myAnimal.getDescription() + "]: ");
        if (scanner.hasNextLine()) {
            String description = scanner.nextLine();
            myAnimal.setDescription(description);

        } else {

        }
    }

    public void delAnimal() {
        System.out.println("What is the numeric ID of the animal you want to delete?: ");

        int index = scanner.nextInt();

        Animal myAnimal = service.getAnimal(index);

        System.out.println("Name: " + myAnimal.getName());
        System.out.println("Species: " + myAnimal.getSpecies());
        System.out.println("Breed: " + myAnimal.getBreed());
        System.out.println("Description: " + myAnimal.getDescription());


        try {
            System.out.println("Are you sure you wan to delete this animal?: ");
            String deleteIT = scanner.nextLine();

            deleteIT = "yes";

            System.out.println("Success: The animal has been deleted!");
            service.removeAnimal(index);

        } catch (Exception e) {
            System.out.println("\nPlease provide a number.\n");

        }
    }
}

