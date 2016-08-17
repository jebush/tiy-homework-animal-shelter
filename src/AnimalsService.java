import java.util.ArrayList;
import java.util.Scanner;


public class AnimalsService {
    Scanner scanner = new Scanner(System.in);

    //Animal myAnimal = new Animal();

    private ArrayList<Animal> littleAnimals = new ArrayList<>();

    protected void listAnimals(){
        System.out.println(littleAnimals);

    }

    protected void createAnimal(){
        Animal myAnimal = new Animal();

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

    }

    protected   void getAnimal(int index){
        Animal myAnimal = littleAnimals.get(index - 1);

        System.out.println(myAnimal);

    }

    protected void editAnimal(int index){
        Animal myAnimal = littleAnimals.get(index - 1);

        System.out.println("Animal Name [" + myAnimal.name + "]: ");
        if (scanner.hasNextLine()) {
            String name = scanner.nextLine();
            myAnimal.setName(name);
        } else {
            System.out.println();
        }

        System.out.println("Species [" + myAnimal.species + "]: ");
        if (scanner.hasNextLine()) {
            String species = scanner.nextLine();
            myAnimal.setSpecies(species);
        } else {
            System.out.println();
        }

        System.out.println("Breed (optional) [" + myAnimal.breed + "]: ");
        if (scanner.hasNextLine()) {
            String breed = scanner.nextLine();
            myAnimal.setBreed(breed);
        } else {
            System.out.println();
        }

        System.out.println("Description [" + myAnimal.description + "]: ");
        if (scanner.hasNextLine()) {
            String description = scanner.nextLine();
            myAnimal.setDescription(description);

        } else {
            System.out.println();
        }

    }


    protected void deleteAnimal(int index){
        littleAnimals.remove(index - 1);

    }
}
