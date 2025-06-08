package MySql.until;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    private static final String url = "jdbc:mysql://localhost:3306/organizacion_archivos";
    private static final String nombre= "root";
    private static final String contrasenia = "2004";
    private static Connection connection;

    private ConexionDB() { }

    public static Connection getInstance() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(url, nombre,contrasenia);
        }
        return connection;
    }


}
