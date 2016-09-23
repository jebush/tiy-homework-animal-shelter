package repositories;

import entities.Animal;
import repositories.AnimalRepository;

import java.sql.*;


/**
 * Created by rush on 8/23/16.
 */
public class AnimalRepositoryImpl implements AnimalRepository {

    //Provides a connection?
    private Connection conn;


    public AnimalRepositoryImpl(String jdbcUrl) throws SQLException {
        this.conn = DriverManager.getConnection(jdbcUrl);
    }

    @Override
    public ResultSet listAnimals() throws SQLException {
        Statement stmt = this.conn.createStatement();
        return stmt.executeQuery("SELECT * FROM animal ORDER BY animalid");
    }

    @Override
    public ResultSet getAnimalByName(String name) throws SQLException {
        PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM animal WHERE name LIKE ?");

        stmt.setString(1, (name+"%"));

        return stmt.executeQuery();
    }

    @Override
    public ResultSet getAnimal(int index) throws SQLException{
       PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM animal WHERE animalid = ?");
       stmt.setInt(1, index);
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

    @Override
    public void removeAnimal(int index) throws SQLException {
        PreparedStatement stmt = this.conn.prepareStatement("DELETE FROM animal WHERE animalid = ?");

        stmt.setInt(1, index);

        stmt.executeUpdate();

    }

    @Override
    public void updateAnimal(Animal animal) throws SQLException {
        PreparedStatement stmt = this.conn.prepareStatement("UPDATE animal SET name = ?, species = ?, breed = ?, description = ? WHERE animalid = ?");

        stmt.setString(1, animal.getName());
        stmt.setInt(2, animal.getSpecie());
        stmt.setString(3, animal.getBreed());
        stmt.setString(4, animal.getDescription());
        stmt.setInt(5, animal.getAnimalID());

        stmt.executeUpdate();
    }


    public ResultSet getAnimalByNameWithType(String name) throws SQLException {
        PreparedStatement stmt = this.conn.prepareStatement("SELECT a.name, at.animaltype, a.breed, a.description FROM animal as a JOIN animaltypes as at ON a.species = at.animaltypesid WHERE name LIKE ?");

        stmt.setString(1, (name + "%"));

        return stmt.executeQuery();
    }


}
