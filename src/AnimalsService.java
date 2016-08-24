import java.io.IOException;
import java.util.ArrayList;



public class AnimalsService {




    private AnimalRepository littleAnimals;

    public AnimalsService(AnimalRepository animalRepository){
        this.littleAnimals = animalRepository;

    }


    public ArrayList<Animal> getListAnimals() {
        return littleAnimals.listAnimals();
    }
    public int countOfAnimals(){
        return littleAnimals.countOfAnimals();
    }

    public void addAnimals(Animal animal) throws IOException{
         littleAnimals.addAnimals(animal);
    }


    public Animal getAnimal(int index) {

        try {
            return littleAnimals.getAnimal(index);
        } catch (IndexOutOfBoundsException e){
            return null;
        }

    }

    public void updateAnimal(int index, Animal animal) throws IOException{
        littleAnimals.updateAnimal(index, animal);
    }

    public void removeAnimal(int index) throws IOException {

        littleAnimals.removeAnimal(index);

    }



}
