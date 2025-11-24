import java.util.Locale;
import java.util.Scanner;

public class Ejercicio1Entregable {

    private static double leerNota(Scanner teclado, int numeroNota, double notaMinima, double notaMaxima) {
        double nota;
        do {
            System.out.printf("Ingrese la nota %d (entre %.0f y %.0f): ", numeroNota, notaMinima, notaMaxima);
            
            if (teclado.hasNextDouble()) {
                nota = teclado.nextDouble();
                if (nota < notaMinima || nota > notaMaxima) {
                    System.out.printf("ERROR: La nota debe estar entre %.0f y %.0f. Intente de nuevo.\n", 
                                    notaMinima, notaMaxima);
                } else {
                    return nota;
                }
            } else {
                System.out.println("ERROR: Entrada no válida. Por favor, ingrese un número.");
                teclado.next();
                nota = 0;
            }
        } while (true);
    }

    private static String leerNombre(Scanner teclado) {
        String nombre;
        do {
            System.out.println("Por favor, ingrese su nombre:");
            nombre = teclado.nextLine().trim();
            if (nombre.isEmpty()) {
                System.out.println("ERROR: El nombre no puede estar vacío.");
            } else {
                return nombre;
            }
        } while (true);
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Cálculo de la media de tres notas");
        System.out.println("=================================");

        // Leer el nombre del estudiante
        String nombre = leerNombre(teclado);
        String nombreMayusculas = nombre.toUpperCase();

    // Constantes de rango para las notas (locales dentro de main)
    final double NOTA_MINIMA = 1.0;
    final double NOTA_MAXIMA = 10.0;

    // Leer las tres notas
    double nota1 = leerNota(teclado, 1, NOTA_MINIMA, NOTA_MAXIMA);
    double nota2 = leerNota(teclado, 2, NOTA_MINIMA, NOTA_MAXIMA);
    double nota3 = leerNota(teclado, 3, NOTA_MINIMA, NOTA_MAXIMA);

        // Calcular la media
        double media = (nota1 + nota2 + nota3) / 3.0;

        // Mostrar resultados
        System.out.printf("\nResumen de calificaciones para %s:\n", nombreMayusculas);
        System.out.printf("Nota 1: %.2f\n", nota1);
        System.out.printf("Nota 2: %.2f\n", nota2);
        System.out.printf("Nota 3: %.2f\n", nota3);
        System.out.printf("Media: %.2f\n", media);

        teclado.close();

    }

}
