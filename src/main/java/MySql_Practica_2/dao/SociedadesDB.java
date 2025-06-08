package MySql_Practica_2.dao;

import MySql_Dos.domain.Sociedad;
import MySql_Dos.until.ConexionDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SociedadesDB {

    public Sociedad insertarSociedad(Sociedad sociedad) {

        String sql = "insert into sociedades (sociedad, nombre, pais) VALUES (?, ?, ?)";

        try {
            var connection = ConexionDB.getInstance();
            var pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, sociedad.getSociedad());
            pstmt.setString(2, sociedad.getNombre());
            pstmt.setString(3, sociedad.getPais());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return sociedad;
    }

    public void insertarRegistros(List<String> registros) {
        try {
            var connection = MySql_Practica_2.until.ConexionDB.getInstance();
            String sql = "insert into sociedades (sociedad, nombre, pais) VALUES (?, ?, ?)";
            var pstmt = connection.prepareStatement(sql);

            connection.setAutoCommit(false);
            for (int i = 1; i < 151; i++) {

                String[] reg = registros.get(i).split("\\t");
                pstmt.setInt(1, Integer.parseInt(reg[0]));
                pstmt.setString(2, reg[1]);
                pstmt.setString(2, reg[2]);
                pstmt.addBatch();
                if (i % 50 ==0 ) {
                    pstmt.executeBatch();
                    connection.commit();
                }
            }
            pstmt.executeBatch();
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Sociedad obtenerSociedadXid(Long id) {
        Sociedad sociedad = null;
        String sql = "select * from sociedades where idSociedad = ?";
        try {
            var connection = ConexionDB.getInstance();
            var pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, id);
            var resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                sociedad = new Sociedad(resultSet.getInt("1"), resultSet.getString("2"), resultSet.getString("3"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return sociedad;
    }

    public Sociedad actualizarSociedad(Sociedad sociedad) {

        String sql = "update sociedades set nombre=?, pais=? where idSociedad=?  ";

        try {
            var connection = ConexionDB.getInstance();
            var pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, sociedad.getNombre());
            pstmt.setString(2, sociedad.getPais());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return sociedad;
    }

    public boolean eliminrSociedad(Long id) {
        String sql = "delete from sociedades where sociedad = ?";
        try {
            var connection = ConexionDB.getInstance();
            var pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
        }
        return true;
    }

}
