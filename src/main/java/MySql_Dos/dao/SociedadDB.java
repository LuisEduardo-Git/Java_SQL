package MySql_Dos.dao;

import MySql_Dos.domain.Sociedad;
import MySql_Dos.until.ConexionDB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

public class SociedadDB {
    private static final Logger logger = LoggerFactory.getLogger(Sociedad.class);

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
            logger.error("Error al insertar sociedad: " + e.getMessage());
        }

        return sociedad;
    }
}
