import java.util.InputMismatchException;
import java.util.Scanner;


public class ArrayEjercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int resultado;
        int dni = validarDNI(sc, "Introduce el DNI (máximo 8 dígitos):");

        String [] codigosDNI = {"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E",""};

        resultado = dni % 23;

        // Usamos String.format para asegurar que el DNI se imprima con 8 dígitos,
        // Al ingresar un 0 a la izquierda no se mostraba en el resultao final
        String dniFormateado = String.format("%08d", dni);


        System.out.println("EL DNI ES "+ dniFormateado + codigosDNI[resultado]);

        sc.close();
    }
    



    // Metodo para validar el numero del DNI
    private static int validarDNI(Scanner sc, String mensaje) {
        int numeroDNI = 0;
        boolean esValido = false;

        do { 
            System.out.println(mensaje);
            try {
                numeroDNI = sc.nextInt();
                if (numeroDNI >= 100000000 || numeroDNI < 0) {
                    System.out.println("ERROR: El número no puede tener más de 8 dígitos ni ser negativo.");
                } else {
                    esValido = true; 
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Debes introducir un número entero válido.");
                sc.next(); 
            }
        } while (!esValido);
        return numeroDNI;
    }
}
