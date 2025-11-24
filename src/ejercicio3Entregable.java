import java.util.Scanner;
import java.util.Locale;


public class ejercicio3Entregable {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Hola,ingrese dos números y muestre cual es el mayor y cual es el menor");

        System.out.println("Introduce el primer numero");
        double num1 = sc.nextDouble();

        System.out.println("Introduce el segundo numero");
        double num2 = sc.nextDouble();

        sc.close();

        if (num1>num2){
            System.out.print("El número mayor es "+num1+" y el número menor es "+num2 );
        } else if (num1<num2) {
            System.out.print("El número mayor es "+num2+" y el número menor es" +num1 );

        }else{
            System.out.println("Ambos números son iguales: "+num1);
        }

    }

}
