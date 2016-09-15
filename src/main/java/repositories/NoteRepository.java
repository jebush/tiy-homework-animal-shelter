package repositories;

import entities.Animal;
import entities.Note;

import java.sql.*;
import java.time.LocalDate;

public class NoteRepository {
    private Connection conn;

    public NoteRepository(String jdbcUrl) throws SQLException {
        this.conn = DriverManager.getConnection(jdbcUrl);
    }

    public ResultSet listNotesForAnimal (Animal animal) throws SQLException {

        PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM note WHERE animal = ?");
        stmt.setInt(1, animal.getAnimalID());
        return stmt.executeQuery();
    }

    public ResultSet getAnimalNote(int noteid) throws SQLException {
        PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM note WHERE noteid = ?");
        stmt.setString(1, Integer.toString(noteid));
        return stmt.executeQuery();
    }
    public void addAnimalNote(int animalId, Note note) throws SQLException{
        PreparedStatement stmt = this.conn.prepareStatement("INSERT INTO note (animal, note, date) VALUES (?, ?, ?)");
        stmt.setInt(1, animalId);
        stmt.setString(2, note.gettext());
        stmt.setDate(3, Date.valueOf(LocalDate.now()));
        stmt.executeUpdate();
    }

    public void deleteNote(int noteid) throws SQLException {
        PreparedStatement stmt = this.conn.prepareStatement("DELETE FROM note WHERE noteid = ?");
        stmt.setInt(1, noteid);
        stmt.executeUpdate();
    }
}
