import java.util.Scanner;
import java.util.Locale;
import java.util.InputMismatchException;


public class ejecicioMenu {

public static void main(String[] args) {

    Scanner sc = new Scanner(System.in).useLocale(Locale.US);
    
    int opcion = 0 ;

    do {
            
        System.out.println("Elige una opcion");
        System.out.println("1. Par o Impar");
        System.out.println("2. Sueldo tranajador");
        System.out.println("3. Calculadora IVA");
        System.out.println("4. Salir");
        System.out.println("Seleccione una opcion del 1 al 4");

        try {
            opcion = sc.nextInt();
            
            switch (opcion) {
                case 1:
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
    
                    break;

                case 2:
                    
                    break;

                case 3:
                    
                    break;
                case 4:
                System.out.println("Saliendo del programa");
                    break;    
                default:
                    System.out.println("Opcion no valida");
            }

        }catch (InputMismatchException e){
            System.out.println("Entrada no valida");
            sc.next();
            opcion = 0;

        }

    }while (opcion != 4) ;
    sc.close();
}



}