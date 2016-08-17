import java.util.Scanner;

/**
 * Created by rush on 8/16/16.
 */
public class Main {
    public static void main(String[] args){
        MenuService menuService = new MenuService();

        while(true) {
            int action = menuService.promptForMainMenuSelection();

            if(action == 1){
                // do something
                menuService.listAnimals();

            } else if(action == 2){
                // do something
                menuService.createAnimal();

            }else if(action == 3){
                // do something
                menuService.getAnimal();

            }else if(action == 4){
                // do something
                menuService.editAnimal();

            }else if(action == 5){
                // do something
                menuService.delAnimal();


            }else if(action == 6){
                // do something
                break;

            } else {
                System.out.println("Error: Sorry, That isn't a valid option");
            }
        }

    }
}
