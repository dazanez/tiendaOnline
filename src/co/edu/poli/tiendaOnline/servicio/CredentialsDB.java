package co.edu.poli.tiendaOnline.servicio;

import java.util.ResourceBundle;

public class CredentialsDB {
    private static final ResourceBundle CONFIG = ResourceBundle.getBundle("config");

    public String getPassword() {
        return CONFIG.getString("db.password");
    }

    public String getUser() {
        return CONFIG.getString("db.user");
    }

    public String getUrl() {
        return CONFIG.getString("db.url");
    }
}
