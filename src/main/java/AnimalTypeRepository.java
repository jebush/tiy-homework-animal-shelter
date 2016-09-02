import java.sql.*;

/**
 * Created by rush on 8/31/16.
 */
public class AnimalTypeRepository {

    //Provides a connection?
    private Connection conn;

    public AnimalTypeRepository(String jdbcUrl) throws SQLException {
        this.conn = DriverManager.getConnection(jdbcUrl);
    }

    public ResultSet listAnimalType() throws SQLException {
        Statement stmt = this.conn.createStatement();
        return stmt.executeQuery("SELECT * FROM animaltypes");
    }

    public ResultSet listColumumAnimalType() throws SQLException {
        Statement stmt = this.conn.createStatement();
        return stmt.executeQuery("SELECT animaltype FROM animaltypes");
    }

    public void addAnimals(AnimalType animalType) throws SQLException {
        PreparedStatement stmt = this.conn.prepareStatement("INSERT INTO animaltypes (\"animaltype\") VALUES (?);\n");

        stmt.setString(1, animalType.getAnimalType());



        stmt.execute();
    }

}
