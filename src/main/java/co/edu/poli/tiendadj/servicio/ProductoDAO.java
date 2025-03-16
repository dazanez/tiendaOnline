package co.edu.poli.tiendadj.servicio;

import co.edu.poli.tiendadj.modelo.*;

import java.sql.*;
import java.util.*;

public class ProductoDAO implements SpecializedDAO<Producto, Integer> {
    private Connection connection;

    public ProductoDAO() throws SQLException {
        this.connection = ConnectionDB.getConnection();
    }

    @Override
    public String insert(Producto producto) throws SQLException {
        String sqlProducto = "INSERT INTO Producto (descripcion) VALUES (?) RETURNING id";
        try (PreparedStatement stmtProducto = connection.prepareStatement(sqlProducto, Statement.RETURN_GENERATED_KEYS)) {
            stmtProducto.setString(1, producto.getDescripcion());
            stmtProducto.executeUpdate();
            ResultSet rs = stmtProducto.getGeneratedKeys();

            if (rs.next()) {
                int productoId = rs.getInt(1);
                producto.setId(productoId);

                if (producto instanceof ProductoAlimenticio) {
                    String sqlAlimenticio = "INSERT INTO ProductoAlimenticio (id, aporte_calorico) VALUES (?, ?)";
                    try (PreparedStatement stmtAlimenticio = connection.prepareStatement(sqlAlimenticio)) {
                        stmtAlimenticio.setInt(1, productoId);
                        stmtAlimenticio.setDouble(2, ((ProductoAlimenticio) producto).getAporteCalorico());
                        stmtAlimenticio.executeUpdate();
                    }
                } else if (producto instanceof ProductoElectrico) {
                    String sqlElectronico = "INSERT INTO ProductoElectronico (id, volt_input) VALUES (?, ?)";
                    try (PreparedStatement stmtElectronico = connection.prepareStatement(sqlElectronico)) {
                        stmtElectronico.setInt(1, productoId);
                        stmtElectronico.setDouble(2, ((ProductoElectrico) producto).getVoltInput());
                        stmtElectronico.executeUpdate();
                    }
                }
                return "Producto insertado con éxito con ID: " + productoId;
            }
        }
        return "Error al insertar producto";
    }

    @Override
    public Producto getById(Integer id) throws SQLException {
        String sql = "SELECT p.id, p.descripcion, pa.aporte_calorico, pe.volt_input " +
                "FROM Producto p " +
                "LEFT JOIN ProductoAlimenticio pa ON p.id = pa.id " +
                "LEFT JOIN ProductoElectronico pe ON p.id = pe.id " +
                "WHERE p.id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String descripcion = rs.getString("descripcion");
                Double aporteCalorico = (Double) rs.getObject("aporte_calorico");
                Double voltInput = (Double) rs.getObject("volt_input");

                if (aporteCalorico != null) {
                    return new ProductoAlimenticioFactory().crearProducto(id, descripcion, aporteCalorico);
                } else if (voltInput != null) {
                    return new ProductoElectricoFactory().crearProducto(id, descripcion, voltInput);
                }
            }
        }
        return null;
    }

    @Override
    public List<Producto> getAll() throws SQLException {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT p.id, p.descripcion, pa.aporte_calorico, pe.volt_input " +
                "FROM Producto p " +
                "LEFT JOIN ProductoAlimenticio pa ON p.id = pa.id " +
                "LEFT JOIN ProductoElectronico pe ON p.id = pe.id";

        try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String descripcion = rs.getString("descripcion");
                Double aporteCalorico = (Double) rs.getObject("aporte_calorico");
                Double voltInput = (Double) rs.getObject("volt_input");

                if (aporteCalorico != null) {
                    productos.add(new ProductoAlimenticioFactory().crearProducto(id, descripcion, aporteCalorico));
                } else if (voltInput != null) {
                    productos.add(new ProductoElectricoFactory().crearProducto(id, descripcion, voltInput));
                }
            }
        }
        return productos;
    }

    @Override
    public String update(Producto producto) throws SQLException {
        String sqlProducto = "UPDATE Producto SET descripcion = ? WHERE id = ?";
        try (PreparedStatement stmtProducto = connection.prepareStatement(sqlProducto)) {
            stmtProducto.setString(1, producto.getDescripcion());
            stmtProducto.setInt(2, producto.getId());
            int rowsAffected = stmtProducto.executeUpdate();

            if (producto instanceof ProductoAlimenticio) {
                String sqlAlimenticio = "UPDATE ProductoAlimenticio SET aporte_calorico = ? WHERE id = ?";
                try (PreparedStatement stmtAlimenticio = connection.prepareStatement(sqlAlimenticio)) {
                    stmtAlimenticio.setDouble(1, ((ProductoAlimenticio) producto).getAporteCalorico());
                    stmtAlimenticio.setInt(2, producto.getId());
                    stmtAlimenticio.executeUpdate();
                }
            } else if (producto instanceof ProductoElectrico) {
                String sqlElectronico = "UPDATE ProductoElectronico SET volt_input = ? WHERE id = ?";
                try (PreparedStatement stmtElectronico = connection.prepareStatement(sqlElectronico)) {
                    stmtElectronico.setDouble(1, ((ProductoElectrico) producto).getVoltInput());
                    stmtElectronico.setInt(2, producto.getId());
                    stmtElectronico.executeUpdate();
                }
            }
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
    public List<Producto> specializedQuery(String name) {
        return null;
    }
}
