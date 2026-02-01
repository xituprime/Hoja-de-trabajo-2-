package src;
public interface Stack<T>{

    // Agrega un valor a la cima de la pila
    void push(T value);

    // Elimina y retorna el elemento en la cima de la pila
    T pop();

    // Retorna el elemento en la cima de la pila sin eliminarlo
    T peek();
    
    // Verifica si la pila está vacía
    boolean isEmpty();

    // Retorna el número de elementos en la pila
    int size();

    // Limpia todos los elementos de la pila
    void clear();
}