package co.edu.poli.tiendadj.modelo.adapters;

import co.edu.poli.tiendadj.modelo.external.PaypalAPI;
import co.edu.poli.tiendadj.modelo.interfaces.ProcesadorPago;

public class PaypalAdapter implements ProcesadorPago {
    private PaypalAPI paypalAPI;
    private String email;

    public PaypalAdapter(String email) {
        this.paypalAPI = new PaypalAPI();
        this.email = email;
    }

    @Override
    public boolean procesarPago(double monto) {
        return paypalAPI.makePayment(email, monto);
    }
}