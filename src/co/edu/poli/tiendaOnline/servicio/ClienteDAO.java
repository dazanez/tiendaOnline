package co.edu.poli.tiendaOnline.servicio;

import co.edu.poli.tiendaOnline.modelo.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements DAO<Cliente, Integer> {
    private Connection conn;

    public ClienteDAO() {
        this.conn = ConnectionDB.getConnection();
    }

    @Override
    public String insertar(Cliente cliente) {
        String sql = "INSERT INTO clientes (id, nombre, email, edad) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, cliente.getId());
            stmt.setString(2, cliente.getNombre());
            stmt.setString(3, cliente.getEmail());
            stmt.setInt(4, cliente.getEdad());
            stmt.executeUpdate();
            return "Cliente insertado con éxito: " + cliente;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Ocurrió un error creando el cliente";
    }

    @Override
    public Cliente obtenerPorId(Integer id) {
        String sql = "SELECT * FROM clientes WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Cliente(rs.getInt("id"), rs.getString("nombre"), rs.getString("email"), rs.getInt("edad"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Cliente> obtenerTodos() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                clientes.add(new Cliente(rs.getInt("id"), rs.getString("nombre"), rs.getString("email"), rs.getInt("edad")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    @Override
    public String actualizar(Cliente cliente) {
        String sql = "UPDATE clientes SET nombre = ?, email = ?, edad = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getEmail());
            stmt.setInt(3, cliente.getEdad());
            stmt.setInt(4, cliente.getId());
            stmt.executeUpdate();
            return "Actualización del cliente realizada con éxito";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Ocurrió un error actualizando el cliente";
    }

    @Override
    public String eliminar(Integer id) {
        String sql = "DELETE FROM clientes WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return "Elimincación completa el cliente";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Ocurrió un error eliminando el cliente";
    }
}
