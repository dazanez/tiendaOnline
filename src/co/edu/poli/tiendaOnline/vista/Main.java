package co.edu.poli.tiendaOnline.vista;

import co.edu.poli.tiendaOnline.servicio.ConnectionDB;

public class Main {
    public static void main(String[] args) {
        /*// Obtener conexión
        ClienteDAO clienteDAO = new ClienteDAO();
        ProductoDAO productoDAO = new ProductoDAO();
        PedidoDAO pedidoDAO = new PedidoDAO();

        // Insertar un cliente en la base de datos
        Cliente cliente = new Cliente(1, "Andres", "example2@gmail.com", 18);
        clienteDAO.insertar(cliente);
        System.out.println("✅ Cliente insertado: " + cliente);

        // Insertar productos en la base de datos
        Producto producto1 = new Producto(12, "Celular");
        Producto producto2 = new Producto(2, "Audífonos");

        productoDAO.insertar(producto1);
        productoDAO.insertar(producto2);

        System.out.println("✅ Productos insertados: " + producto1 + " y " + producto2);

        // Crear una lista de productos
        List<Producto> productos = new ArrayList<>();
        productos.add(producto1);
        productos.add(producto2);

        // Insertar un pedido con los productos y el cliente
        Pedido pedido = new Pedido("Cra 7 #32", LocalDate.of(2025, 2, 7), "Bogotá", productos, cliente, 1);
        pedidoDAO.insertar(pedido);
        System.out.println("✅ Pedido insertado: " + pedido);

        // Obtener y mostrar todos los clientes registrados
        List<Cliente> clientes = clienteDAO.obtenerTodos();
        System.out.println("\n📌 Lista de clientes registrados:");
        for (Cliente c : clientes) {
            System.out.println(c);
        }

        // Obtener y mostrar todos los pedidos registrados
        List<Pedido> pedidos = pedidoDAO.obtenerTodos();
        System.out.println("\n📌 Lista de pedidos registrados:");
        for (Pedido p : pedidos) {
            System.out.println(p);
        }
*/
        ConnectionDB.getConnection();
        // Cerrar la conexión al final del programa
        ConnectionDB.closeConnection();
    }
}
