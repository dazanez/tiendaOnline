package co.edu.poli.tiendadj.servicio;

import co.edu.poli.tiendadj.modelo.Producto;
import co.edu.poli.tiendadj.modelo.ProductoAlimenticio;
import co.edu.poli.tiendadj.modelo.ProductoElectronico;

import java.sql.*;
import java.util.*;

public class ProductoDAO implements SpecializedDAO<Producto, Integer> {
    private Connection connection;

    public ProductoDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public String insert(Producto producto) throws SQLException {
        String sql = "INSERT INTO Producto (descripcion) VALUES (?) RETURNING id";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, producto.getDescripcion());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt(1);
                producto.setId(id);
                if (producto instanceof ProductoAlimenticio) {
                    return insertProductoAlimenticio((ProductoAlimenticio) producto);
                } else if (producto instanceof ProductoElectronico) {
                    return insertProductoElectronico((ProductoElectronico) producto);
                }
                return "Producto insertado con ID: " + id;
            }
            return "Error al insertar producto";
        }
    }

    private String insertProductoAlimenticio(ProductoAlimenticio producto) throws SQLException {
        String sql = "INSERT INTO ProductoAlimenticio (id, aporte_calorico) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, producto.getId());
            stmt.setFloat(2, producto.getAporteCalorico());
            int rows = stmt.executeUpdate();
            return rows > 0 ? "Producto alimenticio insertado" : "Error al insertar producto alimenticio";
        }
    }

    private String insertProductoElectronico(ProductoElectronico producto) throws SQLException {
        String sql = "INSERT INTO ProductoElectronico (id, volt_input) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, producto.getId());
            stmt.setFloat(2, producto.getVoltInput());
            int rows = stmt.executeUpdate();
            return rows > 0 ? "Producto electrónico insertado" : "Error al insertar producto electrónico";
        }
    }

    @Override
    public Producto getById(Integer id) throws SQLException {
        String sql = "SELECT * FROM Producto WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String descripcion = rs.getString("descripcion");
                return getSpecificProduct(id, descripcion);
            }
        }
        return null;
    }

    private Producto getSpecificProduct(int id, String descripcion) throws SQLException {
        String sqlAlim = "SELECT aporte_calorico FROM ProductoAlimenticio WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sqlAlim)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new ProductoAlimenticio(id, descripcion, rs.getFloat("aporte_calorico"));
            }
        }

        String sqlElec = "SELECT volt_input FROM ProductoElectronico WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sqlElec)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new ProductoElectronico(id, descripcion, rs.getFloat("volt_input"));
            }
        }

        return new Producto(id, descripcion);
    }

    @Override
    public List<Producto> getAll() throws SQLException {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT id, descripcion FROM Producto";
        try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String descripcion = rs.getString("descripcion");
                productos.add(getSpecificProduct(id, descripcion));
            }
        }
        return productos;
    }

    @Override
    public String update(Producto producto) throws SQLException {
        String sql = "UPDATE Producto SET descripcion = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, producto.getDescripcion());
            stmt.setInt(2, producto.getId());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0 ? "Producto actualizado con éxito" : "Error al actualizar producto";
        }
    }

    @Override
    public String delete(Integer id) throws SQLException {
        String sql = "DELETE FROM Producto WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0 ? "Producto eliminado con éxito" : "Error al eliminar producto";
        }
    }

    @Override
    public List<Producto> specializedQuery(String description) {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM Producto WHERE descripcion ILIKE ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, "%" + description + "%");  // Búsqueda parcial e insensible a mayúsculas/minúsculas
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                productos.add(new Producto(rs.getInt("id"), rs.getString("descripcion")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

}
