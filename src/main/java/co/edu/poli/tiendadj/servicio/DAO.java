	package co.edu.poli.tiendadj.servicio;

    import java.sql.SQLException;
    import java.util.List;

    // Interfaz genérica CRUD para cualquier entidad (T)
    public interface DAO<T, t> {
        String insert(T entidad) throws SQLException;
        T getById(t id) throws SQLException;
        List<T> getAll() throws SQLException;
        String update(T entidad) throws SQLException;
        String delete(t id) throws SQLException;
    }