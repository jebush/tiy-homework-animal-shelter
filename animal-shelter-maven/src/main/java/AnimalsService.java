import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class AnimalsService {




    private AnimalRepository animalRepository;

    private AnimalTypeRepository animalTypeRepository;

    public AnimalsService(AnimalRepository animalRepository){
        this.animalRepository = animalRepository;

    }

    public AnimalsService(AnimalTypeRepository animalTypeRepository){
        this.animalTypeRepository = animalTypeRepository;

    }

    public ArrayList<Animal> getListAnimals() throws SQLException {
        ResultSet resultSet = animalRepository.listAnimals();

        // new arraylist of animal, empty by default
        ArrayList<Animal> littleAnimals = new ArrayList<>();

        // loop over our peeps
        while(resultSet.next()){
            Animal animal = new Animal(
                    resultSet.getInt("animalid"),
                    resultSet.getString("name"),
                    resultSet.getString("species"),
                    resultSet.getString("breed"),
                    resultSet.getString("description")
            );

            littleAnimals.add(animal);
        }

        return littleAnimals;
    }
    public ArrayList<Animal> getAnimalDetails(String name) throws SQLException {
        ResultSet resultSet = animalRepository.getAnimal(name);

        // new arraylist of animal, empty by default
        ArrayList<Animal> littleAnimals = new ArrayList<>();

        // loop over our peeps
        while(resultSet.next()){
            Animal animal = new Animal(
                    resultSet.getInt("animalid"),
                    resultSet.getString("name"),
                    resultSet.getString("species"),
                    resultSet.getString("breed"),
                    resultSet.getString("description")
            );

            littleAnimals.add(animal);
        }

        return littleAnimals;
    }

    public ArrayList<Animal> getAnimalById(int index) throws SQLException {
        ResultSet resultSet = animalRepository.getSpecificAnimal(index);

        // new arraylist of animal, empty by default
        ArrayList<Animal> littleAnimals = new ArrayList<>();

        // loop over our peeps
        while(resultSet.next()){
            Animal animal = new Animal(
                    resultSet.getInt("animalid"),
                    resultSet.getString("name"),
                    resultSet.getString("species"),
                    resultSet.getString("breed"),
                    resultSet.getString("description")
            );

            littleAnimals.add(animal);
        }

        return littleAnimals;
    }

    public ArrayList<AnimalType> getListAnimalType() throws SQLException {
        ResultSet resultSet = animalTypeRepository.listAnimalType();

        // new arraylist of animal type, empty by default
        ArrayList<AnimalType> littleAnimals = new ArrayList<>();

        // loop over our peeps
        while(resultSet.next()){
            AnimalType animalType = new AnimalType(
                    resultSet.getInt("animaltypesid"),
                    resultSet.getString("animaltype")
            );

            littleAnimals.add(animalType);
        }

        return littleAnimals;
    }


    //
    //Need to change the below
    //

    public int countOfAnimals(){
        return animalRepository.countOfAnimals();
    }
//
    public void addAnimals(Animal animal) throws SQLException {
        animalRepository.addAnimals(animal);
    }


 //   public Animal getAnimal(String name) {
//
 //       try {
 //           return animalRepository.getAnimal(name);
 //       } catch (IndexOutOfBoundsException e){
 //           return null;
 //       }
//
 //   }

    public void updateAnimal(int index, Animal animal) throws IOException{
        animalRepository.updateAnimal(index, animal);
    }

    public void removeAnimal(int index) throws IOException {

        animalRepository.removeAnimal(index);

    }



}
