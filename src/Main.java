import java.util.ArrayList;

public class Main {
    public static void main(String[] args){

        MenuService menuService = new MenuService();
        AnimalsService animalsService = new AnimalsService();


        while(true) {
            int action = menuService.promptForMainMenuSelection();

            if(action == MenuService.LIST_Animal){
                // gets the ArrayList from AnimalsService
                ArrayList<Animal> animal = animalsService.getListAnimals();

                //This will show the Animals off the ArrayList
                menuService.listAnimals(animal);


            } else if(action == MenuService.CREATE_Animal){
                // lets you create animal
                Animal animal = menuService.createAnimal();

                animalsService.addAnimals(animal);

            }else if(action == MenuService.VIEW_Animal){
                // This lets you view a specific animal
                int index = menuService.promptForAnimalIndex();

                Animal animal = animalsService.getAnimal(index);

                if (animal != null) {
                    menuService.displayAnimal(animal);
                } else {
                    menuService.displayNoAnimal();
                }

            }else if(action == MenuService.EDIT_Animal){
                // gets index of animal
                int index = menuService.promptForAnimalIndex();

                Animal animal = animalsService.getAnimal(index);

                if (animal != null) {
                    //This is allow you to edit the animal
                    animal = menuService.editAnimal(animal);

                    //This will let you push your updates
                    animalsService.updateAnimal(index, animal);

                    animalsService.removeAnimal(index + 1);



                    menuService.displayAnimal(animal);

                } else{
                    menuService.displayNoAnimal();
                }


            }else if(action == MenuService.DELETE_Animal){

                // gets index of animal
                int index = menuService.promptForAnimalIndex("What is the numeric ID of the animal you want to Delete?");

                Animal animal = animalsService.getAnimal(index);



                if (animal != null) {

                    menuService.displayAnimal(animal);
                    boolean delete = menuService.deleteAnimal();

                    if (delete){
                        animalsService.removeAnimal(index);
                    } else if (!delete){

                    }

                } else {
                    menuService.displayNoAnimal();
                }


            }else if(action == MenuService.QUIT){
                // quits out of the loop
                menuService.quit();

            } else {
                System.out.println("Error: Sorry, That isn't a valid option");
            }
        }

    }
}
