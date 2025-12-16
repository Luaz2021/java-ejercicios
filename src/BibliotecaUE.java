
import java.util.Scanner;
public class BibliotecaUE {
    
      public static String[][] cargarLibros() {
        // Creamos un array más grande (20 huecos) para poder insertar libros después
        String[][] libros = new String[100][5]; // Aumentamos a 5 columnas para incluir el DNI
        String[][] datos = {
            {"1",  "El nombre del viento",                "Fantasía",        "Sí"},
            {"2",  "Fundacion",                           "Ciencia Ficción", "Sí"},
            {"3",  "El codigo Da Vinci",                  "Misterio",        "Sí"},
            {"4",  "Las uvas de la ira",                  "Clásico",         "Sí"},
            {"5",  "Donde los árboles cantan",            "Juvenil",         "Sí"},
            {"6",  "La sombra del viento",                "Drama",           "Sí"},
            {"7",  "Sapiens: De animales a dioses",       "No Ficción",      "Sí"},
            {"8",  "Un mundo feliz",                      "Ciencia Ficción", "Sí"},
            {"9",  "El amor en los tiempos del cólera",   "Romance",         "Sí"},
            {"10", "El guardián invisible",               "Suspense",        "Sí"}
        };
        
        // Copiamos los datos iniciales al array principal
        for (int i = 0; i < datos.length; i++) {
            libros[i][0] = datos[i][0];
            libros[i][1] = datos[i][1];
            libros[i][2] = datos[i][2];
            libros[i][3] = datos[i][3];
        }
        return libros;
    }
    public static void mostrarArrayLibros(String[][] libros) {
        System.out.println("\n--- LISTADO DE LIBROS ---");
        System.out.printf("%-5s %-35s %-20s %-10s %-12s%n", "ID", "Título", "Género", "Disp.", "DNI");
        for (int i = 0; i < libros.length; i++) {
            if (libros[i][0] != null) {
                String dni = (libros[i][4] == null) ? "" : libros[i][4];
                System.out.printf("%-5s %-35s %-20s %-10s %-12s%n", libros[i][0], libros[i][1], libros[i][2], libros[i][3], dni);
            }
        }
        System.out.println("---------------------------------------------------------------------------");
    }
    public static void mostrarMenu(){
        System.out.println("\nQue desea realizar el dia de hoy");
        System.out.println("""
                1. Insertar un libro
                2. Eliminar un libro
                3. Modificar un libro
                4. Alquilar un libro
                5. Devolver un libro
                6. Salir
                Elija una opcion:\s""");
    }
    public static void mostrarOpciones(int opcion, Scanner sc, String[][] libros){
        switch (opcion) {
                case 1:
                    insertarLibro(sc, libros);
                    break;
                case 2:
                    eliminarLibro(sc, libros);
                    break;
                case 3:
                    modificarLibro(sc, libros);
                    break;
                case 4:
                    mostrarArrayLibros(libros);
                    alquilarLibro(sc, libros);
                    break;
                case 5:
                    devolverLibro(sc, libros);
                    break;
                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción del 1 al 6.");
                    break;
            }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion ;

        // Llamamos al método para obtener el array listo
        String[][] libros = cargarLibros();
        
        System.out.println("");
        System.out.println("BIENVENIDO A LA BIBLIOTECA DE LA UNIVERSIDAD EUROPEA");
        
        do {
            mostrarArrayLibros(libros);
            mostrarMenu();
            opcion = validarOpcion(sc); 
            mostrarOpciones(opcion, sc, libros);    
        } while (opcion != 6);
        
        sc.close();
    }
    
    // Métodos para las operaciones del menú
    public static void insertarLibro(Scanner sc, String[][] libros) {
        boolean insertado = false;
        System.out.println("--- Insertar un nuevo libro ---");

        for (int i = 0; i < libros.length; i++) {
            // Si el hueco está vacío (es null), usamos este espacio
            if (libros[i][0] == null) {
                libros[i][0] = String.valueOf(i + 1);
                System.out.println("Asignando ID automático: " + libros[i][0]);
                System.out.println("Ingrese el Título:");
                libros[i][1] = sc.nextLine();
                System.out.println("Ingrese el Género:");
                libros[i][2] = sc.nextLine();
                libros[i][3] = "Sí"; // Disponible por defecto
                System.out.println("Libro insertado correctamente.");
                insertado = true;
                break; // Salimos del bucle al encontrar hueco
            }
        }
        if (!insertado) {
            System.out.println("La biblioteca está llena, no se pueden añadir más libros.");
        }
    }

