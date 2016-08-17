/**
 * Created by rush on 8/16/16.
 */
public class Animal {
    String name;
    String species;
    String breed;
    String description;

    Animal() {

    }

    Animal(String name, String species, String breed, String description){
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.description = description;
    }

    protected String getName(){
        return this.name;
    }

    protected void setName(String name){
        this.name = name;
    }

    protected String getSpecies(){
        return this.species;
    }
    protected void setSpecies(String species){
        this.species = species;
    }

    protected String getBreed(){
        return this.breed;
    }

    protected void setBreed(String breed){
        this.breed = breed;

    }

    protected String getDescription(){
        return this.description;
    }

    protected void setDescription(String description){
        this.description = description;
    }


}
