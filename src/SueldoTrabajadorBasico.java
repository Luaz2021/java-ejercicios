import java.util.Scanner;   
import java.util.Locale;

public class SueldoTrabajadorBasico {
public static void main(String[] args) {
    double horasTrabajadas;
    char claseTrabajador;
    double tarifaHora = 0;
    double sueldoTotal;

    Scanner sc = new Scanner(System.in).useLocale(Locale.US); // Configurar el Scanner para evitar errores con , o . como separador decimal
    System.out.print("Ingrese horas trabajadas: ");
    horasTrabajadas = sc.nextDouble();

    System.out.print("Ingrese clase de trabajador (A, B, C, D): ");
    claseTrabajador = sc.next().toUpperCase().charAt(0);// Usamos toUpperCase para asegurar que la letra sea mayúscula

    switch (claseTrabajador) {
        case 'A':
            tarifaHora = 25.00;
            break;
        case 'B':
            tarifaHora = 20.00;
            break;
        case 'C':
            tarifaHora = 15.00;
            break;
        case 'D':
            tarifaHora = 10.00;
            break;
        default:
            System.out.println("Clase de trabajador no válida.");
            sc.close(); 
            return;
    }
    sueldoTotal = horasTrabajadas * tarifaHora; // Operacion para calcular el sueldo total

    System.out.println("=================================");
    System.out.println(" CÁLCULO SUELDO TRABAJADOR");
    System.out.println("El tipo de trabajador es: " + claseTrabajador+ " y su tarifa por hora es: " + tarifaHora);
    System.out.printf("El sueldo total es: %.2f\n", sueldoTotal);
    
}


}
