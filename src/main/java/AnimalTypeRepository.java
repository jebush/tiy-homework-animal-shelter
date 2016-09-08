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
        return stmt.executeQuery("SELECT * FROM animaltypes ORDER BY animaltypesid");
    }

    public ResultSet listColumumAnimalType() throws SQLException {
        Statement stmt = this.conn.createStatement();
        return stmt.executeQuery("SELECT animaltype FROM animaltypes");
    }

    public void addAnimalType(Animal animalType) throws SQLException {
        PreparedStatement stmt = this.conn.prepareStatement("INSERT INTO animaltypes (\"animaltype\") VALUES (?);\n");

        stmt.setString(1, animalType.getAnimalType());

        stmt.execute();
    }

    public String getAnimalTypeById(int xWing) throws SQLException {
        PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM animaltypes WHERE animaltypesid = ?");

        String result = "";

        stmt.setInt(1, xWing);
        ResultSet resultString = stmt.executeQuery();
        if (resultString.next()) {
            result = resultString.getString("animaltype");
        }

        return result;

    }

    protected int getTypeIDByName(String type) throws SQLException{
        int returnInt = -1;
        //Parameter/Sanitized SQL query
        PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM animaltypes WHERE animaltypesid = ?");
        stmt.setString(1, type);
        ResultSet intResult = stmt.executeQuery();
        if(intResult.next()) {
            returnInt = ((Number)intResult.getObject(1)).intValue();
        }
        return returnInt;
    }


}
