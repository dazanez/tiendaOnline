package co.edu.poli.tiendadj.modelo;

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