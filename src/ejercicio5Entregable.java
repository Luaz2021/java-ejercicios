import java.util.Scanner;

public class ejercicio5Entregable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese un número por teclado y verificar si es par o impar");
        System.out.println();

        System.out.println("Ingrese un número entero");
        int num = sc.nextInt();
        sc.close();

        if(num%2==0){
            System.out.println("El número"+num+" es par");
        } else {
            System.out.println("El número"+num+" es impar");
        }
    }
}
