package modelo;

public class ClienteFacade {
    private InformacionPersonalManager info;
    private HistorialPedidosManager historial;
    private FormasPagoManager pago;

    public ClienteFacade() {
        info = new InformacionPersonalManager();
        historial = new HistorialPedidosManager();
        pago = new FormasPagoManager();
    }

    public String mostrarInformacion() {
        return info.mostrar();
    }

    public String mostrarHistorialPedidos() {
        return historial.mostrar();
    }

    public String mostrarFormasPago() {
        return pago.mostrar();
    }
}
