package MySql_Practica_1.dao;


import MySql_Practica_1.domain.Sociedad;
import MySql_Practica_1.until.ConexionDB;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SociedadDB {

    public List<Sociedad> obtenerSociedades() {

        List<Sociedad> sociedades = new ArrayList<>();
        String sql = "SELECT * FROM sociedades";

        try {
            var connection = ConexionDB.getInstance();
            var pstmet = connection.prepareStatement(sql);
            var resultSet = pstmet.executeQuery();

            while (resultSet.next()) {


                Sociedad sociedad = new Sociedad();
                sociedad.setIdSociedad(resultSet.getInt(1));
                sociedad.setNombre(resultSet.getString(2));
                sociedad.setPais(resultSet.getString(3));
                sociedades.add(sociedad);

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sociedades;
    }

    public Sociedad actualizaSociedad(Sociedad sociedad) {

        // String sql= "update sociedades set ? ? ? where idSociedad = ?";
        String sql = "UPDATE sociedades SET nombre = ?, pais = ? WHERE idSociedad = ?";


        try {
            var conection = ConexionDB.getInstance();
            var pstmet = conection.prepareStatement(sql);

            pstmet.setString(1, sociedad.getNombre());
            pstmet.setString(2, sociedad.getPais());
            pstmet.setInt(3, sociedad.getIdSociedad());

            int filasActualizacion = pstmet.executeUpdate();
            return sociedad;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void eliminarSociedad(Long id) {
        String sql = "delete from sociedades where idSociedad = ?";
        try {
            var conection = ConexionDB.getInstance();
            var pstmet = conection.prepareStatement(sql);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
