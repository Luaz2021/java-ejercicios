import java.util.Scanner;


public class ParImpar_basico {
    public static void main(String[] args) {

        int num; //Declaramos variable inicial 
        Scanner sc = new Scanner(System.in);// Creamos el objeto Scanner

        System.out.println("Introduce un número entero positivo: ");
        
        num = sc.nextInt(); //Leemos el número introducido por el usuario

        if (num > 0) {
            if (num % 2 == 0) {//Comprobamos si el número es par o impar con el operador módulo
                System.out.println("El número " + num + " es par.");
            } else {
                System.out.println("El número " + num + " es impar.");
            }
        } else {//Si el número es negativo o cero mostramos un mensaje de error
            System.out.println("Por favor, introduce un número entero positivo.");
        }
        sc.close();//Cerramos el objeto Scanner
        }
}
