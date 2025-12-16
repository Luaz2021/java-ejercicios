
import java.util.InputMismatchException;
import java.util.Scanner;

public class Demo1ConcesionarioVehiculos {
    public static void main(String[] args) {
        //Vehiculos - Insertar,Eliminar y dejar vacio,modificar vehiculo,salir
        //Clientes - DNI - Compras
        //Ventas - Vehiculos vendidos - MostrarDNI 


        //Implementaciones 
        Scanner sc = new Scanner(System.in);

        //Variables globales
        int cantidadCoches;
        int opcionMenuPrincipal;
        
        cantidadCoches = validarNumero(sc, "Para empezar, ¿cuántos vehículos podrá tener el concesionario?: ");
        sc.nextLine(); // Limpiar el buffer después de leer el número
        
        String [] placaVehiculos = new String[cantidadCoches];
        // Arrays para almacenar los vehículos vendidos y los DNIs de los clientes
        String[] vehiculosVendidos = new String[cantidadCoches];
        String[] clientesDNI = new String[cantidadCoches];
        int contadorVehiculosVendidos = 0; // Contador para los arrays de vendidos


        do {
            //Menu principal con secciones
            System.out.println("\n--- Concesionario de Vehiculos (Menú Principal) ---");
            System.out.println("1. Vehiculos");
            System.out.println("2. Clientes");
            System.out.println("3. Ventas");
            System.out.println("4. Salir");
            
            opcionMenuPrincipal = validarNumero(sc, "Ingrese una opcion: ");
            sc.nextLine(); // Limpiar el buffer después de leer el número

            switch (opcionMenuPrincipal) {
                case 1 -> {
                    int opcionMenuVehiculos;
                    do {
                        mostrarVehiculos(placaVehiculos);
                        System.out.println("\n--- Gestión de Vehículos ---");
                        System.out.println("1. Insertar las placas");
                        System.out.println("2. Eliminar las placas");
                        System.out.println("3. Modificar las placas");
                        System.out.println("4. Volver al menú principal");
        
                        opcionMenuVehiculos = validarNumero(sc, "Eliga una opcion: ");
                        sc.nextLine(); // Limpiar el buffer después de leer el número
        
                        switch (opcionMenuVehiculos) {
                            case 1 ->
                                insertarVehiculo(sc, placaVehiculos);
                            case 2 -> 
                                eliminarVehiculo(sc, placaVehiculos);
                            case 3 -> 
                                modificarVehiculo(sc, placaVehiculos);
                            case 4 -> System.out.println("Volviendo al menú principal...");
                            default -> System.out.println("Opcion invalida");
                        }
                    } while (opcionMenuVehiculos != 4);
                }
                case 2 -> {
                    int opcionMenuClientes;
                    do {
                        System.out.println("\n--- Gestión de Clientes ---");
                        System.out.println("1. Buscar vehículos por cliente (DNI)");
                        System.out.println("2. Volver al menú principal");
                        opcionMenuClientes = validarNumero(sc, "Eliga una opcion: ");
                        sc.nextLine(); // Limpiar buffer

                        if (opcionMenuClientes == 1) {
                            buscarVehiculosPorCliente(sc, vehiculosVendidos, clientesDNI, contadorVehiculosVendidos);
                        }
                    } while (opcionMenuClientes != 2);
                }
                case 3 -> {
                    int opcionMenuVentas;
                    do {
                        System.out.println("\n--- Gestión de Ventas ---");
                        System.out.println("1. Vender vehículo");
                        System.out.println("2. Mostrar vehículos vendidos");
                        System.out.println("3. Volver al menú principal");
                        opcionMenuVentas = validarNumero(sc, "Eliga una opcion: ");
                        sc.nextLine(); // Limpiar buffer
                        switch (opcionMenuVentas) {
                            case 1 -> {
                                System.out.println("\n--- Vehículos Disponibles para la Venta ---");
                                mostrarVehiculos(placaVehiculos); // Mostramos los vehículos disponibles
                                contadorVehiculosVendidos = venderVehiculo(sc, placaVehiculos, vehiculosVendidos, clientesDNI, contadorVehiculosVendidos);
                            }
                            case 2 -> mostrarVehiculosVendidos(vehiculosVendidos, clientesDNI, contadorVehiculosVendidos);
                            case 3 -> System.out.println("Volviendo al menú principal...");
                            default -> System.out.println("Opcion invalida");
                        }
                    } while (opcionMenuVentas != 3);
                }
                case 4 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opcion invalida");
            }
        } while (opcionMenuPrincipal != 4);

        sc.close();
            
    }

    /*Validaciones */ 

    //Validar cantidad de vehiculos a ingresar
    static int validarNumero(Scanner sc,String mensaje){

        int numero = 0;
        boolean esValidoNumero = false;
        do{
            try {
                System.out.print(mensaje);
                numero = sc.nextInt();
                if (numero > 0) esValidoNumero = true;
                else System.out.println("Error: No puedes ingresar cero o numeros negativos");
            } catch (InputMismatchException e) {                
                System.out.println("Error valor invalido");
                sc.nextLine();
            }
        }while(!esValidoNumero);
        return  numero;
    }


