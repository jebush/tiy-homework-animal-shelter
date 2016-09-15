package services;

import entities.Animal;
import repositories.AnimalRepository;
import repositories.AnimalRepositoryImpl;
import repositories.AnimalTypeRepository;
import repositories.NoteRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/ListAnimals")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String name = "Bo";
        if (req.getParameterMap().containsKey("name")) {
            name = req.getParameter("name");
        }

        // put the name of animal into the attributes
        req.setAttribute("name", name);

        // forward to the jsp form
        req.getRequestDispatcher("/WEB-INF/ListAnimal.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            String jdbcUrl = "jdbc:postgresql://localhost/animal_shelter";

            AnimalRepository animalRepository = new AnimalRepositoryImpl(jdbcUrl);

            AnimalTypeRepository animalTypeRepository = new AnimalTypeRepository(jdbcUrl);

            NoteRepository noteRepository = new NoteRepository(jdbcUrl);

            AnimalsService animalsService = new AnimalsService(animalRepository, animalTypeRepository, noteRepository);

            String name = req.getParameter("name");
            ArrayList<Animal>  animalListByName = animalsService.getAnimalDetailsByName(name);

            // put the animal into the attributes
            req.setAttribute("animalListByName", animalListByName);

            // forward to the jsp view
            req.getRequestDispatcher("/WEB-INF/ListAnimal.jsp").forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
