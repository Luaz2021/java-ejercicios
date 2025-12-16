import java.util.Random;

public class SumaMatrices {
    public static void main(String[] args) {
        //3. Crear dos matrices de n filas x n columnas y sumar sus valores, 
        // los resultados se deben almacenar en otra matriz. 
        // Los valores y el tamaño no serán insertados por el usuario. 
        // Mostrar las matrices originales y el resultado.
        
        final int n = 3; // Tamaño de las matrices
        Random numeroAleatorio = new Random();
        
        int[][] matriz1 = new int[n][n];
        int[][] matriz2 = new int[n][n];
        int[][] matrizSuma = new int[n][n];

        //Rellenamos la primera matriz1 
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matriz1[i][j] = numeroAleatorio.nextInt(10);
            }
        }
        //Rellenamos la primera matriz2 
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matriz2[i][j] = numeroAleatorio.nextInt(10);
            }
        }
        //Sumamos las matrices
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrizSuma[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }

        // Imprimir las matrices en formato de suma
        System.out.println("--- Suma de Matrices ---");
        for (int i = 0; i < n; i++) {
            // Imprimir fila i de la matriz 1
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d", matriz1[i][j]);
            }
            System.out.print("   +    "); 
            // Imprimir fila i de la matriz 2
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d", matriz2[i][j]);
            }
            System.out.print("   =   "); 
            // Imprimir fila i de la matriz suma
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d", matrizSuma[i][j]);
            }
            System.out.println(); // Salto de línea para la siguiente fila de matrices
        }
        
    }
}