    public static void eliminarLibro(Scanner sc, String[][] libros) {
        System.out.println("--- Eliminar un libro ---");
        System.out.println("Ingrese el título del libro a eliminar:");
        String titulo = sc.nextLine();
        boolean encontrado = false;

        for (int i = 0; i < libros.length; i++) {
            if (libros[i][0] != null && libros[i][1] != null && libros[i][1].equalsIgnoreCase(titulo)) {
                libros[i][1] = null; // Borramo s el título
                libros[i][2] = null; // Borramos el género
                // El ID (libros[i][0]) se mantiene igual según lo solicitado
                System.out.println("El libro ha sido eliminado (Título y Género borrados).");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ningún libro con ese título.");
        }
    }

    public static void modificarLibro(Scanner sc, String[][] libros) {
        System.out.println("--- Modificar un libro ---");
        System.out.println("Ingrese el título del libro que desea modificar:");
        String titulo = sc.nextLine();
        boolean encontrado = false;

        for (int i = 0; i < libros.length; i++) {
            // Verificamos que la posición tenga ID y Título (que no esté borrado lógicamente)
            if (libros[i][0] != null && libros[i][1] != null && libros[i][1].equalsIgnoreCase(titulo)) {
                System.out.println("Libro encontrado: " + libros[i][1]);
                System.out.println("Ingrese el nuevo Título:");
                libros[i][1] = sc.nextLine();
                System.out.println("Ingrese el nuevo Género:");
                libros[i][2] = sc.nextLine();
                System.out.println("El libro ha sido modificado correctamente.");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ningún libro con ese título.");
        }
    }

    public static void alquilarLibro(Scanner sc, String[][] libros) {
        System.out.println("--- Alquilar un libro ---");
        System.out.println("Ingrese el título del libro que desea alquilar:");
        String titulo = sc.nextLine();
        boolean encontrado = false;

        for (int i = 0; i < libros.length; i++) {
            if (libros[i][0] != null && libros[i][1] != null && libros[i][1].equalsIgnoreCase(titulo)) {
                if (libros[i][3].equals("Sí")) {
                    System.out.println("El libro está disponible.");
                    System.out.println("Ingrese el DNI de la persona que lo alquila:");
                    libros[i][4] = sc.nextLine(); // Guardamos el DNI en la columna 5
                    libros[i][3] = "No";          // Cambiamos estado a No disponible
                    System.out.println("Alquiler realizado con éxito a la persona con DNI: " + libros[i][4]);
                } else {
                    System.out.println("El libro ya está alquilado.");
                }
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró el libro.");
        }
    }

    public static void devolverLibro(Scanner sc, String[][] libros) {
        System.out.println("--- Devolver un libro ---");
        System.out.println("Ingrese el título del libro a devolver:");
        String titulo = sc.nextLine();
        boolean encontrado = false;

        for (int i = 0; i < libros.length; i++) {
            if (libros[i][0] != null && libros[i][1] != null && libros[i][1].equalsIgnoreCase(titulo)) {
                if (libros[i][3].equals("No")) {
                    System.out.println("Devolviendo libro alquilado por DNI: " + libros[i][4]);
                    libros[i][3] = "Sí";  // Vuelve a estar disponible
                    libros[i][4] = null;  // Borramos el DNI
                    System.out.println("Libro devuelto correctamente.");
                } else {
                    System.out.println("Este libro no figura como alquilado.");
                }
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró el libro.");
        }
    }

    public static int validarOpcion(Scanner sc){
        boolean esValido = false;
        int numeroConvertido = 0;

        do { 
            try{
                String numero = sc.nextLine();

                if(numero.trim().isEmpty()) {
                    System.out.println("El numero no puede estar vacio");
                    continue;
                }
                numeroConvertido = Integer.parseInt(numero);
               
                if (numeroConvertido > 0) {
                    esValido = true;
                }else{
                    System.out.println("El numero no puede ser negativo");
                }

            }catch(NumberFormatException e){
                System.out.println("Entrada no valida");
            }
        } while (!esValido);

        return numeroConvertido;
    }
}
