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

    private int animalTypeId;
    private String animalType;



    //The below needs to be an arraylist for notes
    private ArrayList<Note> notes = new ArrayList<>();


    public Animal() {

    }
    public Animal(int animalid, String name, int specie, String breed, String description){
        this.animalid = animalid;
        this.name = name;
        this.specie = specie;
        this.breed = breed;
        this.description = description;

    }
    public Animal(String name, int specie, String breed, String description){
        this.name = name;
        this.specie = specie;
        this.breed = breed;
        this.description = description;

    }

    public Animal(String name, String species, String breed, String description){
        this.name = name;
        this.species = species;
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

    public Animal(int animalTypeId, String animalType){
        this.animalTypeId = animalTypeId;
        this.animalType = animalType;
    }

    public Animal(String type) {
        this.animalType = type;
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
    public void setSpecie(int specie){
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


    //This is the notes getter and setter
    public ArrayList<Note> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<Note> notes) {
        this.notes = notes;
    }

    //For Animal Types
    public int getAnimalTypeId(){
        return this.animalTypeId;
    }

    public void setAnimaTypeId(int animalTypeId){
        this.animalTypeId = animalTypeId;
    }

    public String getAnimalType(){
        return this.animalType;
    }

    public void setAnimalType(String animalType){
        this.animalType = animalType;
    }

}
