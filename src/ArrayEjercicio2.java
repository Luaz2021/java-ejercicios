import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;



public class ArrayEjercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);//Iniciamos el escaner 
        
        double sumaAlturas = 0.0;// Creamos la varible para la media de las alturas
        int superiorMedia = 0;// Creamos la variable para la mediasuperior
        int inferiorMedia = 0;//Creamos la varibale para la mediainferior
        
        //Usamos el metodo para validar el numero ingresado por consola y evitar erorres al ingresar caracter y otros.
        int N = validarNumero(sc, "Introduce el numero de personas: ");

        double[] alturas = new double[N];//Iniciamos el Array

        //Recorremos el Array y rellenamos los datos ingresados por consola
        for (int i=0;i<N;i++) {
            alturas[i] = validarAltura(sc, "Numero" + (i+1)+":");
            sumaAlturas += alturas[i];//Calculamos la suma total de todo los datos ingresados
            
            /*/ Pedimos al usuario que ingrese la altura
            System.out.print("Numero " + (i + 1) + ": ");
    
            // Leemos directamente el valor doble del teclado y lo asignamos al array
            alturas[i] = sc.nextDouble(); 
    
            // Calculamos la suma total de todos los datos ingresados
            sumaAlturas += alturas[i];*/
        }

        //Buscamos la media 
        double media = sumaAlturas/N;

       //Volvemos a recorrer el Array para buscar la mediasuperior e inferior
        for(int i=0;i<N;i++){
            if(alturas[i]>media){
                superiorMedia++;
            }else{
                inferiorMedia++;
            }
        }

        System.out.printf("La media es: %.2f\n", media);//Formateamos a dos decimales
        System.out.println("Personas mayores a la media: "+superiorMedia);
        System.out.println("Personas menores a la media: "+inferiorMedia);
        sc.close();
        }


    //Metodo para validar el numero N evitamos ingreso de valores negativos y caracteres
    private static int validarNumero(Scanner sc, String mensaje){
        int N = -1; 
        boolean esValido = false;
        
        do { 
            System.out.println(mensaje);    
            try {
                N = sc.nextInt();
                if(N<0){
                    System.out.println("El numero debe ser positivo");
                }else{
                    esValido = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar numeros enteros");
                sc.next();
            }

        } while (!esValido);
        sc.nextLine();
        return N;
    }

    //Metodo para validar altura 
    private static double validarAltura(Scanner sc, String mensaje){   
        double altura = 0.0;
        boolean esValido = false;

        do { 
            System.out.println(mensaje);
            try{
                altura = sc.nextDouble();
                if (altura<0) {
                    System.out.println("La altura no puede ser un número negativo");
                }else{
                    esValido = true;
                }
            }catch(InputMismatchException e){
                System.out.println("Debe ingresar un numero");
                sc.next();
            }
        } while (!esValido);
        sc.nextLine();
      return altura;  
    }

}
