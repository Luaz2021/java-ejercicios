
import java.util.InputMismatchException;
import java.util.Scanner;

public class ActividadEntregableSimple {
    //Crea una aplicación que permite calcular el área y el perímetro de un círculo, cuadrado,
    //rectángulo y triángulo. El usuario puede elegir qué figura quiere e introducir los valores
    //necesarios para que se muestren los resultados. La aplicación termina cuando el usuario lo
    //indique
    
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        System.out.println("***Calculadora de Area y Perimetro***");


        while (true) {

            System.out.println("\nSeleccione una accion:");
            System.out.println("1. Calcular el area y circuferencia de un Circulo");
            System.out.println("2. Calcular el area y perimetro de un Cuadrado");
            System.out.println("3. Calcular el area y perimetro de un Triangulo");
            System.out.println("4. Calcular el area y perimetro de un Rectangulo");
            System.out.println("5. Salir");
            System.out.print("Opcion: ");

            try {
                opcion = sc.nextInt();
                sc.nextLine(); // Consumir el salto de línea después de leer el entero
            } catch (InputMismatchException e) {
                System.out.println(ANSI_RED + "ERROR: Entrada no válida. Por favor, ingrese un número entero." + ANSI_RESET);
                sc.nextLine(); // Limpiar el buffer para evitar bucles de error
                continue; 
            }

            switch (opcion) {
                case 1 -> {
                    // Area y circunferencia de un circulo
                    
                    //Valores
                    double radio = 0;
                    double areaCirculo ;
                    double circunferenciaCirculo ;
                    boolean esValidoCirculo = false;
                    
                    
                    
                    //Validamos el numero ingresado por consola
                    do {
                        System.out.print("Ingrese el radio del circulo: ");
                        try{
                            // Leemos como texto, reemplazamos la coma y convertimos a double
                            String entrada = sc.nextLine(); // Usar nextLine para leer la línea completa
                            if (entrada.trim().isEmpty()) { // Comprobar si la entrada está vacía
                                System.out.println(ANSI_RED + "ERROR: La entrada no puede estar vacía." + ANSI_RESET);
                                continue; // Volver a solicitar la entrada
                            }
                            radio = Double.parseDouble(entrada.replace(',', '.')); // Convertir a double
                            if (radio > 0) {
                                esValidoCirculo = true;
                            } else {
                                System.out.println(ANSI_RED + "ERROR: El radio no puede ser negativo." + ANSI_RESET);
                            }
                        }catch(NumberFormatException e){
                            System.out.println(ANSI_RED + "ERROR: Debe ingresar un número válido." + ANSI_RESET);
                        }
                    } while (!esValidoCirculo);
                    // Formula matematica
                    // AREA = PI*R^2
                    //Math.PI constante estatica del valor de PI
                    // Math.pow es usado para referenciar a una exponencial
                    areaCirculo = Math.PI * Math.pow(radio, 2);
                    // PERIMETRO = 2*PI*R
                    circunferenciaCirculo = 2 * Math.PI * radio;
                    
                    
                    System.out.println("-----------------------------------------------------------------------------");
                    System.out.printf("El área del círculo es:           %-20.2f%n", areaCirculo);
                    System.out.printf("La circunferencia del círculo es: %-20.2f%n", circunferenciaCirculo);
                    System.out.println("-----------------------------------------------------------------------------");
                }
                case 2 -> {
                    // Area y perimetro de un cuadrado
                    //Valores
                    double lado = 0;
                    double areaCuadrado ;
                    double perimetroCuadrado ;
                    boolean esValidoCuadrado = false;
                    
                    
                    
                    //Validamos el numero ingresado por consola
                    do {
                        System.out.print("Ingrese el lado del cuadrado: ");
                        try{
                            // Leemos como texto, reemplazamos la coma y convertimos a double
                            String entrada = sc.nextLine(); // Usar nextLine para leer la línea completa
                            if (entrada.trim().isEmpty()) { //Validamos si la entrada esta vacia
                                System.out.println(ANSI_RED + "ERROR: La entrada no puede estar vacía." + ANSI_RESET);
                                continue; //Volver a solicitar la entrada
                            }
                            lado = Double.parseDouble(entrada.replace(',', '.')); // Convertir a double
                            if (lado > 0) {
                                esValidoCuadrado = true;
                            } else {
                                System.out.println(ANSI_RED + "ERROR: El lado no puede ser negativo." + ANSI_RESET);
                            }
                        }catch(NumberFormatException e){
                            System.out.println(ANSI_RED + "ERROR: Debe ingresar un número válido." + ANSI_RESET);
                        }
                    } while (!esValidoCuadrado);
                    
                    //Area cuadrado
                    areaCuadrado = Math.pow(lado, 2);
                    //Perimetro cuadrado = lado * 4
                    perimetroCuadrado = lado * 4;
                    
                    System.out.println("-----------------------------------------------------------------------------");
                    System.out.printf("El área de un cuadrado es:           %-20.2f%n", areaCuadrado);
                    System.out.printf("El perímetro del cuadrado es:        %-20.2f%n", perimetroCuadrado);
                    System.out.println("-----------------------------------------------------------------------------");
                }

                case 3 -> {
                    // Area y perimetro de un triangulo
                    
                    //Valores
                    double baseTriangulo = 0;
                    boolean esValidoBaseTriangulo = false;
                    double alturaTriangulo = 0;
                    boolean esValidoAlturaTriangulo = false;
                    double areaTriangulo ;
                    double ladoIgual ;
                    double perimetroTriangulo ;
                    
                    
                    
                    //Validamos la base
                    do {
                        System.out.print("Ingrese la base del triangulo: ");
                        try{
                            // Leemos como texto, reemplazamos la coma y convertimos a double
                            String entrada = sc.nextLine(); // Usar nextLine para leer la línea completa
                            if (entrada.trim().isEmpty()) { //Validamos si la entrada esta vacia
                                System.out.println(ANSI_RED + "ERROR: La entrada no puede estar vacía." + ANSI_RESET);
                                continue; // Volver a solicitar la entrada
                            }
                            baseTriangulo = Double.parseDouble(entrada.replace(',', '.')); // Convertir a double
                            if (baseTriangulo > 0) {
                                esValidoBaseTriangulo = true;
                            } else {
                                System.out.println(ANSI_RED + "ERROR: La base no puede ser negativa." + ANSI_RESET);
                            }
                        }catch(NumberFormatException e){
                            System.out.println(ANSI_RED + "ERROR: Debe ingresar un número válido." + ANSI_RESET);
                        }
                        
                    } while (!esValidoBaseTriangulo);
                    
                    //Validamos la altura
                    do {
                        System.out.print("Ingrese la altura del triangulo: ");
                        try {
                            // Leemos como texto, reemplazamos la coma y convertimos a double
                            String entrada = sc.nextLine(); // Usar nextLine para leer la línea completa
                            if (entrada.trim().isEmpty()) { //Validamos si la entrada esta vacia
                                System.out.println(ANSI_RED + "ERROR: La entrada no puede estar vacía." + ANSI_RESET);
                                continue; // Volver a solicitar la entrada
                            }
                            alturaTriangulo = Double.parseDouble(entrada.replace(',', '.')); // Convertir a double
                            if (alturaTriangulo > 0 ) {
                                esValidoAlturaTriangulo = true;
                            } else {
                                System.out.println(ANSI_RED + "ERROR: La altura no puede ser negativa." + ANSI_RESET);
                            }
                        } catch (NumberFormatException e) {
                            System.out.println(ANSI_RED + "ERROR: Debe ingresar un número válido." + ANSI_RESET);
                        }
                    } while (!esValidoAlturaTriangulo);
                    
                    //Formula matematica
                    // AREA = (BASE * ALTURA) / 2
                    areaTriangulo = (baseTriangulo * alturaTriangulo) / 2;
                    // LADO_IGUAL = RAIZ(MATH.SQRT){((BASE/2)^2) + ALTURA^2 } PITAGORAS
                    ladoIgual = Math.sqrt(Math.pow(baseTriangulo / 2.0, 2) + Math.pow(alturaTriangulo, 2));
                    // PERIMETRO = BASE + 2 * LADO_IGUAL
                    perimetroTriangulo = baseTriangulo + 2 * ladoIgual;
                    
                    System.out.println("\n---------------------------------------------------------------------------");
                    System.out.printf("El área del triángulo es:                                      %-30.2f%n", areaTriangulo);
                    System.out.printf("(Asumiendo triángulo isósceles) El perímetro del triángulo es: %-30.2f%n", perimetroTriangulo);
                    System.out.println("-----------------------------------------------------------------------------");
                }
                case 4 -> {
                    // Area y perimetro de un rectangulo

                    //Valores
                    double baseRectangulo = 0;
                    boolean esValidoBaseRectangulo = false;
                    double alturaRectangulo = 0;
                    boolean esValidoAlturaRectangulo = false;
                    double areaRectangulo ;
                    double perimetroRectangulo ;
                    //Validamos la base
                    do {
                        System.out.print("Ingrese la base del rectangulo: ");
                        try{
                            // Leemos como texto, reemplazamos la coma y convertimos a double
                            String entrada = sc.nextLine(); // Usar nextLine para leer la línea completa
                            if (entrada.trim().isEmpty()) { //Validamos si la entrada esta vacia
                                System.out.println(ANSI_RED + "ERROR: La entrada no puede estar vacía." + ANSI_RESET);
                                continue; //Volver a solicitar la entrada
                            }
                            baseRectangulo = Double.parseDouble(entrada.replace(',', '.')); // Convertir a double
                            if (baseRectangulo > 0) {
                                esValidoBaseRectangulo = true;
                            } else {
                                System.out.println(ANSI_RED + "ERROR: La base no puede ser negativa." + ANSI_RESET);
                            }
                        }catch(NumberFormatException e){
                            System.out.println(ANSI_RED + "ERROR: Debe ingresar un número válido." + ANSI_RESET);
                        }
                        
                    } while (!esValidoBaseRectangulo);
                   
                    //Validamos la altura
                    do {
                        System.out.print("Ingrese la altura del rectangulo: ");
                        try {
                            // Leemos como texto, reemplazamos la coma y convertimos a double
                            String entrada = sc.nextLine(); // Usar nextLine para leer la línea completa
                            if (entrada.trim().isEmpty()) { //Validamos si la entrada esta vacia
                                System.out.println(ANSI_RED + "ERROR: La entrada no puede estar vacía." + ANSI_RESET);
                                continue; // Volver a solicitar la entrada
                            }
                            alturaRectangulo = Double.parseDouble(entrada.replace(',', '.')); // Convertir a double
                            if (alturaRectangulo > 0 ) {
                                esValidoAlturaRectangulo = true;
                            } else {
                                System.out.println(ANSI_RED + "ERROR: La altura no puede ser negativa." + ANSI_RESET);
                            }
                        } catch (NumberFormatException e) {
                            System.out.println(ANSI_RED + "ERROR: Debe ingresar un número válido." + ANSI_RESET);
                        }
                    } while (!esValidoAlturaRectangulo);
                    //Formula matematica
                    //Area Rectangulo
                    areaRectangulo = baseRectangulo * alturaRectangulo;
                    //Perimetro Rectangulo
                    // Perímetro = 2*(base+altura)
                    perimetroRectangulo = 2 * (baseRectangulo + alturaRectangulo);
                    System.out.println("\n-----------------------------------------------------------------------------");
                    System.out.printf("El área del rectangulo es:      %-20.2f%n", areaRectangulo);
                    System.out.printf("El perímetro del rectangulo es: %-20.2f%n", perimetroRectangulo);
                    System.out.println("-----------------------------------------------------------------------------");
                }

                case 5 -> {
                    System.out.println("Saliendo del programa. ;)");
                    sc.close();// Aqui se cierra el escaner
                    return;
                }
                default -> System.out.println(ANSI_RED + "ERROR: Opción no válida. Por favor, elija entre 1 y 5." + ANSI_RESET);
                
            }

            // Pausar la consola después de cada cálculo 
            if (opcion >= 1 && opcion <= 4) {
                System.out.println("\nPresione Enter para continuar...");
                sc.nextLine(); // Espera a que el usuario presione Enter
            }
        }
    }
}
        
       
        
    