    /*Metodos */
    ///////////////////////////////////////////////////////////////////////////////////
    //Mostrar vehiculos 
    static void mostrarVehiculos(String[] vehiculos){
        System.out.println("\n--- Listado de Vehículos en el Concesionario ---");
        boolean hayVehiculos = false;
        for (int i = 0; i < vehiculos.length; i++) {
            if (vehiculos[i] != null) {
                System.out.println("Numero de vehiculo" + (i + 1) + ": " + vehiculos[i]);
                hayVehiculos = true;
            }
        }
        if (!hayVehiculos) {
            System.out.println("No hay vehículos registrados en el concesionario.");
        }
    }
    //////////////////////////////////////////////////////////////////////////////////
    
    /////////////////////////////////////////////////////////////////////////////////
    //Ingresar vehiculos 
    static void insertarVehiculo(Scanner sc, String[] vehiculos){
        while (true) { // Bucle para permitir inserciones múltiples
            int posicionLibre = -1;
            // Buscamos la primera posición libre (null)
            for (int i = 0; i < vehiculos.length; i++) {
                if (vehiculos[i] == null) {
                    posicionLibre = i;
                    break;
                }
            }
            // Si no hay posiciones libres, el concesionario está lleno.
            if (posicionLibre == -1) {
                System.out.println("\nERROR: El concesionario está lleno, no se pueden insertar más vehículos.");
                return; // Salimos del método de inserción
            }

            System.out.print("Introduce la matrícula del nuevo vehículo: ");
            String nuevaMatricula = sc.nextLine();

            // --- SOLUCIÓN: Evitar matrículas vacías ---
            if (nuevaMatricula.trim().isEmpty()) {
                System.out.println("ERROR: La matrícula no puede estar vacía. Inténtelo de nuevo.");
                continue; // Vuelve al inicio del bucle de inserción
            }

            // Comprobación de matrícula duplicada
            boolean duplicada = false;
            //Usamos for each para recorrer el array de vehiculos
            for (String matriculaExistente : vehiculos) {
                if (matriculaExistente != null && matriculaExistente.equalsIgnoreCase(nuevaMatricula)) {
                    System.out.println("ERROR: Ya existe un vehículo con esa matrícula. Inténtelo de nuevo.");
                    duplicada = true;
                    break;
                }
            }
            if (duplicada) {
                continue; // Si está duplicada, saltamos al siguiente intento sin preguntar
            }
            vehiculos[posicionLibre] = nuevaMatricula;
            System.out.println("Vehículo con matrícula '" + nuevaMatricula + "' insertado correctamente.");

            // Bucle para validar la respuesta del usuario
            while (true) {
                System.out.println(); // Salto de línea para mejorar la legibilidad
                System.out.print("¿Desea registrar otro vehículo? (s/n): ");
                String respuesta = sc.nextLine();
                if (respuesta.equalsIgnoreCase("s")) {
                    break; // Rompe el bucle de validación y continúa con el de inserción
                } else if (respuesta.equalsIgnoreCase("n")) {
                    return; // Sale completamente del método insertarVehiculo
                } else {
                    System.out.println("ERROR: Opción no válida. Por favor, ingrese 's' para sí o 'n' para no.");
                    // El bucle de validación se repetirá
                }
            }
        }
}
    /////////////////////////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////////////////////
    //Eliminar vehiculos 
    static  void eliminarVehiculo(Scanner sc, String[] vehiculos) {
        System.out.print("Introduce la matrícula del vehículo a eliminar: ");
        String matriculaEliminar = sc.nextLine();

        // --- SOLUCIÓN: Evitar búsqueda vacía ---
        if (matriculaEliminar.trim().isEmpty()) {
            System.out.println("ERROR: La matrícula a eliminar no puede estar vacía.");
            return;
        }

        for (int i = 0; i < vehiculos.length; i++) {
            if (vehiculos[i] != null && vehiculos[i].equalsIgnoreCase(matriculaEliminar)) {
                vehiculos[i] = null; // Dejamos el hueco vacío
                System.out.println("Vehículo con matrícula '" + matriculaEliminar + "' eliminado.");
                return;
            }
        }
        System.out.println("ERROR: No se encontró ningún vehículo con esa matrícula.");
    }
    ///////////////////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////////////////////
    //Modificar vehiculos 
    static void modificarVehiculo(Scanner sc, String[] vehiculos) {
        // --- NUEVA COMPROBACIÓN: Verificar si hay vehículos para modificar ---
        boolean hayVehiculos = false;
        for (String vehiculo : vehiculos) {
            if (vehiculo != null) {
                hayVehiculos = true;
                break;
            }
        }
        if (!hayVehiculos) {
            System.out.println("\nERROR: No hay vehículos registrados en el concesionario para modificar.");
            return;
        }

        System.out.print("Introduce la matrícula del vehículo a modificar: ");
        String matriculaModificar = sc.nextLine();

        // --- SOLUCIÓN: Evitar búsqueda vacía ---
        if (matriculaModificar.trim().isEmpty()) {
            System.out.println("ERROR: La matrícula a modificar no puede estar vacía.");
            return;
        }

        for (int i = 0; i < vehiculos.length; i++) {
            if (vehiculos[i] != null && vehiculos[i].equalsIgnoreCase(matriculaModificar)) {
                System.out.print("Introduce la nueva matrícula para '" + vehiculos[i] + "': ");
                String nuevaMatricula = sc.nextLine();

                // --- SOLUCIÓN: Evitar matrícula nueva vacía ---
                if (nuevaMatricula.trim().isEmpty()) {
                    System.out.println("ERROR: La nueva matrícula no puede estar vacía.");
                    return;
                }

                // Comprobamos que la nueva matrícula no esté ya en uso por OTRO vehículo
                for (int j = 0; j < vehiculos.length; j++) {
                    // Ignoramos la posición que estamos modificando
                    if (i == j) {
                        continue;
                    }
                    if (vehiculos[j] != null && vehiculos[j].equalsIgnoreCase(nuevaMatricula)) {
                        System.out.println("ERROR: Ya existe otro vehículo con la matrícula '" + nuevaMatricula + "'.");
                        return;
                    }
                }

                vehiculos[i] = nuevaMatricula;
                System.out.println("Vehículo modificado correctamente.");
                return;
            }
        }
        System.out.println("ERROR: No se encontró ningún vehículo con esa matrícula.");
    }

