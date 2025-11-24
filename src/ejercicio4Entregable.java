import java.util.Locale;
import java.util.Scanner;

public class ejercicio4Entregable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Introducir 3 números por teclado, mostrar el mayor, medio ,menor  y ordenarlo en forma descendente");
        System.out.println();

        System.out.println("Introduce el primer numero");
        double a = sc.nextDouble();

        System.out.println("Introduce el segundo numero");
        double b = sc.nextDouble();

        System.out.println("Introduce el tercer numero");
        double c = sc.nextDouble();

        sc.close();

        //Usamos Math.max anidado para encontrar el maximo de los tres
        double mayor = Math.max(a, Math.max(b,c));
        //Usamos Math.min anidado para encontrar el minimo de los tres
        double menor = Math.min(a, Math.min(b,c));
        //El medio es la suma de todos menos el mayor y el menor
        double medio = (a+b+c)-mayor-menor;

        System.out.print("El numero mayor es "+mayor+" ,el numero menor es "+menor+" ,el numero medio es "+medio);

        System.out.println("\nOrden Descendiente: "+mayor+","+medio+","+menor);

    }
}
