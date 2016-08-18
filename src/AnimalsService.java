import java.util.ArrayList;


public class AnimalsService {


    private ArrayList<Animal> littleAnimals = new ArrayList<>();


    protected ArrayList<Animal> getListAnimals() {
        return littleAnimals;
    }

    protected void setListAnimals(ArrayList<Animal> animalList) {
         littleAnimals = animalList;
    }


    protected Animal getAnimal(int index) {

        return littleAnimals.get(index - 1);

    }

    protected Animal removeAnimal(int index) {

        return littleAnimals.remove(index - 1);

    }



}
