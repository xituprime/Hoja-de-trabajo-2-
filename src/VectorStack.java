package src;
import java.util.Vector;

public class VectorStack<T> implements Stack<T> {

    // Vector para almacenar los elementos de la pila
    private Vector<T> elementos;

    // Constructor de la pila utilizando Vector
    public VectorStack(){
        elementos = new Vector<>();
    }

    // Implementación de los métodos de la interfaz Stack
    @Override
    public void push(T elemento){
        elementos.add(elemento);
    }

    @Override
    public T pop(){
        if (isEmpty()){
            throw new RuntimeException("La pila está vacía");
        }
        return elementos.remove(elementos.size() - 1);
    } 
    
    @Override
    public T peek(){
        if (isEmpty()){
            throw new RuntimeException("La pila está vacía");
        }
        return elementos.lastElement();
    }

    @Override
    public boolean isEmpty(){
        return elementos.isEmpty();
    }

    @Override
    public int size(){
        return elementos.size();
    }

    @Override
    public void clear(){
        elementos.clear();
    }
}
