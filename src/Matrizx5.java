import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

 
public class Matrizx5 {
    public static void main(String[] args) {
        //2. Crear una matriz de 5 filas y n columnas (se pide al usuario). Rellenarlo con números aleatorios entre 0 y 10.

        Scanner sc = new Scanner(System.in);
        int filas;
 
        // Pedimos el número de filas al usuario usando el método de validación
        filas = validarNumero(sc, "Introduce el numero de filas: ");
        
        int [][] matriz = new int [5][filas];
        
        Random numeroAleatorio = new Random(10);
        
 
        // Rellenamos la matriz
        for(int i=0; i < matriz.length; i++){
            for(int j=0; j < matriz[i].length; j++){
                matriz[i][j] = numeroAleatorio.nextInt(10);
            }
        }

        // Imprimimos la matriz
        System.out.println("\nMatriz " + filas + " x 5");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("%4d", matriz[i][j]);
            }
            System.out.println();
        }
        sc.close();
    }
 


    // Método para validar que se introduce un número entero positivo
    static int validarNumero(Scanner sc, String mensaje) {
        int numero = 0;
        boolean esValido = false;
 
        do {
            try {
                System.out.print(mensaje);
                numero = sc.nextInt();
                if (numero >= 0) {
                    esValido = true;
                } else {
                    System.out.println("ERROR: El número no puede ser negativo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Debes introducir un número entero válido.");
                sc.nextLine();
            }
        } while (!esValido);
        sc.nextLine(); 
        return numero;
    }
}
