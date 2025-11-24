import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Locale;

public class ActividaEvaluable {

    public static void main(String[] args) {
        // Usamos Locale.US para asegurar que el punto decimal sea '.'
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        boolean continuar = true;

        
        while (continuar) {
            System.out.println("--- Menú ---");
            System.out.println("1. Círculo");
            System.out.println("2. Cuadrado");
            System.out.println("3. Rectángulo");
            System.out.println("4. Triángulo");
            System.out.println("5. Salir");
            System.out.print("Elige una figura (1-5): ");

            try {
                int opcion = scanner.nextInt();
                
                switch (opcion) {
                    case 1:
                        calcularCirculo(scanner);
                        break;
                    case 2:
                        calcularCuadrado(scanner);
                        break;
                    case 3:
                        calcularRectangulo(scanner);
                        break;
                    case 4:
                        calcularTriangulo(scanner);
                        break;
                    case 5:
                        continuar = false; 
                        System.out.println("👋 Programa finalizado.");
                        break;
                    default:
                        System.out.println("❌ Opción inválida.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("❌ Error: Ingresa un número entero para la opción.");
                scanner.next(); // Limpia el buffer
            }
            System.out.println("-------------------------");
        }
        scanner.close();
    }

    // Métodos de Cálculo (convertidos a estáticos)

    private static void calcularCirculo(Scanner s) {
        try {
            System.out.print("Introduce el radio: ");
            double radio = s.nextDouble();
            double area = Math.PI * radio * radio;
            double perimetro = 2 * Math.PI * radio;
            System.out.printf("Área: %.2f | Perímetro: %.2f\n", area, perimetro);
        } catch (InputMismatchException e) {
            manejarError(s);
        }
    }

    private static void calcularCuadrado(Scanner s) {
        try {
            System.out.print("Introduce la longitud del lado: ");
            double lado = s.nextDouble();
            double area = lado * lado;
            double perimetro = 4 * lado;
            System.out.printf("Área: %.2f | Perímetro: %.2f\n", area, perimetro);
        } catch (InputMismatchException e) {
            manejarError(s);
        }
    }

    private static void calcularRectangulo(Scanner s) {
        try {
            System.out.print("Introduce la base: ");
            double base = s.nextDouble();
            System.out.print("Introduce la altura: ");
            double altura = s.nextDouble();
            double area = base * altura;
            double perimetro = 2 * (base + altura);
            System.out.printf("Área: %.2f | Perímetro: %.2f\n", area, perimetro);
        } catch (InputMismatchException e) {
            manejarError(s);
        }
    }

    private static void calcularTriangulo(Scanner s) {
        try {
            System.out.print("Base (para Área y Lado 1): ");
            double base = s.nextDouble();
            System.out.print("Altura (para Área): ");
            double altura = s.nextDouble();
            
            System.out.print("Lado 2 (para Perímetro): ");
            double lado2 = s.nextDouble();
            System.out.print("Lado 3 (para Perímetro): ");
            double lado3 = s.nextDouble();
            
            double area = (base * altura) / 2;
            double perimetro = base + lado2 + lado3;
            System.out.printf("Área: %.2f | Perímetro: %.2f\n", area, perimetro);
        } catch (InputMismatchException e) {
            manejarError(s);
        }
    }

    private static void manejarError(Scanner s) {
        System.out.println("❌ Entrada numérica inválida. Volviendo al menú.");
        s.next(); 
    }
}