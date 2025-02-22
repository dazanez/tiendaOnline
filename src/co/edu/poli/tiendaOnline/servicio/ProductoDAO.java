package co.edu.poli.tiendaOnline.servicio;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.poli.tiendaOnline.modelo.Producto;

public class ProductoDAO implements SpecializedDAO<Producto, Integer> {
    private Connection conn = ConnectionDB.getConnection();

    @Override
    public String insertar(Producto producto) {
        String sql = "INSERT INTO productos (id, descripcion) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, producto.getId());
            stmt.setString(2, producto.getDescripcion());
            stmt.executeUpdate();
            return "Producto insertado"+producto;
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error producto insertado";
        }
    }

    @Override
    public Producto obtenerPorId(Integer id) {
        String sql = "SELECT * FROM productos WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Producto(rs.getInt("id"), rs.getString("descripcion"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Producto> obtenerTodos() {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM productos";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                productos.add(new Producto(rs.getInt("id"), rs.getString("descripcion")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productos;
    }


    @Override
    public String actualizar(Producto producto) {
        String sql = "UPDATE productos SET descripcion = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, producto.getDescripcion());
            stmt.setInt(2, producto.getId());
            stmt.executeUpdate();
            return "Producto actualizado";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error actualizando producto";
        }
    }

    @Override
    public String eliminar(Integer id) {
        String sql = "DELETE FROM productos WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return "Producto eliminado";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error eliminando el producto";
        }
    }

    @Override
    public Producto specializedQuery(String name) {
        return null;
    }
}
