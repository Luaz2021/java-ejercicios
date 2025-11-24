import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Locale;


public class CalculadoraIva {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        double baseImponible = 0.0;
        String tipoIva;
        String codPromocional;

        double tasaIva = 0.0;
        int porcentajeIva = 0;
        double importeIva = 0.0;
        double precioConIva = 0.0;
        double descuento = 0.0;
        double totalFinal = 0.0;
        boolean baseImponibleValida = false;
        final double IVA_GENERAL = 0.21;
        final double IVA_REDUCIDO = 0.10;
        final double IVA_SUPERREDUCIDO = 0.04;


         System.out.println("Calculadora de IVA y Descuentos");
        do {
            try {
                System.out.println("Introduzca la base imponible:");
                baseImponible = sc.nextDouble();
                sc.nextLine(); 
 
                if (baseImponible > 0) {
                    baseImponibleValida = true;
                } else {
                    System.out.println("Error: La base imponible debe ser un número positivo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Entrada no válida. Por favor, ingrese un número.");
                sc.nextLine(); 
            }
        } while (!baseImponibleValida);
        

        do {
            System.out.println("Introduzca el tipo de IVA (general, reducido, superreducido):");
            tipoIva = sc.nextLine().toLowerCase();
            switch (tipoIva) {
                case "general":
                    tasaIva = IVA_GENERAL;
                    porcentajeIva = 21;
                    break;
                case "reducido":
                    tasaIva = IVA_REDUCIDO;
                    porcentajeIva = 10;
                    break;
                case "superreducido":
                    tasaIva = IVA_SUPERREDUCIDO;
                    porcentajeIva = 4;
                    break;
                default:
                    System.out.println("Tipo de IVA no válido. Por favor, inténtelo de nuevo.");
            }
        } while (tasaIva == 0.0);

        importeIva = baseImponible * tasaIva;
        precioConIva = baseImponible + importeIva;

        String codigoUsado = "";
        do {
            System.out.println("Introduzca el código promocional (nopro, mitad, meno5, 5porc):");
            codPromocional = sc.nextLine().toLowerCase();
            switch (codPromocional) {
                case "nopro":
                    descuento = 0.0;
                    codigoUsado = "nopro";
                    break;
                case "mitad":
                    descuento = precioConIva / 2;
                    codigoUsado = "mitad";
                    break;
                case "meno5":
                    descuento = 5.0;
                    codigoUsado = "meno5";
                    break;
                case "5porc":
                    descuento = precioConIva * 0.05;
                    codigoUsado = "5porc";
                    break;
                default:
                    System.out.println("Código promocional no válido. Por favor, inténtelo de nuevo.");
            }
        } while (codigoUsado.isEmpty());

        totalFinal = precioConIva - descuento;

        System.out.println("\n--- DETALLE DE LA FACTURA ---");
        System.out.printf("%-30s %.2f%n", "Base imponible", baseImponible);
        System.out.printf("%-30s %.2f%n", "IVA (" + porcentajeIva + "%)", importeIva);
        System.out.printf("%-30s %.2f%n", "Precio con IVA", precioConIva);
        System.out.printf("%-30s -%.2f%n", "Cód. promo. (" + codigoUsado + "):", descuento);
        System.out.printf("%-30s %.2f%n", "TOTAL", totalFinal);
        System.out.println("-----------------------------");

        sc.close();
    }





}
