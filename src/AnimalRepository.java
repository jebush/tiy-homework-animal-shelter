import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


/**
 * Created by rush on 8/23/16.
 */
public class AnimalRepository {

    private final Path pathToFile;

    private final Gson gson;

    private ArrayList<Animal> littleAnimals = new ArrayList<>();

    public AnimalRepository(String file) throws IOException{
        gson = new GsonBuilder().setPrettyPrinting().create();


        pathToFile = Paths.get(file);

        if(Files.exists(pathToFile)) {
            String json = new String(Files.readAllBytes(pathToFile));
            Type listType = new TypeToken<ArrayList<Animal>>(){}.getType();

            littleAnimals = gson.fromJson(json, listType);

        }

    }

    private void putDataInFile() throws IOException{
        String json = gson.toJson(littleAnimals);
        Files.write(pathToFile, json.getBytes());

    }

    public ArrayList<Animal> listAnimals(){
        return littleAnimals;
    }

    //Need to add some more to this
    public void addAnimals(Animal animal) throws IOException{
        littleAnimals.add(animal);

        putDataInFile();
    }

    public Animal getAnimal(int index) {
            return littleAnimals.get(index);
    }

    public void updateAnimal(int index, Animal animal) throws IOException{
        littleAnimals.add(index, animal);

        putDataInFile();
    }

    public void removeAnimal(int index) throws IOException{

        littleAnimals.remove(index);

        putDataInFile();

    }
    public int countOfAnimals(){
        return littleAnimals.size();
    }


}
