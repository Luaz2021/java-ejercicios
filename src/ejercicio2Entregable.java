import java.util.Locale;
import java.util.Scanner;

public class ejercicio2Entregable {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in).useLocale(Locale.US);
    boolean continuar = true;

    System.out.println("Programar una calculadora con reglas específicas:\n- Resta: si b > a se intercambian para restar como b - a\n- División/Modulo: si b == 0 se muestra error\nIngrese dos números por teclado cuando se solicite.");

    System.out.println("**Calculadora**");

        // Usamos While para mostrar las opciones en bucle hasta salir.
        while (continuar) {
            System.out.println("\n Seleccione una opcion: "); // La función \n sirve para saltos de linea
            System.out.println("1.Sumar (+)");
            System.out.println("2 Restar (-)");
            System.out.println("3.Multiplicar (*)");
            System.out.println("4.Dividir (/)");
            System.out.println("5.Resto (%)");
            System.out.println("6.Salir");
            System.out.print("Opción: ");
 
            String opcion = sc.nextLine().trim();
            double num1, num2, resultado; // Declaramos las variables
 
            // Usamos switch para ejecutar las diferentes opciones disponibles
            try {
                //Usamos el formato SOUF para controlar los decimales
                switch (opcion) {
                    case "1": // SUMAR(+)
                        System.out.print("Introduce el primer número: ");
                        num1 = Double.parseDouble(sc.nextLine());
                        System.out.print("Introduce el segundo número: ");
                        num2 = Double.parseDouble(sc.nextLine());
                        resultado = num1 + num2;
                        System.out.printf("Resultado: %.2f + %.2f = %.2f\n", num1, num2, resultado);
                        break;
                    case "2":// RESTAR(-)
                        System.out.print("Introduce el primer número: ");
                        num1 = Double.parseDouble(sc.nextLine());
                        System.out.print("Introduce el segundo número: ");
                        num2 = Double.parseDouble(sc.nextLine());
                        // Condicion pedida por el profesor si b>a entonces los numeros se invierten b - a
                        if (num2 > num1) {
                            resultado = num2 - num1;
                            System.out.printf("Resultado: %.2f - %.2f = %.2f\n", num2, num1, resultado);
                        } else {
                            resultado = num1 - num2;
                            System.out.printf("Resultado: %.2f - %.2f = %.2f\n", num1, num2, resultado);
                        }
                        break;
                    case "3"://MULTIPLICAR(*)
                        System.out.print("Introduce el primer número: ");
                        num1 = Double.parseDouble(sc.nextLine());
                        System.out.print("Introduce el segundo número: ");
                        num2 = Double.parseDouble(sc.nextLine());
                        resultado = num1 * num2;
                        System.out.printf("Resultado: %.2f * %.2f = %.2f\n", num1, num2, resultado);
                        break;
                    case "4": // DIVIDIR(/)
                        System.out.print("Introduce el primer número: ");
                        num1 = Double.parseDouble(sc.nextLine());
                        System.out.print("Introduce el segundo número: ");
                        num2 = Double.parseDouble(sc.nextLine());
                        // Si b = 0 no se puede dividir
                        if (num2 != 0) {
                            resultado = num1 / num2;
                            System.out.printf("Resultado: %.2f / %.2f = %.2f\n", num1, num2, resultado);
                        } else {
                            System.out.println("ERROR: División por cero no permitida.\n");
                        }
                        break;
                    case "5": // RESTO %
                        System.out.print("Introduce el primer número: ");
                        num1 = Double.parseDouble(sc.nextLine());
                        System.out.print("Introduce el segundo número: ");
                        num2 = Double.parseDouble(sc.nextLine());
                        // Si b = 0 no se puede obtener el resto
                        if (num2 != 0) {
                            resultado = num1 % num2;
                            System.out.printf("Resultado: %.2f %% %.2f = %.2f\n", num1, num2, resultado);
                        } else {
                            System.out.println("ERROR: Módulo por cero no permitido.\n");
                        }
                        break;
                    case "6":
                        continuar = false;
                        System.out.println("**Gracias! Saliendo**");
                        break;
                    default:
                        System.out.println("Opción no reconocida. Por favor, elige un número del 1 al 6.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: entrada no válida. Debe introducir números para las operaciones.");
            }
        }
 
        sc.close();
    }
}
