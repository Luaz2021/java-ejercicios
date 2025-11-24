import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class ActividadEntregable {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);  //Abrimos el escaner
        int option;

        System.out.println("Calculadora de áreas y perímetros");

        do {
            //Usamos el metodo de Mostrar Menu
            mostrarMenu();
            //Usamos un try-catch para manejar entradas no válidas y posibles errores
            try {
                option = sc.nextInt();
                switch (option) {
                    case 1: limpiarConsola(); calcularCirculo(sc); break;
                    case 2: limpiarConsola(); calcularCuadrado(sc); break;
                    case 3: limpiarConsola(); calcularTriangulo(sc); break;
                    case 4: limpiarConsola(); calcularRectangulo(sc); break;
                    case 5: System.out.println("Saliendo del programa. ¡Hasta luego!"); break;
                    default: 
                        limpiarConsola();
                        System.out.println("ERROR: Opción no válida. Por favor, seleccione una opción entre 1 y 5.");
                }
            } catch (InputMismatchException e) { 
                limpiarConsola();
                System.out.println("ERROR: Entrada no válida. Por favor, ingrese un número.");
                sc.next(); //Limpia el buffer del scanner
                option = 0; // Volvemos al inicio
            }
        } while (option != 5); 
        sc.close(); //Cerramos el escaner
    }
 
    //Metodo para mostrar el menu
    private static void mostrarMenu() {
        System.out.println("\n--MENU--");
        System.out.println("1. Calcular Círculo");
        System.out.println("2. Calcular Cuadrado");
        System.out.println("3. Calcular Triángulo");
        System.out.println("4. Calcular Rectángulo");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción (1-5): ");
    }

    //Metodo para limpiar la consola (recomendacion del optimizador de UX)
    private static void limpiarConsola() {
        try {
            // Imprime códigos de escape ANSI para limpiar la consola
            System.out.print("\033[H\033[2J");
            System.out.flush();
        } catch (Exception e) {
        }
    }

    //Mejora visual basica (recomendacion del optimizador de UX)
    private static void pausarConsola(Scanner sc) {
        System.out.println("\nPresione Enter para continuar...");
        sc.nextLine(); // Espera a que el usuario presione Enter
    }


    //Metodo para validar los numeros ingresando evitando caracteres y numeros negativos
    private static double leerDoublePositivo(Scanner sc, String mensaje) {
        double valor = -1;
        boolean esValido = false;
        do {
            System.out.print(mensaje);
            try {
                valor = sc.nextDouble();
                if (valor < 0) {
                    System.out.println("ERROR: El valor no puede ser negativo. Inténtelo de nuevo.");
                } else {
                    esValido = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Entrada no válida. Por favor, ingrese un número.");
                sc.next(); // Limpia el buffer del scanner
            }
        } while (!esValido);
        sc.nextLine(); // Limpia el buffer del scanner después de una lectura exitosa
        return valor;
    }

    //Metodos para los calculos 


    //Metodo para calcular area y perimetro de un circulo 
    //AREA = PI*R^2
    //PERIMETRO = 2*PI*R
    private static void calcularCirculo(Scanner sc) {
        double radio = leerDoublePositivo(sc, "Ingrese el radio del círculo: ");
        double areaCirculo = Math.PI * Math.pow(radio, 2);
        double perimetroCirculo = 2 * Math.PI * radio; // Perímetro = 2πr
        System.out.printf("El área del círculo es: %.2f\n", areaCirculo);
        System.out.printf("El perímetro (circunferencia) del círculo es: %.2f\n", perimetroCirculo);
        pausarConsola(sc);
    }
    //Metodo para calcular area y perimetro de un cuadrado
    //AREA = LADO^2
    //PERIMETRO = 4*LADO
    private static void calcularCuadrado(Scanner sc) {
        double lado = leerDoublePositivo(sc, "Ingrese el lado del cuadrado: ");
        double areaCuadrado = Math.pow(lado, 2);
        double perimetroCuadrado = 4 * lado; // Perímetro = 4 * lado
        System.out.printf("El área del cuadrado es: %.2f\n", areaCuadrado);
        System.out.printf("El perímetro del cuadrado es: %.2f\n", perimetroCuadrado);
        pausarConsola(sc);
    }
    //Metodo para calcular area y perimetro de un triangulo
    // AREA = (BASE * ALTURA) / 2
    // PERIMETRO = BASE + 2 * LADO_IGUAL
    //LADO_IGUAL = RAIZ(MATH.SQRT){((BASE/2)^2) + ALTURA^2 }
    private static void calcularTriangulo(Scanner sc) {
        double base = leerDoublePositivo(sc, "Ingrese la base del triángulo: ");
        double altura = leerDoublePositivo(sc, "Ingrese la altura del triángulo: ");
        double areaTriangulo = (base * altura) / 2;
        double ladoIgual = Math.sqrt(Math.pow(base / 2.0, 2) + Math.pow(altura, 2));
        double perimetroTriangulo = base + 2 * ladoIgual;
        System.out.printf("El área del triángulo es: %.2f\n", areaTriangulo);
        System.out.printf("(Asumiendo triángulo isósceles) El perímetro del triángulo es: %.2f\n", perimetroTriangulo);
        pausarConsola(sc);
    }
    //Metodo para calcular area y perimetro de un rectangulo
    //AREA = BASE * ALTURA
    //PERIMETRO = 2*(BASE + ALTURA) 
    private static void calcularRectangulo(Scanner sc) {
        double baseRect = leerDoublePositivo(sc, "Ingrese la base del rectángulo: ");
        double alturaRect = leerDoublePositivo(sc, "Ingrese la altura del rectángulo: ");
        double areaRectangulo = baseRect * alturaRect;
        double perimetroRectangulo = 2 * (baseRect + alturaRect); // Perímetro = 2*(base+altura)
        System.out.printf("El área del rectángulo es: %.2f\n", areaRectangulo);
        System.out.printf("El perímetro del rectángulo es: %.2f\n", perimetroRectangulo);
        pausarConsola(sc);
    }

}
