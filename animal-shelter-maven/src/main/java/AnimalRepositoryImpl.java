import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;


/**
 * Created by rush on 8/23/16.
 */
public class AnimalRepositoryImpl implements AnimalRepository {

    //Provides a connection?
    private Connection conn;

    //private final Path pathToFile;
//
    //private final Gson gson;

    private ArrayList<Animal> littleAnimals = new ArrayList<>();

    public AnimalRepositoryImpl(String jdbcUrl) throws SQLException {
        this.conn = DriverManager.getConnection(jdbcUrl);
    }

    @Override
    public ResultSet listAnimals() throws SQLException {
        Statement stmt = this.conn.createStatement();
        return stmt.executeQuery("SELECT * FROM animal");
    }

    @Override
    public ResultSet getAnimal(String name) throws SQLException {
        PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM animal WHERE  name LIKE ?");

        stmt.setString(1, (name+"%"));

        return stmt.executeQuery();
    }

    @Override
    public ResultSet getSpecificAnimal(int xWing) throws SQLException {
        PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM animal WHERE animalid = ?");

        stmt.setInt(1, xWing);

        return stmt.executeQuery();
    }


    @Override
    public void addAnimals(Animal animal) throws SQLException {
        PreparedStatement stmt = this.conn.prepareStatement("INSERT INTO animal (\"name\", \"species\", \"breed\", \"description\") VALUES (?, ?, ?, ?);\n");

        stmt.setString(1, animal.getName());
        stmt.setInt(2, animal.getSpecie());
        stmt.setString(3, animal.getBreed());
        stmt.setString(4, animal.getDescription());


        stmt.execute();
    }


    //
    //Need to change over
    //

    @Override
    public void updateAnimal(int index, Animal animal) throws IOException{
        littleAnimals.add(index, animal);


    }

    @Override
    public void removeAnimal(int index) throws IOException{

        littleAnimals.remove(index);



    }
    @Override
    public int countOfAnimals(){
        return littleAnimals.size();
    }


}
