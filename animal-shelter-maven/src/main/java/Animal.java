import java.util.ArrayList;

/**
 * Created by rush on 8/16/16.
 */
public class Animal {
    private int animalid;
    private String name;
    private String species;
    private int specie;
    private String breed;
    private String description;

    //The below needs to be an arraylist for notes
    private ArrayList<Note> notes = new ArrayList<>();


    public Animal() {

    }

    public Animal(String name, int specie, String breed, String description){
        this.name = name;
        this.specie = specie;
        this.breed = breed;
        this.description = description;

    }

    public Animal(int animalid, String name, String species, String breed, String description){
        this.animalid = animalid;
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.description = description;

    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getSpecies(){
        return this.species;
    }
    public void setSpecies(String species){
        this.species = species;
    }

    public int getSpecie(){
        return this.specie;
    }
    public void setSpecie(int species){
        this.specie = specie;
    }

    public String getBreed(){
        return this.breed;
    }

    public void setBreed(String breed){
        this.breed = breed;

    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public int getAnimalID(){
        return this.animalid;
    }
    public void setAnimalid(int animalid){
        this.animalid = animalid;
    }

}
