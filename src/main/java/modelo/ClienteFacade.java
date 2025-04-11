package modelo;

public class ClienteFacade {
    private InformacionPersonalManager info;
    private HistorialPedidosManager historial;
    private FormasPagoManager pago;

    public ClienteFacade(InformacionPersonalManager info, HistorialPedidosManager historial, FormasPagoManager pago) {
        this.info = info;
        this.historial = historial;
        this.pago = pago;
    }

    public String mostrarTodo() {
        return info.mostrar() + "\n" + historial.mostrar() + "\n" + pago.mostrar();
    }
}