    ////////////////////////////////////////////////////////////////////////////////
    //Vender vehiculos
    static int venderVehiculo(Scanner sc, String[] vehiculos, String[] vehiculosVendidos, String[] clientesDNI, int contadorVendidos) {
        if (contadorVendidos >= vehiculos.length) {
            System.out.println("ERROR: No hay más capacidad para registrar ventas.");
            return contadorVendidos;
        }

        System.out.print("Introduce la matrícula del vehículo a vender: ");
        String matriculaVender = sc.nextLine();

        // --- SOLUCIÓN: Evitar búsqueda vacía ---
        if (matriculaVender.trim().isEmpty()) {
            System.out.println("ERROR: La matrícula a vender no puede estar vacía.");
            return contadorVendidos;
        }

        for (int i = 0; i < vehiculos.length; i++) {
            if (vehiculos[i] != null && vehiculos[i].equalsIgnoreCase(matriculaVender)) {
                System.out.print("Introduce el DNI del cliente: ");
                String dni = sc.nextLine();

                // --- SOLUCIÓN: Evitar DNI vacío ---
                if (dni.trim().isEmpty()) {
                    System.out.println("ERROR: El DNI del cliente no puede estar vacío.");
                    return contadorVendidos; // No se realiza la venta
                }

                // Añadimos a los arrays de vendidos en la posición del contador
                vehiculosVendidos[contadorVendidos] = vehiculos[i];
                clientesDNI[contadorVendidos] = dni;

                System.out.println("¡Venta realizada! Vehículo '" + vehiculos[i] + "' vendido a cliente con DNI " + dni + ".");

                // Dejamos el hueco libre en el concesionario
                vehiculos[i] = null;
                return contadorVendidos + 1; // Devolvemos el nuevo total de vendidos
            }
        }
        System.out.println("ERROR: No se encontró ningún vehículo con esa matrícula para vender.");
        return contadorVendidos; // No se vendió, devolvemos el contador sin cambios
    }

    ////////////////////////////////////////////////////////////////////////////////
    //Mostrar vehiculos vendidos
    static void mostrarVehiculosVendidos(String[] vehiculosVendidos, String[] clientesDNI, int contadorVendidos) {
        System.out.println("\n--- Listado de Vehículos Vendidos ---");
        if (contadorVendidos == 0) {
            System.out.println("Aún no se ha vendido ningún vehículo.");
        } else {
            for (int i = 0; i < contadorVendidos; i++) {
                System.out.println("Matrícula: " + vehiculosVendidos[i] + " | Comprador (DNI): " + clientesDNI[i]);
            }
        }
    }

    ////////////////////////////////////////////////////////////////////////////////
    //Buscar vehiculos por cliente
    static void buscarVehiculosPorCliente(Scanner sc, String[] vehiculosVendidos, String[] clientesDNI, int contadorVendidos) {
        System.out.print("Introduce el DNI del cliente a buscar: ");
        String dniBuscar = sc.nextLine();

        // --- SOLUCIÓN: Evitar búsqueda vacía ---
        if (dniBuscar.trim().isEmpty()) {
            System.out.println("ERROR: El DNI a buscar no puede estar vacío.");
            return;
        }

        System.out.println("\n--- Vehículos del cliente con DNI: " + dniBuscar + " ---");
        boolean encontrados = false;
        for (int i = 0; i < contadorVendidos; i++) {
            if (clientesDNI[i] != null && clientesDNI[i].equalsIgnoreCase(dniBuscar)) {
                System.out.println("- Matrícula: " + vehiculosVendidos[i]);
                encontrados = true;
            }
        }
        if (!encontrados) {
            System.out.println("No se encontraron vehículos para este cliente.");
        }
    }
}