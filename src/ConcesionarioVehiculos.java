
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConcesionarioVehiculos {
    public static void main(String[] args) {
        //Una vez terminado el ejercicio podemos añadir funcionalidades. 
        // Por ejemplo realizar la venta de un  vehículo a un cliente con su DNI, 
        // mostrar vehículos para la venta disponibles, 
        // mostrar los vehículos vendidos, 
        // mostrar los vehículos de un cliente en concreto,......
        // Si tenéis dudas me decís, un saludo.

        Scanner sc = new Scanner(System.in);

        int cantidadVehiculos = vehiculosIngresar(sc, "Introduce el numero de vehiculos: ");
        String[] vehiculos = new String[cantidadVehiculos];

        // Arrays para almacenar los vehículos vendidos y los DNIs de los clientes
        String[] vehiculosVendidos = new String[cantidadVehiculos];
        String[] clientesDNI = new String[cantidadVehiculos];
        int contadorVehiculosVendidos = 0; // Contador para los arrays de vendidos

        int opcion;
        do {
            System.out.println("\n--- Menú Concesionario ---");
            System.out.println("1. Insertar vehículo");
            System.out.println("2. Eliminar vehículo");
            System.out.println("3. Modificar vehículo");
            System.out.println("4. Vender vehículo a cliente");
            System.out.println("5. Mostrar vehículos para la venta");
            System.out.println("6. Mostrar vehículos vendidos");
            System.out.println("7. Buscar vehículos por cliente (DNI)");
            System.out.println("8. Salir");
            System.out.print("Elige una opción: ");

            try {
                opcion = sc.nextInt();
                sc.nextLine(); // Limpiar buffer

                switch (opcion) {
                    case 1:
                        insertarVehiculo(sc, vehiculos);
                        break;
                    case 2:
                        eliminarVehiculo(sc, vehiculos);
                        break;
                    case 3:
                        modificarVehiculo(sc, vehiculos);
                        break;
                    case 4:
                        contadorVehiculosVendidos = venderVehiculo(sc, vehiculos, vehiculosVendidos, clientesDNI, contadorVehiculosVendidos);
                        break;
                    case 5:
                        mostrarVehiculos(vehiculos);
                        break;
                    case 6:
                        mostrarVehiculosVendidos(vehiculosVendidos, clientesDNI, contadorVehiculosVendidos);
                        break;
                    case 7:
                        buscarVehiculosPorCliente(sc, vehiculosVendidos, clientesDNI, contadorVehiculosVendidos);
                        break;
                    case 8:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("ERROR: Opción no válida.");
                }
                if (opcion >= 1 && opcion <= 4) {
                    mostrarVehiculos(vehiculos); // Muestra el estado actual tras una operación
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Debes introducir un número para la opción.");
                sc.nextLine(); // Limpiar buffer en caso de error
                opcion = 0; // Resetear opción para que el bucle continúe
            }
        } while (opcion != 8);

        sc.close();
    }
    //Metodo para insertar vehiculo
    static void insertarVehiculo(Scanner sc, String[] vehiculos) {
        while (true) { // Bucle para permitir inserciones múltiples
            int posicionLibre = -1;
            // Buscamos la primera posición libre
            for (int i = 0; i < vehiculos.length; i++) {
                if (vehiculos[i] == null) {
                    posicionLibre = i;
                    break;
                }
            }

            // Si no hay posiciones libres, el concesionario está lleno.
            if (posicionLibre == -1) {
                System.out.println("ERROR: El concesionario está lleno, no se pueden insertar más vehículos.");
                return; // Salimos del método de inserción
            }

            System.out.print("Introduce el nombre/matrícula del vehículo: ");
            String nuevoVehiculo = sc.nextLine();

            if (existeMatricula(nuevoVehiculo, vehiculos)) {
                System.out.println("ERROR: No permitido. Ya existe un vehículo con esa matrícula.");
            } else {
                vehiculos[posicionLibre] = nuevoVehiculo;
                System.out.println("Vehículo '" + nuevoVehiculo + "' insertado en la posición " + (posicionLibre + 1) + ".");
            }

            System.out.print("¿Desea ingresar otra matrícula? (s/n): ");
            String respuesta = sc.nextLine();
            if (!respuesta.equalsIgnoreCase("s")) {
                break; // Si la respuesta no es 's', salimos del bucle de inserción
            }
        }
    }
    //Metodo para eliminar Vehiculo
    static void eliminarVehiculo(Scanner sc, String[] vehiculos) {
        System.out.print("Introduce la matrícula del vehículo a eliminar: ");
        String matriculaEliminar = sc.nextLine();

        for (int i = 0; i < vehiculos.length; i++) {
            if (vehiculos[i] != null && vehiculos[i].equalsIgnoreCase(matriculaEliminar)) {
                vehiculos[i] = null; // Dejamos el hueco vacío
                System.out.println("Vehículo con matrícula '" + matriculaEliminar + "' eliminado.");
                return;
            }
        }

        System.out.println("ERROR: No se encontró ningún vehículo con esa matrícula.");
    }

    //Metodo para modificar vehiculo
    static void modificarVehiculo(Scanner sc, String[] vehiculos) {
        System.out.print("Introduce la matrícula del vehículo a modificar: ");
        String matriculaModificar = sc.nextLine();

        for (int i = 0; i < vehiculos.length; i++) {
            if (vehiculos[i] != null && vehiculos[i].equalsIgnoreCase(matriculaModificar)) {
                System.out.print("Introduce la nueva matrícula para '" + vehiculos[i] + "': ");
                String nuevaMatricula = sc.nextLine();

                if (existeMatricula(nuevaMatricula, vehiculos)) {
                    System.out.println("ERROR: No permitido. Ya existe otro vehículo con la matrícula '" + nuevaMatricula + "'.");
                    return;
                }
                vehiculos[i] = nuevaMatricula;
                System.out.println("Vehículo modificado correctamente.");
                return;
            }
        }
        System.out.println("ERROR: No se encontró ningún vehículo con esa matrícula.");
    }
    //Metodo para validar el numero ingresado por consola y evitar errores y la cantidad de vehiculos a ingresar
    static int vehiculosIngresar(Scanner sc, String mensaje){
        int numero = 0;
        boolean esValido = false;
        
        do { 
            try{
                System.out.print(mensaje);
                numero = sc.nextInt();
                if (numero > 0) esValido = true;     
                else System.out.println("ERROR: El número no puede ser negativo.");
            }catch(InputMismatchException e){
                System.out.println("ERROR: Debes introducir un número entero válido.");
                sc.nextLine();
            }
        } while (!esValido);
        return numero;
    }

    //Metodo para mostrar los vehiculos
    static void mostrarVehiculos(String[] vehiculos) {
        System.out.println("\n--- Listado de Vehículos para la Venta ---");
        boolean hayVehiculos = false;
        for (int i = 0; i < vehiculos.length; i++) {
            if (vehiculos[i] != null) {
                System.out.println("Vehiculo " + (i + 1) + ": " + vehiculos[i]);
                hayVehiculos = true;
            }
        }
        if (!hayVehiculos) System.out.println("No hay vehículos en el concesionario.");
    }
    //Metodo para ver si existen las matriculas y no repetir
    static boolean existeMatricula(String matricula, String[] vehiculos) {
        //For Foreach para recorrer el array 
        for (String v : vehiculos) {
            if (v != null && v.equalsIgnoreCase(matricula)) {
                return true; // La matrícula ya existe
            }
        }
        return false; // La matrícula no existe
    }

    static int venderVehiculo(Scanner sc, String[] vehiculos, String[] vehiculosVendidos, String[] clientesDNI, int contadorVendidos) {
        if (contadorVendidos >= vehiculos.length) {
            System.out.println("ERROR: No hay más capacidad para registrar ventas.");
            return contadorVendidos;
        }

        System.out.print("Introduce la matrícula del vehículo a vender: ");
        String matriculaVender = sc.nextLine();

        for (int i = 0; i < vehiculos.length; i++) {
            if (vehiculos[i] != null && vehiculos[i].equalsIgnoreCase(matriculaVender)) {
                System.out.print("Introduce el DNI del cliente: ");
                String dni = sc.nextLine();

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

    static void buscarVehiculosPorCliente(Scanner sc, String[] vehiculosVendidos, String[] clientesDNI, int contadorVendidos) {
        System.out.print("Introduce el DNI del cliente a buscar: ");
        String dniBuscar = sc.nextLine();
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
