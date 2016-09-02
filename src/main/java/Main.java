import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws IOException, SQLException {

        //This points to the animal_shelter database
        String jdbcUrl = "jdbc:postgresql://localhost/animal_shelter";

        MenuService menuService = new MenuService();
        AnimalRepository animalRepository = new AnimalRepositoryImpl(jdbcUrl);
        AnimalsService animalsService = new AnimalsService(animalRepository);
        AnimalTypeRepository animalTypeRepository = new AnimalTypeRepository(jdbcUrl);
        AnimalsService animalsServiceType = new AnimalsService(animalTypeRepository);



        while(true) {
            int action = menuService.promptForMainMenuSelection();

            if (action == MenuService.Add_Animal){
                // lets you create animal
                Animal animal = menuService.createAnimal();

                animalsService.addAnimals(animal);

            } else if(action == MenuService.Manage_Animal){
                while(true) {
                    //This will prompt for how they want to search for animals
                    int action2 = menuService.promptFoAnimalSearch();



                    if(action2 == 1){

                    }else if (action2 == 2){
                        //The following searches for animals by name
                        String name = menuService.waitForString2("What is the name?", true);
                        // gets the ArrayList from AnimalsService
                        ArrayList<Animal> animal = animalsService.getAnimalDetails(name);

                        menuService.listAnimals(animal);

                    } else if (action2 == 3){
                        //The following searches for animals by id

                        int index = menuService.promptForAnimalIndex();

                        ArrayList<Animal> animal = animalsService.getAnimalById(index);


                        menuService.displayAnimal(animal);

                    } else if (action2 == 4){
                        //the following searches for all animals
                        // gets the ArrayList from AnimalsService
                        ArrayList<Animal> animal = animalsService.getListAnimals();
                        //This will show the Animals off the ArrayList
                        menuService.listAnimals(animal);

                    } else if (action2 == 5){
                        //This quits to the main menu
                        break;
                    }else {
                        System.out.println("Error: Sorry, That isn't a valid option");
                    }
                }

            } else if(action == MenuService.Manage_AnimalTypes){
                // gets the ArrayList from AnimalsService
                ArrayList<AnimalType> animal = animalsServiceType.getListAnimalType();
                //This will show the Animals off the ArrayList
                menuService.listAnimalType(animal);

            }else if(action == MenuService.QUIT){
                // quits out of the loop
                menuService.quit();

            } else {
                System.out.println("Error: Sorry, That isn't a valid option");
            }
        }

    }
}
