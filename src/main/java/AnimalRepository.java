import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by rush on 8/31/16.
 */
public interface AnimalRepository {
    ResultSet listAnimals() throws SQLException;

    //Need to add some more to this
    void addAnimals(Animal animal) throws SQLException;

    ResultSet getAnimal(String name) throws SQLException;

    ResultSet getSpecificAnimal(int index) throws SQLException;

    void removeAnimal(int index) throws SQLException;

    void updateAnimal(Animal animal) throws SQLException;

    int countOfAnimals();
}
