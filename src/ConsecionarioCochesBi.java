
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsecionarioCochesBi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Variables Globales
        final int FILAS = 100;
        final int COLUMNAS = 6;
        String [][] vehiculosNuevos = new String[FILAS][COLUMNAS];
        // 0 -> Bastidor 
        // 1 -> Marca 
        // 2 -> Modelo
        // 3 -> AÑO
        // 4 -> MATRICULA 
        // 5 -> DNI
        int opcion;

        do { 
            
            listarVehiculosDisponibles(vehiculosNuevos);

            System.out.println("\n***Concesionario Coches***");
            System.out.println("\nQue desea realizar el dia de hoy? ");
            System.out.println("1. Insertar Vehiculos ");
            System.out.println("2. Eliminar Vehiculos ");
            System.out.println("3. Modificar Vehiculos ");
            System.out.println("4. Vender Vehiculos");
            System.out.println("5. Vehiculos Vendidos");
            System.out.println("6. Salir");

             opcion = validarNumero(sc, "Introduce una opcion: ");

            switch (opcion) {
                case 1 ->{insertarVehiculos(sc, "Introduce el bastidor: ", vehiculosNuevos);}
                case 2 ->{eliminarVehiculo(sc, "Introduce el bastidor: ",vehiculosNuevos);}
                case 3 ->{modificarVehiculo(sc, "Introduce el bastidor del vehículo a modificar: ", vehiculosNuevos);}
                case 4 ->{venderVehiculo(sc, "Introduce el bastidor del vehículo a vender: ", vehiculosNuevos);}
                case 5 ->{listarVehiculosVendidos(vehiculosNuevos);}
                case 6 ->{System.out.println("Saliendo del programa...");}
                default -> {System.out.println("Opcion no valida");}
            }
        } while (opcion != 6); 
    }


    //Validar numero para evitar errores
    static int validarNumero(Scanner sc, String mensaje){
        int numero = 0;
        boolean esValidoNumero = false;
        do { 
            try {
                    System.out.print(mensaje);
                    numero = sc.nextInt();
                    sc.nextLine();
                    if (numero > 0) esValidoNumero = true;
                    else System.out.println("Error: El numero no puede ser negativo");
            } catch (InputMismatchException e) {
                System.out.println("Error: Introduce un numero valido");
                sc.next();
            }
        } while (!esValidoNumero);
        return  numero;
    } 

    //Opcion de introducir vehiculos 

    static void insertarVehiculos(Scanner sc, String mensaje, String [][] vehiculosNuevos){
        boolean siExiste = false;
        System.out.println("\n***Insertar Vehiculos***");
        System.out.print(mensaje);
        String bastidor = sc.nextLine(); // Declaramos una variable local 'bastidor'
        //Recorre las filas del array
        for(int i=0;i<vehiculosNuevos.length;i++){
            if (vehiculosNuevos[i][0] != null && vehiculosNuevos[i][0].equalsIgnoreCase(bastidor)) {
                siExiste = true;
                System.out.println("El vehiculo ya existe");
                break; // Salimos del bucle si ya lo encontramos
            }
        }

        if(!siExiste){
            for (int i=0;i<vehiculosNuevos.length;i++) {
                if(vehiculosNuevos[i][0] == null){
                    vehiculosNuevos[i][0] = bastidor; // Usamos la variable local 'bastidor'
                    System.out.print("Introduce la marca: ");
                    vehiculosNuevos[i][1] = sc.nextLine();
                    System.out.print("Introduce el modelo: ");
                    vehiculosNuevos[i][2] = sc.nextLine();
                    System.out.print("Introduce el año: ");
                    // Usamos el método validarNumero para asegurarnos de que el año es un número válido
                    vehiculosNuevos[i][3] = String.valueOf(validarNumero(sc, ""));
                    System.out.print("Introduce la matricula: ");
                    vehiculosNuevos[i][4] = sc.nextLine();
                    System.out.println("Vehiculo insertado correctamente");
                    break; // Usamos 'break' para salir del bucle una vez insertado
                }
                
            }
        }
    }
    // Opcion de eliminar vehiculo
    static void eliminarVehiculo(Scanner sc,String mensaje, String [][] vehiculosNuevos){
        System.out.println("\n***Eliminar Vehiculos***");
        System.out.print(mensaje);
        boolean encontrado = false;
        String bastidor = sc.nextLine();
        for (int i=0;i<vehiculosNuevos.length;i++) {
            if(vehiculosNuevos[i][0]!=null && vehiculosNuevos[i][0].equalsIgnoreCase(bastidor)){
                // Limpiamos todos los datos del vehículo
                for(int j = 0; j < vehiculosNuevos[i].length; j++){
                    vehiculosNuevos[i][j] = null;
                }
                System.out.println("Vehiculo eliminado correctamente");
                encontrado = true;
                break;
            }
        }
        if(!encontrado){
            System.out.println("Vehiculo no encontrado");
        }
    }
    //Modificar vehiculo por bastidor
    static void modificarVehiculo(Scanner sc, String mensaje, String[][] vehiculosNuevos) {
        System.out.println("\n***Modificar Vehiculo***");
        System.out.print(mensaje);
        String bastidor = sc.nextLine();
        int indiceVehiculo = -1;

        for (int i = 0; i < vehiculosNuevos.length; i++) {
            if (vehiculosNuevos[i][0] != null && vehiculosNuevos[i][0].equalsIgnoreCase(bastidor)) {
                indiceVehiculo = i;
                break;
            }
        }

        if (indiceVehiculo != -1) {
            System.out.println("Vehículo encontrado. ¿Qué campo deseas modificar?");
            System.out.println("1. Bastidor");
            System.out.println("2. Marca");
            System.out.println("3. Modelo");
            System.out.println("4. Año");
            System.out.println("5. Matrícula");
            int opcion = validarNumero(sc, "Introduce una opción: ");

            switch (opcion) {
                case 1 -> {
                    System.out.print("Introduce el nuevo bastidor: ");
                    String nuevoBastidor = sc.nextLine();
                    boolean yaExiste = false;
                    for (int i = 0; i < vehiculosNuevos.length; i++) {
                        if (vehiculosNuevos[i][0] != null && vehiculosNuevos[i][0].equalsIgnoreCase(nuevoBastidor)) {
                            yaExiste = true;
                            break;
                        }
                    }
                    if (yaExiste) {
                        System.out.println("Error: Ya existe un vehículo con ese número de bastidor.");
                    } else {
                        vehiculosNuevos[indiceVehiculo][0] = nuevoBastidor;
                        System.out.println("Bastidor modificado correctamente.");
                    }
                }
                case 2 -> {
                    System.out.print("Introduce la nueva marca: ");
                    vehiculosNuevos[indiceVehiculo][1] = sc.nextLine();
                    System.out.println("Marca modificada correctamente.");
                }
                case 3 -> {
                    System.out.print("Introduce el nuevo modelo: ");
                    vehiculosNuevos[indiceVehiculo][2] = sc.nextLine();
                    System.out.println("Modelo modificado correctamente.");
                }
                case 4 -> {
                    System.out.print("Introduce el nuevo año: ");
                    vehiculosNuevos[indiceVehiculo][3] = String.valueOf(validarNumero(sc, ""));
                    System.out.println("Año modificado correctamente.");
                }
                case 5 -> {
                    System.out.print("Introduce la nueva matrícula: ");
                    vehiculosNuevos[indiceVehiculo][4] = sc.nextLine();
                    System.out.println("Matrícula modificada correctamente.");
                }
                default -> System.out.println("Opción no válida.");
            }
        } else {
            System.out.println("Vehículo no encontrado.");
        }
    }

    // Vender un vehiculo (asignar DNI)
    static void venderVehiculo(Scanner sc, String mensaje, String[][] vehiculosNuevos) {
        System.out.println("\n***Vender Vehiculo***");
        System.out.print(mensaje);
        String bastidor = sc.nextLine();
        boolean encontrado = false;
        for (int i = 0; i < vehiculosNuevos.length; i++) {
            if (vehiculosNuevos[i][0] != null && vehiculosNuevos[i][0].equalsIgnoreCase(bastidor)) {
                encontrado = true;
                if (vehiculosNuevos[i][5] == null) {
                    System.out.print("Introduce el DNI del comprador: ");
                    vehiculosNuevos[i][5] = sc.nextLine();
                    System.out.println("Vehículo vendido correctamente.");
                } else {
                    System.out.println("Este vehículo ya ha sido vendido.");
                }
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Vehículo no encontrado.");
        }
    }

    // Listar vehiculos vendidos
    static void listarVehiculosVendidos(String[][] vehiculosNuevos) {
        System.out.println("\n***Listado de Vehículos Vendidos***");
        boolean hayVendidos = false;
        for (int i = 0; i < vehiculosNuevos.length; i++) {
            // Si la columna DNI (índice 5) no es null, el vehículo está vendido
            if (vehiculosNuevos[i][0] != null && vehiculosNuevos[i][5] != null) {
                System.out.printf("Bastidor: %s, Marca: %s, Modelo: %s, Año: %s, Matrícula: %s, DNI Comprador: %s\n",
                        vehiculosNuevos[i][0], vehiculosNuevos[i][1], vehiculosNuevos[i][2], vehiculosNuevos[i][3], vehiculosNuevos[i][4], vehiculosNuevos[i][5]);
                hayVendidos = true;
            }
        }
        if (!hayVendidos) {
            System.out.println("No hay vehículos vendidos registrados.");
        }
    }

    // Listar vehiculos disponibles (no vendidos)
    static void listarVehiculosDisponibles(String[][] vehiculosNuevos) {
        System.out.println("\n--- Coches Disponibles en el Concesionario ---");
        boolean hayDisponibles = false;
        for (int i = 0; i < vehiculosNuevos.length; i++) {
            // Un vehículo está disponible si existe (bastidor no es null) y no está vendido (DNI es null)
            if (vehiculosNuevos[i][0] != null && vehiculosNuevos[i][5] == null) {
                System.out.printf("-> BASTIDOR: %S, MARCA: %S, MODELO: %S, AÑO: %S, MATRÍCULA: %S\n",
                        vehiculosNuevos[i][0], vehiculosNuevos[i][1], vehiculosNuevos[i][2], vehiculosNuevos[i][3], vehiculosNuevos[i][4]);
                hayDisponibles = true;
            }
        }
        if (!hayDisponibles) {
            System.out.println("No hay vehículos disponibles registrados en este momento.");
        }
    }
}
