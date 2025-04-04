package co.edu.poli.tiendadj.modelo;

public class NequiAdapter implements ProcesadorPago {
    private NequiAPI nequiAPI;
    private String celular;

    public NequiAdapter(String celular) {
        this.nequiAPI = new NequiAPI();
        this.celular = celular;
    }

    @Override
    public boolean procesarPago(double monto) {
        return nequiAPI.realizarPago(celular, monto);
    }
}
