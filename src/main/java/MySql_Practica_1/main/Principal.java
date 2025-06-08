package MySql_Practica_1.main;

import MySql_Practica_1.dao.SociedadDB;
import MySql_Practica_1.domain.Sociedad;

import java.util.List;

public class Principal {
    public static void main(String[] args) {


        SociedadDB sdb = new SociedadDB();
        List<Sociedad> lista = sdb.obtenerSociedades();

        lista.forEach(System.out::println);

        Sociedad sociedad = new Sociedad();
        sociedad.setIdSociedad(3); // Este debe ser un ID que ya exista en la base de datos
        sociedad.setNombre("Nueva Sociedad Actualizada");
        sociedad.setPais("México");

        var dao = new SociedadDB();
        Sociedad resultado = dao.actualizaSociedad(sociedad);
        if (resultado != null) {
            System.out.println("Sociedad actualizada correctamente: " + resultado);
        } else {
            System.out.println("No se pudo actualizar la sociedad (¿quizás el ID no existe?).");
        }


    }
}
