import java.util.InputMismatchException;
import java.util.Scanner;

public class SueldoTrabajador {

    public static void main(String[] args) {
       
        System.out.println("Cálculo del sueldo semanal de un trabajador");

            double horasTrabajadas = 0;
            char claseTrabajador;
            double tarifaHora = 0;
            boolean entradaValida;
            final double TARIFA_CLASE_A = 25.00;
            final double TARIFA_CLASE_B = 20.00;
            final double TARIFA_CLASE_C = 15.00;
            final double TARIFA_CLASE_D = 10.00;
        
        try (Scanner sc = new Scanner(System.in)) {
            do {
                System.out.println("Por favor, ingrese el número de horas trabajadas en la semana:");
                try {
                    horasTrabajadas = sc.nextDouble();
                    sc.nextLine(); 
                    if (horasTrabajadas < 0) {
                        System.out.println("ERROR: Las horas trabajadas no pueden ser negativas.");
                        entradaValida = false;
                    } else {
                        entradaValida = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("ERROR: Entrada no válida. Por favor, ingrese un número.");
                    sc.next(); 
                    entradaValida = false;
                }
            } while (!entradaValida);


            do {
                System.out.println("Por favor, ingrese la clase del trabajador (A, B, C, D):");
                claseTrabajador = sc.next().toUpperCase().charAt(0);
                tarifaHora = switch (claseTrabajador) {
                    case 'A' -> TARIFA_CLASE_A;
                    case 'B' -> TARIFA_CLASE_B;
                    case 'C' -> TARIFA_CLASE_C;
                    case 'D' -> TARIFA_CLASE_D;
                    default -> -1.0;
                };
                if (tarifaHora == -1) System.out.println("ERROR: Clase de trabajador no válida. Intente de nuevo.");
            } while (tarifaHora == -1);

            double sueldoTotal = horasTrabajadas * tarifaHora;
            System.out.printf("Las horas trabajadas son: %.2f\n" + "La tarifa por hora es: %.2f\n" + "La clase del trabajador es: %c\n", horasTrabajadas, tarifaHora, claseTrabajador);
            System.out.printf("El sueldo total del trabajador es: %.2f\n", sueldoTotal);

        }
    }
}
