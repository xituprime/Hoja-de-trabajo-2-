package src;
public interface Stack<T>{

    // Agrega un elemento a la cima de la pila
    void push(T elemento);

    // Elimina y retorna el elemento en la cima de la pila
    T pop();

    // Retorna el elemento en la cima de la pila sin eliminarlo
    T peek();
    
    // Verifica si la pila está vacía
    boolean isEmpty();

    // Retorna el número de elementos en la pila
    int size();
}