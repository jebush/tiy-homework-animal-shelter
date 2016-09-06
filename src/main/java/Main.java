import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws IOException, SQLException {

        //This points to the animal_shelter database
        String jdbcUrl = "jdbc:postgresql://localhost/animal_shelter";

        MainService mainService = new MainService();
        MenuService menuService = new MenuService();
        AnimalRepository animalRepository = new AnimalRepositoryImpl(jdbcUrl);
        AnimalTypeRepository animalTypeRepository = new AnimalTypeRepository(jdbcUrl);
        AnimalsService animalsService = new AnimalsService(animalRepository, animalTypeRepository);



        while(true) {
            int action = menuService.promptForMainMenuSelection();

            if (action == MenuService.Add_Animal){
                // gets the ArrayList from AnimalsService
                ArrayList<Animal> animalType = animalsService.getListAnimalType();
                // lets you create animal
                Animal animal = menuService.createAnimal(animalType);

                animalsService.addAnimals(animal);

            } else if(action == MenuService.Manage_Animal){
                while(true) {
                    //This will prompt for how they want to search for animals
                    int action2 = menuService.promptForAnimalSearch();


                    if(action2 == MenuService.TYPE){

                    }else if (action2 == MenuService.NAME){
                        //The following searches for animals by name
                        String name = menuService.waitForString2("What is the name?", true);
                        // gets the ArrayList from AnimalsService
                        ArrayList<Animal> animalList = animalsService.getAnimalDetails(name);

                        if (!(animalList.isEmpty())) {
                            menuService.listAnimals(animalList);
                            int index = menuService.promptForAnimalIndex();
                            ArrayList<Animal> animal = animalsService.getAnimalById(index);
                            if (!(animal.isEmpty())) {
                                menuService.displayAnimal(animal);
                                mainService.manageAnimal(animal, index);
                            } else {
                                menuService.displayNoAnimal();
                                break;
                            }
                        } else {
                            menuService.displayNoAnimal();
                            break;
                        }

                    } else if (action2 == MenuService.ID){
                        //The following searches for animals by id

                        int index2 = menuService.promptForAnimalIndex();

                        ArrayList<Animal> animalList = animalsService.getAnimalById(index2);

                        if (!(animalList.isEmpty())) {
                            ArrayList<Animal> animal = animalsService.getAnimalById(index2);
                            if (!(animal.isEmpty())) {
                                menuService.displayAnimal(animal);
                                mainService.manageAnimal(animal, index2);
                            } else {
                                menuService.displayNoAnimal();
                                break;
                            }
                        } else {
                            menuService.displayNoAnimal();
                            break;
                        }

                    } else if (action2 == MenuService.ALL_Animals){
                        //the following searches for all animals
                        // gets the ArrayList from AnimalsService
                        ArrayList<Animal> animal = animalsService.getListAnimals();
                        //This will show the Animals off the ArrayList
                        menuService.listAnimals(animal);

                    } else if (action2 == MenuService.RETURN_Main_Menu){
                        //This quits to the main menu
                        break;
                    }else {
                        System.out.println("Error: Sorry, That isn't a valid option");
                    }
                }

            } else if(action == MenuService.Manage_AnimalTypes){

                    mainService.manageAnimalType();

            }else if(action == MenuService.QUIT){
                // quits out of the loop
                menuService.quit();

            } else {
                System.out.println("Error: Sorry, That isn't a valid option");
            }
        }

    }
}
