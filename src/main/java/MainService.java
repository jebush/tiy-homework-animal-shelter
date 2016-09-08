import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by rush on 9/2/16.
 */
public class MainService {


    private MenuService menuService;
    private AnimalsService animalsService;

    public MainService () throws SQLException {

    }
    public MainService (MenuService menuService, AnimalsService animalsService) throws SQLException {
        this.menuService = menuService;
        this.animalsService = animalsService;
    }

    public void manageAnimal(Animal animal, ArrayList<Animal> animalList, int index, ArrayList<Animal> animalType) throws SQLException {
        while (true) {

            int action = menuService.promptForAnimalManage();

            if (action == MenuService.EDIT_Animal) {

                if (animal != (null)) {
                    animal = menuService.updateAnimal(animal, animalType);

                    //The below system outs are a test
                    System.out.println(animal.getAnimalID());
                    System.out.println(animal.getBreed());
                    System.out.println(animal.getDescription());
                    System.out.println(animal.getName());
                    System.out.println(animal.getSpecie());
                    //

                    animalsService.updateAnimal(animal);
                } else {
                    menuService.displayNoAnimal();
                }


            } else if (action == MenuService.DELETE_Animal) {
                if (animalList != null) {

                    boolean delete = menuService.deleteAnimal();

                    if (delete) {

                        animalsService.removeAnimal(index);
                        break;
                    } else if (!delete) {

                    }

                } else {
                    menuService.displayNoAnimal();
                }

            } else if (action == MenuService.ADD_Note) {
                Note note = menuService.addNote();
                animalsService.addNote(index, note);

            } else if (action == MenuService.RETURN_Menu) {
                break;
            } else {

            }
        }
    }

    public void manageAnimalType() throws SQLException {

        while (true) {
            //This will prompt for how they want to search for animals
            int action = menuService.promptForAnimalTypeManage();

            if (action == MenuService.View_Animal_Type) {
                // gets the ArrayList from AnimalsService
                ArrayList<Animal> animal = animalsService.getListAnimalType();
                //This will show the Animals off the ArrayList
                menuService.listAnimalType(animal);

            } else if (action == MenuService.Add_Animal_Type) {
                Animal animalType = menuService.addAnimalType();

                animalsService.addAnimalType(animalType);

            } else if (action == MenuService.RETURN_To_Menu) {
                break;
            } else {
                System.out.println("Please pick a number off the menu!");
            }
        }
    }
}
