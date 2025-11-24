import java.util.Scanner;

public class ejercicio6Entregable {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String calificacion;

        System.out.println("Ingrese un valor por teclado y aplique sentencias segun convega.");

        System.out.print("Ingrese su nota (0 a 10): ");

        if (sc.hasNextInt()){
            int nota = sc.nextInt();
            sc.close();

            //Validar la nota del 1 al 10
            calificacion = switch (nota) {
                case 0, 1, 2, 3, 4 -> "INSUFICIENTE";
                case 5 -> "SUFICIENTE";
                case 6 -> "BIEN";
                case 7, 8 -> "NOTABLE";
                case 9 -> "SOBRESALIENTE";
                case 10 -> "MATRICULA DE HONOR";
                default -> "ERROR: Nota fuera del rango valido(0 a 10).";
            };

            if (nota < 0 || nota > 10) {
                System.out.println(calificacion);
            }
            System.out.println("La calificacion es: " + calificacion);

        } else {
            System.out.println("ERROR: La entrada no es un numero entero valido. ");
            sc.close();
        }

    }
}
