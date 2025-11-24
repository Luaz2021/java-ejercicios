import java.util.Scanner;

public class ParoImpar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;
        boolean entradaValida = false;


        do {
            System.out.println("Por favor, ingrese un número entero positivo: ");

            if (sc.hasNextInt()) {
                numero = sc.nextInt();

                if (numero >= 0) {
                    String resultado = (numero % 2 == 0) ? "par" : "impar";
                    System.out.printf("El número %d es %s.\n", numero, resultado);
                    entradaValida = true;
                } else {
                    System.out.println("Error: El número debe ser un entero positivo. Inténtelo de nuevo.");
                }
            } else {
                System.out.println("Error: Entrada no válida. Por favor, ingrese un número entero.");
                sc.next(); 
            }
        } while (!entradaValida);

        sc.close();
    }
}
 