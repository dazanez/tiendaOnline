package co.edu.poli.tiendadj.servicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionDB {

    private static Connection connection = null;
    private static final ResourceBundle CONFIG = ResourceBundle.getBundle("config");

    private ConnectionDB() { }

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            final String URL = CONFIG.getString("db.url");
            final String USER = CONFIG.getString("db.user");
            final String PASSWORD = CONFIG.getString("db.password");

            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Conexión establecida con PostgreSQL");
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
            connection = null;
            System.out.println("🔴 Conexión cerrada correctamente");
        }
    }
}
