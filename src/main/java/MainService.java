import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by rush on 9/2/16.
 */
public class MainService {

    private AnimalRepository animalRepository;


    //This points to the animal_shelter database
    private String jdbcUrl = "jdbc:postgresql://localhost/animal_shelter";

    AnimalTypeRepository animalTypeRepository = new AnimalTypeRepository(jdbcUrl);
    AnimalsService animalsService = new AnimalsService(animalRepository, animalTypeRepository);
    MenuService menuService = new MenuService();

    public MainService () throws SQLException {

    }

    public void manageAnimal(ArrayList<Animal> animalList, int index) throws SQLException {
        while (true) {
            int action = menuService.promptForAnimalManage();

            if (action == MenuService.EDIT_Animal) {




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
