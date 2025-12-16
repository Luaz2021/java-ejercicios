public class Matrizx3 {
    public static void main(String[] args) {
        //1. Crear una matriz de 3×3 con los números del 1 al 9. 
        // Mostrar por pantalla en forma de matriz.

        // Creamos un array bidimensional
        int [][] matriz = new int [3][3];
        int contador = 1;

        //Recorremos la fila 
        for(int i = 0; i<matriz.length;i++){
            //Recorremos la columna
            for(int j = 0; j<matriz[i].length;j++){
                matriz[i][j] = contador;
                contador++;
            }
        }

        System.out.println("Matriz 3 x 3");

        for(int i = 0; i<matriz.length;i++){
            for(int j = 0; j<matriz[i].length;j++){
            System.out.printf("%4d",matriz[i][j]);
            }
            System.out.println();
        }

    }
}
