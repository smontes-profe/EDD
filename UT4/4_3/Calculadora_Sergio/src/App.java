import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nElige una operación:");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            if (!scanner.hasNextInt()) {
                if (!scanner.hasNext()) {
                    break;
                }
                System.out.println("Introduce una opción numérica.");
                scanner.next();
                continue;
            }

            int opcion = scanner.nextInt();
            if (opcion == 0) {
                break;
            }
            if (opcion < 1 || opcion > 4) {
                System.out.println("Opción no válida. Elige un número del 1 al 4.");
                continue;
            }

            Double primerNumero = leerNumero(scanner, "Primer número: ");
            if (primerNumero == null) {
                break;
            }
            Double segundoNumero = leerNumero(scanner, "Segundo número: ");
            if (segundoNumero == null) {
                break;
            }

            if (opcion == 4 && segundoNumero == 0) {
                System.out.println("No se puede dividir entre cero.");
                continue;
            }

            double resultado;
            switch (opcion) {
                case 1:
                    resultado = sumar(primerNumero, segundoNumero);
                    break;
                case 2:
                    resultado = restar(primerNumero, segundoNumero);
                    break;
                case 3:
                    resultado = multiplicar(primerNumero, segundoNumero);
                    break;
                default:
                    resultado = dividir(primerNumero, segundoNumero);
                    break;
            }

            System.out.println("Resultado: " + resultado);
        }

        scanner.close();
        System.out.println("Hasta luego.");
    }

    private static Double leerNumero(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            }
            if (!scanner.hasNext()) {
                return null;
            }
            System.out.println("Introduce un número válido.");
            scanner.next();
        }
    }

    public static double sumar(double primerNumero, double segundoNumero) {
        return primerNumero + segundoNumero;
    }

    public static double restar(double primerNumero, double segundoNumero) {
        return primerNumero - segundoNumero;
    }

    public static double multiplicar(double primerNumero, double segundoNumero) {
        return primerNumero * segundoNumero;
    }

    public static double dividir(double primerNumero, double segundoNumero) {
        return primerNumero / segundoNumero;
    }

    public static double triplicar(double numero){
        return numero*3;
    }
}
