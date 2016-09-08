import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws IOException, SQLException {

        //This points to the animal_shelter database
        String jdbcUrl = "jdbc:postgresql://localhost/animal_shelter";



        AnimalRepository animalRepository = new AnimalRepositoryImpl(jdbcUrl);
        AnimalTypeRepository animalTypeRepository = new AnimalTypeRepository(jdbcUrl);
        NoteRepository noteRepository = new NoteRepository(jdbcUrl);
        AnimalsService animalsService = new AnimalsService(animalRepository, animalTypeRepository, noteRepository);
        MenuService menuService = new MenuService(animalRepository, animalTypeRepository, noteRepository, animalsService);
        MainService mainService = new MainService(menuService, animalsService);



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
                        //The following get the arraylist of animal types
                        ArrayList<Animal> animalType = animalsService.getListAnimalType();

                        String result = menuService.listAnimalTypeAsString(animalType);
                        System.out.print(result);
                        System.out.println();

                        //The following searches by animal type name
                        String name = menuService.waitForString2("What is the Animal Type you want to search?", true);

                        ArrayList<Animal> animals = animalsService.getListByAnimalType(name);

                        //This makes sure there is the animal they are searching exists
                        if (!(animals.isEmpty())) {

                            //This lists all animals returned by the search
                            menuService.listAnimals(animals);
                            int index = menuService.promptForAnimalIndex();
                            ArrayList<Animal> animal = animalsService.getAnimalById(index);
                            if (!(animal.isEmpty())) {
                                menuService.displayAnimal(animal);
                                Animal realTinyAnimal = animalsService.getAnimal(index);

                                //The following get the arraylist of animal types
                                ArrayList<Animal> animalTypes = animalsService.getListAnimalType();

                                mainService.manageAnimal(realTinyAnimal, animal, index, animalTypes);
                                System.out.println();
                            } else {
                                menuService.displayNoAnimal();
                                break;
                            }
                        } else {
                            menuService.displayNoAnimal();
                        }

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
                                Animal realTinyAnimal = animalsService.getAnimal(index);

                                //The following get the arraylist of animal types
                                ArrayList<Animal> animalType = animalsService.getListAnimalType();

                                mainService.manageAnimal(realTinyAnimal, animal, index, animalType);
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
                            menuService.displayAnimal(animalList);


                            Animal realAnimal = animalsService.getAnimal(index2);

                            //This gets the notes
                            ArrayList<Note> note = animalsService.getAllAnimalNotesWithID(realAnimal);
                            //This displays the notes
                            menuService.displayAnimalNotes(note);

                            // gets the ArrayList from AnimalsService
                            ArrayList<Animal> animalType = animalsService.getListAnimalType();

                            mainService.manageAnimal(realAnimal, animalList, index2, animalType);

                            System.out.println();
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

                        int index3 = menuService.promptForAnimalIndex();

                        ArrayList<Animal> animalList = animalsService.getAnimalById(index3);

                        if (!(animalList.isEmpty())) {
                            ArrayList<Animal> animal2 = animalsService.getAnimalById(index3);
                            if (!(animal.isEmpty())) {
                                menuService.displayAnimal(animal2);
                                Animal realAnimal = animalsService.getAnimal(index3);

                                //The following get the arraylist of animal types
                                ArrayList<Animal> animalType = animalsService.getListAnimalType();

                                mainService.manageAnimal(realAnimal, animal2, index3, animalType);
                                break;
                            } else {
                                menuService.displayNoAnimal();
                                break;
                            }
                        } else {
                            menuService.displayNoAnimal();
                            break;
                        }

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
