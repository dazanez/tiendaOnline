package co.edu.poli.tiendadj.servicio;

import co.edu.poli.tiendadj.modelo.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements DAO<Cliente, Integer> {
    private Connection connection;

    public ClienteDAO() throws SQLException {
        this.connection = ConnectionDB.getConnection();  // Obtener conexión de la base de datos
    }

    @Override
    public String insert(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO Cliente (nombre, email, edad) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getEmail());
            stmt.setInt(3, cliente.getEdad());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                return "Cliente insertado correctamente";
            } else {
                return "Error al insertar el cliente";
            }
        }
    }

    @Override
    public Cliente getById(Integer id) throws SQLException {
        String sql = "SELECT * FROM Cliente WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Cliente(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getInt("edad")
                );
            }
        }
        return null;  // Retorna null si no se encuentra el cliente
    }

    @Override
    public List<Cliente> getAll() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getInt("edad")
                );
                clientes.add(cliente);
            }
        }
        return clientes;
    }

    @Override
    public String update(Cliente cliente) throws SQLException {
        String sql = "UPDATE Cliente SET nombre = ?, email = ?, edad = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getEmail());
            stmt.setInt(3, cliente.getEdad());
            stmt.setInt(4, cliente.getId());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                return "Cliente actualizado correctamente";
            } else {
                return "Error al actualizar el cliente";
            }
        }
    }

    @Override
    public String delete(Integer id) throws SQLException {
        String sql = "DELETE FROM Cliente WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                return "Cliente eliminado correctamente";
            } else {
                return "Error al eliminar el cliente";
            }
        }
    }
}