package edd;

public class ProcesadorPedidos {

    public double procesar(Pedido p) {
        double t = 0;

        for (int i = 0; i < p.precios.size(); i++) {
            System.out.println("Añadiendo producto: " + p.productos.get(i));
            t = t + p.precios.get(i);
        }

        t = calcularDescuento(t, p.clienteFrecuente);

        if ((t + (t * 0.21)) < 50) {
            t = calcularEnvio(t + (t * 0.21));
        } else {
            t = t + (t * 0.21);
        }

        return t;
    }

    private double calcularDescuento(double importe, boolean clienteFrecuente) {
        if (clienteFrecuente) {
            if (importe > 100) {
                System.out.println("Descuento aplicado.");
                return importe - (importe * 0.10);
            } else {
                return importe;
            }
        } else {
            return importe;
        }
    }

    private double calcularEnvio(double importe) {
        return importe + 5.95;
    }
}
