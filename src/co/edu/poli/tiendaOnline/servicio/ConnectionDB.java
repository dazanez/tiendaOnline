package co.edu.poli.tiendaOnline.servicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    private static Connection connection = null;
    private static final CredentialsDB credentialsDB = new CredentialsDB();

    private ConnectionDB() { }

    public static synchronized Connection getConnection() {
        if (connection == null) {
            try {
                final String URL = credentialsDB.getUrl();
                final String USER = credentialsDB.getUser();
                final String PASSWORD = credentialsDB.getPassword();

                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("✅ Conexión establecida con PostgreSQL");

            } catch (SQLException e) {
                System.err.println("❌ Error de conexión: " + e.getMessage());
            }
        }
        return connection;
    }

    public static synchronized void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
                System.out.println("🔴 Conexión cerrada correctamente");
            } catch (SQLException e) {
                System.err.println("❌ Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
