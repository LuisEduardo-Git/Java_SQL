package MySql.dao;

import MySql.domain.Alumno;
import MySql.until.ConexionDB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlumnosDB {
    private static final Logger logger = LoggerFactory.getLogger(AlumnosDB.class);

    public List<Alumno> obtemerAlumnos(){

        List<Alumno> alumnos = new ArrayList<>();
        String sql = "select * from alumnos";

        try {

            var connection = ConexionDB.getInstance();
            var pstmt = connection.prepareStatement(sql);
            var resultSet = pstmt.executeQuery();

            while (resultSet.next()) {

                Alumno alumno = new Alumno();
                alumno.setId(resultSet.getLong(1));
                alumno.setNombre(resultSet.getString(2));
                alumno.setCuenta(resultSet.getInt(3));
                /*System.out.println(resultSet.getString(1));
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getString(3));
                 */
                alumnos.add(alumno);
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return alumnos;
    }
}
