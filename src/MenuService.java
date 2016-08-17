/**
 * Created by rush on 8/16/16.
 */
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

        } catch(Exception e){
            System.out.println("\nPlease provide a number.\n");

            value = waitForInt(message);
        }

        return value;
    }

    public void listAnimals(){
        service.listAnimals();
        System.out.println("\n-- List of Animals --\n" +
                "\n" +
                "1)" + "\n" +
                "2) \n" +
                "3) \n" +
                "4) \n" +
                "5) \n" +
                "6) \n");
    }

    public void createAnimal(){

        service.createAnimal();
    }

    public void getAnimal(){
        System.out.println("What is the numeric ID of the animal you want to view?: ");
        int numIndex = scanner.nextInt();
        service.getAnimal(numIndex);

    }

    public void editAnimal(){
        System.out.println("What is the numeric ID of the animal you want to edit?: ");
        int numIndex = scanner.nextInt();
        service.editAnimal(numIndex);
    }

    public void delAnimal(){
        System.out.println("What is the numeric ID of the animal you want to delete?: ");
        int numIndex = scanner.nextInt();
        service.deleteAnimal(numIndex);
    }




}
