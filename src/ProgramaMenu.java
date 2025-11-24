import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;


public class ProgramaMenu {
public static void main(String[] args) {
    //Iniciamos el escaner 
    Scanner sc = new Scanner(System.in).useLocale(Locale.US);
    //Iniciamos las variable para el menu inicial
    int opcion = 0;
    //Iniciamos DO - WHILE para el bucle por opciones invalidas !=4 
    do {
        // Iniciamos Try - Catch para encapsular errores por caracteres y otros
        try {
            // Mostramos el menu 
            System.out.println("Selecciona una opcion");
            System.out.println("1. Ver numero par o impar");
            System.out.println("2. Calcular suledo trabajador");
            System.out.println("3. Calcular precios con IVA");
            System.out.println("4. Salir");

            System.out.print("Ingrese su opcion: ");
            opcion = sc.nextInt();// Ingresamos por teclado la opcion a elegir
            
            switch (opcion) {
                // Ingresamos el primer caso "Ver numero par o impar"
                case 1 :
                    System.out.println("\n"); // Salto de linea
                    System.out.println("Ver numero par o impar");
                    // Iniciamos las variables
                    int num;
                    // Iniciamos DO - WHILE para crear un bucle 
                    do { 
                        //Iniciamos TRY - CATCH para encapsular errores por caracteres
                        try{
                            System.out.print("Ingrese un numero entero positivo:\t");
                            num = sc.nextInt();

                            if(num >= 0){
                                // Validacion para encontrar numero par e impar con modulo
                                if(num%2==0){
                                    System.out.printf("El numero %d es par\n", num);
                                   
                                }else{
                                    System.out.printf("El numero %d es impar\n", num);
                                    
                                }
                                break; // Salimos del bucle si el número es válido
                            }else{
                                System.out.println("ERROR: El numero no puede ser negativo.");
                            }
                        }catch(InputMismatchException e){
                            System.out.println("ERROR: Entrada inválida. Por favor, ingrese un número entero.");
                            sc.next(); // Limpiamos el buffer del scanner
                        }
                    } while (true); 

                    break;
                 case 2 :
                    //Ingresamos el segundo caso Calculadora Sueldo Trabajador
                    System.out.println("\n"); // Salto de linea
                    System.out.println("Calcular sueldo trabajador");
                    //Declaramos las variables a utilizar
                     double horasTrabajadas = 0;
                     char claseTrabajador;
                     double tarifaHora;
                     double sueldoTotal;
                     boolean entradaValida;

                     // Validar Horas Trabajadas
                     do {
                         entradaValida = false;
                         System.out.println("Ingrese las horas trabajadas:");
                         //Encapsular errores o excepciones
                         try {
                             horasTrabajadas = sc.nextDouble();
                             if (horasTrabajadas >= 0) {
                                 entradaValida = true;
                             } else {
                                 System.out.println("ERROR: Las horas no pueden ser negativas.");
                             }
                         } catch (InputMismatchException e) {
                             System.out.println("ERROR: Debe ingresar un número válido para las horas.");
                             sc.next(); // Limpiar buffer
                         }
                     } while (!entradaValida);

                     // Validar Clase de Trabajador
                     boolean claseValida = false;
                     //Usamos do - while para realizar el bucle para recorrer los casos
                     //para forzar a saltar a default ya sea ingresando cualquier valor 
                     //que no esten dentro de los casos
                     do { 
                         System.out.println("Ingrese la clase del trabajador (A, B, C, D):");
                         //Convertimos las letras ya sea escribirlo en mayuscula o minuscula
                         claseTrabajador = sc.next().toUpperCase().charAt(0);
                         switch (claseTrabajador) {
                             case 'A' :
                                tarifaHora = 25.00;
                                claseValida = true;//Validar la condicion
                                break;
                             case 'B' :
                                tarifaHora = 20.00;
                                claseValida = true;//Validar la condicion
                                break;
                             case 'C' :
                                tarifaHora = 15.00;
                                claseValida = true;//Validar la condicion
                                break;
                             case 'D'  :
                                tarifaHora = 10.00;
                                claseValida = true;//Validar la condicion
                                break;
                             default :
                             tarifaHora = 0; 
                             System.out.println("ERROR: Clase de trabajador no válida. Intente de nuevo");
                         }
                     } while (!claseValida);
                    
                    //Calcular y mostrar resultado
                    sueldoTotal = horasTrabajadas * tarifaHora;
                    //FORMATEAMOS LO QUE VAMOS A IMPRIMIR
                    //%c = Un solo caracter
                    //%.2f
                    //%f = Inserta numeros decimales
                    //.2 = Imprime 2 decimales 
                    System.out.printf("El sueldo total para un trabajador de clase %c con %.2f horas es de: %.2f euros\n", claseTrabajador, horasTrabajadas, sueldoTotal);

                    break;
                 case 3 :
                    //Ingresamos el tercer caso Calcular precios con IVA
                    System.out.println("\n"); // Salto de linea
                    System.out.println("Calcular precios con IVA");
                    //Declaramos las varibles 
                    double baseImponible; // Precio en bruto
                    int porcentajeIva; // Porcentaje del Iva para mostrar los resultados %
                    double tasaIva; // Tasa o valor del Iva a aplicar
                    double importeIva; // Resultado del importe del Iva aplicado al producto
                    double precioConIva; // Resultado del precio con Iva aplicado
                    double descuento; // Valor de los descuentos
                    double totalFinal; // Precio final incluido toda las condiciones

                    //Validar Base Imponible
                    do {
                        System.out.println("Ingrese la base imponible:");
                        try {
                            //Encapsular errores o excepciones 
                            baseImponible = sc.nextDouble();
                            if (baseImponible > 0) {
                                break; // Salir si es válido
                            } else {
                                System.out.println("ERROR: La base imponible debe ser un número positivo.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("ERROR: Debe ingresar un número válido.");
                            sc.next(); // Limpiar buffer
                        }
                    } while (true);

                    //Validar Tipo de IVA
                    boolean ivaValido = false;
                    do {
                        System.out.println("Ingrese el tipo de IVA (general, reducido, superreducido):");
                        String tipoIva = sc.next().toLowerCase();
                        tasaIva = 0.0;
                        porcentajeIva = 0;
                    
                        switch (tipoIva) {
                            case "general":
                                tasaIva = 0.21;
                                porcentajeIva = 21;
                                ivaValido = true;
                                break;
                            case "reducido":
                                tasaIva = 0.10;
                                porcentajeIva = 10;
                                ivaValido = true;
                                break;
                            case "superreducido":
                                tasaIva = 0.04;
                                porcentajeIva = 4;
                                ivaValido = true;
                                break;
                            default:
                                System.out.println("ERROR: Tipo de IVA no valido. Intente de nuevo.");
                        }
                    } while (!ivaValido);

                    // Calculamos el IVA y el precio con IVA
                    importeIva = baseImponible * tasaIva;
                    precioConIva = baseImponible + importeIva;

                    //Validar Código Promocional
                    String codPromocional;
                    boolean codigoValido = false;
                    do {
                        System.out.println("Ingrese el codigo promocional (nopro, mitad, meno5, 5porc):");
                        codPromocional = sc.next().toLowerCase();
                        descuento = -1.0; // Valor de control

                        switch (codPromocional) {
                            case "nopro" : 
                                descuento = 0.0;
                                codigoValido = true;
                                break;
                            case "mitad" :
                                descuento = precioConIva / 2;
                                codigoValido = true;
                                break;
                            case "meno5" :
                                descuento = 5.0;
                                codigoValido = true;
                                break;
                            case "5porc"  :
                                descuento = precioConIva * 0.05;
                                codigoValido = true;
                                break;
                            default :
                                System.out.println("Codigo promocional no valido. Intente de nuevo.");
                        }
                    } while (!codigoValido);
                    
                    totalFinal = precioConIva - descuento;

                    //Mostrar resultado
                    //Formateamos el codigo
                    //%-20s
                    //%s = Imprime un String
                    // - = Alineacion a la izquierda
                    //20 = Reserva 20 caracteres de ancho
                    //%.2f%n
                    //%f = Inserta numeros decimales
                    //.2 = Imprime 2 decimales 
                    //%n = Salto de linea
                    //\n = Salto de linea

                    System.out.println("\n--- DETALLE DE LA FACTURA ---");
                    System.out.println("=====================================");
                    System.out.printf("%-20s: %.2f%n", "Base imponible", baseImponible);
                    System.out.printf("%-20s: %.2f%n", "IVA (" + porcentajeIva + "%)", importeIva);
                    System.out.printf("%-20s: %.2f%n", "Precio con IVA", precioConIva);
                    System.out.printf("%-20s: %.2f%n", "Descuento (" + codPromocional + ")", descuento);
                    System.out.printf("%-20s: %.2f%n", "TOTAL", totalFinal);
                    System.out.println("=====================================");

                    break;
                 case 4 :
                    //El cuarto caso es para salir del programa
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    //El default salta cuando el usuario ingrese valores que no estan en los casos
                    System.out.println("Opcion no valida");
                    System.out.println("\n");//Salto de linea
            }

        } catch (InputMismatchException e) {
            System.out.println("ERROR: Debe introducir un número para la opción del menú.");
            sc.next(); //Limpiar el buffer
            opcion = 0; //Reiniciar la variable a 0 y volver al inicio del bucle
            System.out.println("\n");//Salto de linea
        }

        // Metodo para dar espacio y volver al menu
        if (opcion > 0 && opcion < 4) {
            System.out.println("\nPresione Enter para volver al menú...");
            sc.nextLine(); // Limpia el buffer de cualquier lectura anterior
            sc.nextLine(); // Espera a que el usuario presione Enter
        }
    } while (opcion != 4);
    sc.close();
}
}
