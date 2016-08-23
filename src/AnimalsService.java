import java.util.ArrayList;


public class AnimalsService {


    private ArrayList<Animal> littleAnimals = new ArrayList<>();

    public AnimalsService(){

    }


    public ArrayList<Animal> getListAnimals() {
        return littleAnimals;
    }
    public int countOfAnimals(){
        return littleAnimals.size();
    }

    public void addAnimals(Animal animal) {
         littleAnimals.add(animal);
    }


    public Animal getAnimal(int index) {

        try {
            return littleAnimals.get(index);
        } catch (IndexOutOfBoundsException e){
            return null;
        }

    }

    public void updateAnimal(int index, Animal animal){
        littleAnimals.add(index, animal);
    }

    public Animal removeAnimal(int index) {

        return littleAnimals.remove(index);

    }



}
