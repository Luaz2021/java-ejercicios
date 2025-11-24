import java.util.Locale;
import java.util.Scanner;


public class CalculadoraIvaBasic {
    public static void main(String[] args) {
        double baseImponible;
        String tipoIva;
        String codPromocional;
        double tasaIva;
        int porcentajeIva;
        double importeIva;
        double precioConIva;
        double descuento;
        double totalFinal;

        Scanner sc = new Scanner(System.in).useLocale(Locale.US);// Para evitar errores con , o . como separador decimal

        System.out.println("Calculadora de IVA y Descuentos");

        System.out.print("Introduzca la base imponible: ");
        baseImponible = sc.nextDouble();//Leer base imponible

        System.out.print("Introduzca el tipo de IVA (general, reducido, superreducido): ");
        tipoIva = sc.next().toLowerCase();//Leer tipo de IVA y convertir a minúsculas para facilitar comparación
        switch (tipoIva) {
            case "general":
                tasaIva = 0.21;
                porcentajeIva = 21;
                break;
            case "reducido":
                tasaIva = 0.10;
                porcentajeIva = 10;
                break;                       
            case "superreducido":
                tasaIva = 0.04;     
                porcentajeIva = 4;
                break;
            default:
                System.out.println("Tipo de IVA no válido.");
                sc.close();
                return;
        }
        System.out.print("Introduzca el código promocional (nopro, mitad, meno5, 5porc): ");
        codPromocional = sc.next().toLowerCase();//Leer código promocional y convertir a minúsculas para facilitar comparación
        importeIva = baseImponible * tasaIva;
        precioConIva = baseImponible + importeIva;
        switch (codPromocional) {
            case "nopro":
                descuento = 0.0;
                break;
            case "mitad":
                descuento = precioConIva / 2;
                break;
            case "meno5":
                descuento = 5.0;
                break;
            case "5porc":
                descuento = precioConIva * 0.05;
                break;
            default:
                System.out.println("Código promocional no válido.");
                sc.close();
                return;
        }
        totalFinal = precioConIva - descuento;
        System.out.println("=================================");
        System.out.println("DETALLE DEL CÁLCULO");
        System.out.println("La base imponible es: " + baseImponible );
        System.out.println("El IVa aplicado es: " + porcentajeIva + "%");
        System.out.println("El precio con IVA es: " + precioConIva);
        System.out.println("El código promocional es: " + codPromocional);
        System.out.println("El precio total es: " + totalFinal);
        System.out.println("=================================");
        
        sc.close(); 
    }
}
