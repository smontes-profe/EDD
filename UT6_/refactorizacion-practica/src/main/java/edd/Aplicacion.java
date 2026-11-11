package edd;

public class Aplicacion {

    public static void main(String[] args) {
        Pedido pedido = new Pedido();
        pedido.cliente = "Lucía";
        pedido.clienteFrecuente = true;
        pedido.productos.add("Teclado");
        pedido.precios.add(79.99);
        pedido.productos.add("Ratón");
        pedido.precios.add(24.99);

        ProcesadorPedidos procesador = new ProcesadorPedidos();
        double total = procesador.procesar(pedido);

        System.out.printf("Total del pedido de %s: %.2f euros%n", pedido.cliente, total);

        Pedido pedidoPequeno = new Pedido();
        pedidoPequeno.cliente = "Mario";
        pedidoPequeno.productos.add("Cable");
        pedidoPequeno.precios.add(10.00);

        double totalPequeno = procesador.procesar(pedidoPequeno);
        System.out.printf("Total del pedido de %s: %.2f euros%n", pedidoPequeno.cliente, totalPequeno);
    }
}
