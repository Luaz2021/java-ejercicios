import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayEjercicio1 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);//Abrimos el Escanner
        int[] numeros = new int[10];// Creamos el array con 10 posiciones

        int positivos = 0; // Creamos la variable para acumular los positivos
        int negativos = 0; //Creamos la variable para acumular los negativos
        int ceros = 0;  // Creamos la varibale para acumular los ceros


        System.out.println("Introduce 10 numeros enteros, no caracteres!!");

        //Recorremos el Array para rellenar todo los vacios dentro de las 10 posiciones
        for (int i=0;i<numeros.length;i++){ 
            //Llamamos al metodo validarNumero para ingresar los valores por teclado
            numeros[i] = validarNumero(sc, "Numero" + (i+1)+":");
        }

        //Volvemos a recorrer el Array para validar los positivos,negativos y ceros.
        for(int i=0;i<numeros.length;i++){
            if (numeros[i]>0) {
                positivos++;
            }else if(numeros[i]<0){
                negativos++;
            }else{
                ceros++;
            }
        }

        //Imprimimos los resultados
        System.out.println("Total positivos:\t"+ positivos);
        System.out.println("Total negativos:\t"+negativos);
        System.out.println("Total ceros    :\t"+ceros);

    }

    //Validamos errores para evitar entrar caracteres por consola
    private static int validarNumero(Scanner sc, String mensaje){
        int numero = 0;
        boolean valido = false;
        
        while(!valido){
            System.out.println(mensaje);
            try{
                numero = sc.nextInt();
                valido = true;
            }catch(InputMismatchException e){
                System.out.println("Debe ingresar numeros enteros");
                sc.nextLine();
            }
        }
        return numero;
    }
}
