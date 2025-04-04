package co.edu.poli.tiendadj.modelo;

public class NequiAPI {
    public boolean realizarPago(String celular, double monto) {
        System.out.println("Pago de $" + monto + " realizado con Nequi desde " + celular);
        return true;
    }
}
