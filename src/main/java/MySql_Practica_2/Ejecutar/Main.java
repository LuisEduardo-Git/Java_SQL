package MySql_Practica_2.Ejecutar;

import MySql_Practica_2.dao.SociedadesDB;
import MySql_Practica_2.domain.Sociedad;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // INSERTAR DATOS
        try {
            List<String> lista = Files.readAllLines(Path.of("Sociedades.txt"), StandardCharsets.ISO_8859_1);

            lista.remove(0);
            SociedadesDB sociedadDB = new SociedadesDB();
            int contador = 0;
            for (String reg : lista) {

                if (contador >= 150) break;
                String[] partes = reg.split("\\t");

                if (partes.length == 3) {

                    int sociedades = Integer.parseInt(partes[0]);
                    String nombre = partes[1];
                    String pais = partes[2];

                    Sociedad s = new Sociedad(sociedades, nombre, pais);
                    sociedadDB.insertarSociedad(s);
                    contador++;

                } else {
                    System.out.println("Línea ignorada: " + reg);
                }
            }
            System.out.println("Se insertaron " + contador + " registros");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // CONSULTAR (OBTENER) SOCIEDADES

        SociedadesDB sociedadesDB = new SociedadesDB();
        List<Sociedad> lista = sociedadesDB;


    }
}
