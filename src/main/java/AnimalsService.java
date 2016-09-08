import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class AnimalsService {



    //This points to the animal_shelter database
    private String jdbcUrl = "jdbc:postgresql://localhost/animal_shelter";

    private AnimalRepository animalRepository = new AnimalRepositoryImpl(jdbcUrl);

    private AnimalTypeRepository animalTypeRepository = new AnimalTypeRepository(jdbcUrl);

    private NoteRepository noteRepository = new NoteRepository(jdbcUrl);

    public AnimalsService() throws SQLException {

    }

    public AnimalsService(AnimalRepository animalRepository, AnimalTypeRepository animalTypeRepository, NoteRepository noteRepository) throws SQLException {
        this.animalRepository = animalRepository;
        this.animalTypeRepository = animalTypeRepository;
        this.noteRepository = noteRepository;
    }

    public ArrayList<Animal> getListAnimals() throws SQLException {
        ResultSet resultSet = animalRepository.listAnimals();

        // new arraylist of animal, empty by default
        ArrayList<Animal> littleAnimals = new ArrayList<>();

        // loop over our animal
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
        ResultSet resultSet = animalRepository.getAnimalByName(name);

        // new arraylist of animal, empty by default
        ArrayList<Animal> littleAnimals = new ArrayList<>();

        // loop over our animal
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

        // loop over our animal
        while(resultSet.next()){
            Animal animal = new Animal(
                    resultSet.getInt("animalid"),
                    resultSet.getString("name"),
                    resultSet.getInt("species"),
                    resultSet.getString("breed"),
                    resultSet.getString("description")
            );

            littleAnimals.add(animal);
        }

        return littleAnimals;
    }

    public ArrayList<Animal> getListAnimalType() throws SQLException {
        ResultSet resultSet = animalTypeRepository.listAnimalType();

        // new arraylist of animal type, empty by default
        ArrayList<Animal> littleAnimals = new ArrayList<>();

        // loop over our animal types
        while(resultSet.next()){
            Animal animalType = new Animal(
                    resultSet.getInt("animaltypesid"),
                    resultSet.getString("animaltype")
            );

            littleAnimals.add(animalType);
        }

        return littleAnimals;
    }

    public String getSpecificAnimalType(int index) throws SQLException {
        String animalType = animalTypeRepository.getAnimalTypeById(index);

        return animalType;
    }

    public int getTypeIDByName(String string) throws SQLException {
        return animalTypeRepository.getTypeIDByName(string);
    }

    public void addAnimalType(Animal animalType) throws SQLException {
        animalTypeRepository.addAnimalType(animalType);
    }


    public void removeAnimal(int index) throws SQLException {
        this.animalRepository.removeAnimal(index);

    }

    public void updateAnimal(Animal animal) throws SQLException {
        this.animalRepository.updateAnimal(animal);
    }


    public void addAnimals(Animal animal) throws SQLException {
        animalRepository.addAnimals(animal);
    }


    public Animal getAnimal(int index) throws SQLException {
        Animal animal = new Animal();


        try {
            ResultSet results = this.animalRepository.getSpecificAnimal(index);
            while (results.next()) {
                animal.setAnimalid(results.getInt("animalid"));
                animal.setName(results.getString("name"));
                animal.setSpecie(results.getInt("species"));
                animal.setBreed(results.getString("breed"));
                animal.setDescription(results.getString("description"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return animal;
    }

    public void addNote(int animalId,  Note note) throws SQLException {
        this.noteRepository.addAnimalNote(animalId, note);
    }

    public ArrayList<Note> getAllAnimalNotesWithID(Animal animal) throws SQLException {
        ArrayList<Note> notes = new ArrayList<>();

        ResultSet results = this.noteRepository.listNotesForAnimal(animal);
        while (results.next()) {
            Note note = new Note(
                    results.getInt("noteid"),
                    results.getString("note"),
                    results.getString("date")
            );
            notes.add(note);
        }

        return notes;
    }

}
