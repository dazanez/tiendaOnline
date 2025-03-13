package co.edu.poli.tiendadj.servicio;
import co.edu.poli.tiendadj.modelo.Cliente;
import co.edu.poli.tiendadj.modelo.Pedido;
import co.edu.poli.tiendadj.modelo.Producto;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.time.LocalDate;

public class PedidoDAO implements DAO<Pedido, Integer> {
    private Connection connection;

    public PedidoDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public String insert(Pedido pedido) throws SQLException {
        String sql = "INSERT INTO Pedido (calle, fecha, ciudad, cliente_id) VALUES (?, ?, ?, ?) RETURNING id";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, pedido.getCalle());
            stmt.setDate(2, Date.valueOf(pedido.getFecha()));
            stmt.setString(3, pedido.getCiudad());
            stmt.setInt(4, pedido.getCliente().getId());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt(1);
                pedido.setId(id);
                insertProductosPedido(id, pedido.getProductos());
                return "Pedido insertado con ID: " + id;
            }
            return "Error al insertar pedido";
        }
    }

    private void insertProductosPedido(int pedidoId, List<Producto> productos) throws SQLException {
        String sql = "INSERT INTO Pedido_Producto (pedido_id, producto_id) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            for (Producto producto : productos) {
                stmt.setInt(1, pedidoId);
                stmt.setInt(2, producto.getId());
                stmt.executeUpdate();
            }
        }
    }

    @Override
    public Pedido getById(Integer id) throws SQLException {
        String sql = "SELECT * FROM Pedido WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Cliente cliente = new ClienteDAO().getById(rs.getInt("cliente_id"));
                List<Producto> productos = getProductosByPedido(id);
                return new Pedido(
                        rs.getString("calle"),
                        rs.getDate("fecha").toLocalDate(),
                        rs.getString("ciudad"),
                        productos,
                        cliente,
                        id
                );
            }
        }
        return null;
    }

    private List<Producto> getProductosByPedido(int pedidoId) throws SQLException {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT producto_id FROM Pedido_Producto WHERE pedido_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, pedidoId);
            ResultSet rs = stmt.executeQuery();
            ProductoDAO productoDAO = new ProductoDAO(connection);
            while (rs.next()) {
                productos.add(productoDAO.getById(rs.getInt("producto_id")));
            }
        }
        return productos;
    }

    @Override
    public List<Pedido> getAll() throws SQLException {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM Pedido";
        try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                pedidos.add(getById(rs.getInt("id")));
            }
        }
        return pedidos;
    }

    @Override
    public String update(Pedido pedido) throws SQLException {
        String sql = "UPDATE Pedido SET calle = ?, fecha = ?, ciudad = ?, cliente_id = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, pedido.getCalle());
            stmt.setDate(2, Date.valueOf(pedido.getFecha()));
            stmt.setString(3, pedido.getCiudad());
            stmt.setInt(4, pedido.getCliente().getId());
            stmt.setInt(5, pedido.getId());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                deleteProductosPedido(pedido.getId());
                insertProductosPedido(pedido.getId(), pedido.getProductos());
                return "Pedido actualizado con éxito";
            }
            return "Error al actualizar pedido";
        }
    }

    private void deleteProductosPedido(int pedidoId) throws SQLException {
        String sql = "DELETE FROM Pedido_Producto WHERE pedido_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, pedidoId);
            stmt.executeUpdate();
        }
    }

    @Override
    public String delete(Integer id) throws SQLException {
        deleteProductosPedido(id);
        String sql = "DELETE FROM Pedido WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0 ? "Pedido eliminado con éxito" : "Error al eliminar pedido";
        }
    }
}
