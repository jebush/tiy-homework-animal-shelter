/**
 * Created by rush on 9/1/16.
 */
public class AnimalType {
    private int animaTypeId;
    private String animalType;

    public AnimalType(){

    }

    public AnimalType(int animaTypeId, String animalType){
        this.animaTypeId = animaTypeId;
        this.animalType = animalType;
    }

    public int getAnimalTypeId(){
        return this.animaTypeId;
    }

    public void setAnimaTypeId(int animaTypeId){
        this.animaTypeId = animaTypeId;
    }

    public String getAnimalType(){
        return this.animalType;
    }

    public void setAnimalType(String animalType){
        this.animalType = animalType;
    }
}
