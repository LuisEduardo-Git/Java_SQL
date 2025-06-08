package MySql_Dos.Main;

import MySql_Dos.dao.AlumnosDB;
import MySql_Dos.dao.SociedadDB;
import MySql_Dos.domain.Alumno;
import MySql_Dos.domain.Sociedad;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class Principal {
    private static final Logger logger = LoggerFactory.getLogger(Principal.class);

    public static void main(String[] args) {

        try {
            List<String> lista = Files.readAllLines(Path.of("Sociedades.txt"), StandardCharsets.ISO_8859_1);

            lista.remove(0);
            SociedadDB sociedadDB = new SociedadDB();
            int contador = 0;
            for (String reg : lista) {

                if (contador >= 150) break;
                String[] partes = reg.split("\\t");

                if (partes.length == 3) {

                        int sociedades = Integer.parseInt(partes[0].trim());
                        String nombre = partes[1].trim();
                        String pais = partes[2].trim();

                        Sociedad sociedad = new Sociedad(sociedades, nombre, pais);
                        sociedadDB.insertarSociedad(sociedad);
                        contador++;

                } else {
                    System.out.println("Línea ignorada por formato inválido: " + reg);
                }
            }
            System.out.println("Se insertaron " + contador + " registros");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        AlumnosDB alumnosDB = new AlumnosDB();


    }
}
