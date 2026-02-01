package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    
    public static void main(String[] args) {
        String archivoPath = "txt/expresiones.txt";
        
        System.out.println("=== Calculador de Expresiones Postfijas ===\n");
        System.out.println("Leyendo expresiones desde: " + archivoPath + "\n");
        
        try (BufferedReader lector = new BufferedReader(new FileReader(archivoPath))) {
            String linea;
            int numeroLinea = 1;
            
            while ((linea = lector.readLine()) != null) {
                // Ignorar líneas vacías y comentarios
                linea = linea.trim();
                if (linea.isEmpty() || linea.startsWith("#")) {
                    continue;
                }
                
                try {
                    // Crear una nueva pila para cada expresión
                    Stack<Integer> pila = new VectorStack<>();
                    PostfixCalculator calculador = new PostfixCalculatorImpl(pila);
                    
                    int resultado = calculador.evaluar(linea);
                    System.out.println("Línea " + numeroLinea + " - Expresión: " + linea);
                    System.out.println("Resultado: " + resultado + "\n");
                    
                } catch (Exception e) {
                    System.out.println("Línea " + numeroLinea + " - Expresión: " + linea);
                    System.out.println("Error: " + e.getMessage() + "\n");
                }
                
                numeroLinea++;
            }
            
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            System.out.println("Asegúrate de que el archivo '" + archivoPath + "' existe.");
        }
    }
}
