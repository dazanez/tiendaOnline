package co.edu.poli.tiendadj.modelo.external;

public class PaypalAPI {
    public boolean makePayment(String email, double amount) {
        System.out.println("Pago de $" + amount + " realizado con PayPal desde " + email);
        return true;
    }
}
