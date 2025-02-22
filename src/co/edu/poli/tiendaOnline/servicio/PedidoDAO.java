package co.edu.poli.tiendaOnline.servicio;

import co.edu.poli.tiendaOnline.modelo.Pedido;
import co.edu.poli.tiendaOnline.modelo.Producto;
import co.edu.poli.tiendaOnline.modelo.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO implements DAO<Pedido, Integer> {
    private Connection conn;

    public PedidoDAO() {
        this.conn = ConnectionDB.getConnection();
    }

    @Override
    public String insertar(Pedido pedido) {
        String sqlPedido = "INSERT INTO pedidos (cliente_id, calle, ciudad, fecha) VALUES (?, ?, ?, ?) RETURNING id";
        String sqlRelacion = "INSERT INTO pedido_productos (pedido_id, producto_id) VALUES (?, ?)";

        try (PreparedStatement pstmtPedido = conn.prepareStatement(sqlPedido, Statement.RETURN_GENERATED_KEYS)) {
            pstmtPedido.setInt(1, pedido.getCliente().getId());
            pstmtPedido.setString(2, pedido.getCalle());
            pstmtPedido.setString(3, pedido.getCiudad());
            pstmtPedido.setDate(4, Date.valueOf(pedido.getFecha()));

            pstmtPedido.executeUpdate();

            // Obtener el ID generado del pedido
            ResultSet rs = pstmtPedido.getGeneratedKeys();
            if (rs.next()) {
                int pedidoId = rs.getInt(1);
                System.out.println("✅ Pedido insertado con ID: " + pedidoId);

                // Insertar productos asociados al pedido
                try (PreparedStatement pstmtRelacion = conn.prepareStatement(sqlRelacion)) {
                    for (Producto producto : pedido.getProducto()) {
                        pstmtRelacion.setInt(1, pedidoId);
                        pstmtRelacion.setInt(2, producto.getId());
                        pstmtRelacion.executeUpdate();
                    }
                }
                return "✅ Productos asociados al pedido insertados.";
            }        
        } catch (SQLException e) {
            return "❌ Error al insertar pedido: " + e.getMessage();
        }
		return sqlRelacion;
    }

    @Override
    public Pedido obtenerPorId(Integer id) {
        String sql = "SELECT * FROM pedidos WHERE id = ?";
        Pedido pedido = null;

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                ClienteDAO clienteDAO = new ClienteDAO();
                Cliente cliente = clienteDAO.obtenerPorId(rs.getInt("cliente_id"));

                pedido = new Pedido(rs.getString("calle"), rs.getDate("fecha").toLocalDate(),
                        rs.getString("ciudad"), new ArrayList<>(), cliente, id);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al obtener pedido por ID: " + e.getMessage());
        }
        return pedido;
    }

    @Override
    public List<Pedido> obtenerTodos() {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM pedidos";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                ClienteDAO clienteDAO = new ClienteDAO();
                Cliente cliente = clienteDAO.obtenerPorId(rs.getInt("cliente_id"));

                Pedido pedido = new Pedido(rs.getString("calle"), rs.getDate("fecha").toLocalDate(),
                        rs.getString("ciudad"), new ArrayList<>(), cliente, 0);
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al obtener todos los pedidos: " + e.getMessage());
        }
        return pedidos;
    }

    @Override
    public String actualizar(Pedido pedido) {
        String sql = "UPDATE pedidos SET calle = ?, ciudad = ?, fecha = ?, cliente_id = ? WHERE id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, pedido.getCalle());
            pstmt.setString(2, pedido.getCiudad());
            pstmt.setDate(3, Date.valueOf(pedido.getFecha()));
            pstmt.setInt(4, pedido.getCliente().getId());
            pstmt.setInt(5, pedido.getId()); // Aquí se asume que Pedido tiene un campo "id"

            pstmt.executeUpdate();
            return "✅ Pedido actualizado: " + pedido;
        } catch (SQLException e) {
           return "❌ Error al actualizar pedido: " + e.getMessage();
        }
    }

    @Override
    public String eliminar(Integer id) {
        String sqlPedido = "DELETE FROM pedidos WHERE id = ?";
        String sqlRelacion = "DELETE FROM pedido_productos WHERE pedido_id = ?";

        try (PreparedStatement pstmtRelacion = conn.prepareStatement(sqlRelacion);
             PreparedStatement pstmtPedido = conn.prepareStatement(sqlPedido)) {

            pstmtRelacion.setInt(1, id);
            pstmtRelacion.executeUpdate();

            pstmtPedido.setInt(1, id);
            pstmtPedido.executeUpdate();

            return "✅ Pedido eliminado con ID: " + id;
        } catch (SQLException e) {
            return "❌ Error al eliminar pedido: " + e.getMessage();
        }
    }
}
