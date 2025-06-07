package MySql.Principal;

import MySql.dao.AlumnosDB;
import MySql.domain.Alumno;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        AlumnosDB alumnosDB = new AlumnosDB();
        //alumnosDB.obtemerAlumnos();

        List<Alumno> alumnoList = alumnosDB.obtemerAlumnos();

        alumnoList.forEach(System.out::println);

        // HOLA DESDE EL IDE

        //Este es un comentario desde GitHub
    }

}
