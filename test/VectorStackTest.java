package test;
import static org.junit.Assert.*;
import org.junit.Test;
import src.Stack;
import src.VectorStack;

public class VectorStackTest {
    
    @Test
    public void testPushYPop(){
        Stack<Integer> pila = new VectorStack<>();
        pila.push(10);
        pila.push(20);
        assertEquals(20, (int)pila.pop());
        assertEquals(10, (int)pila.pop());
    }

    @Test
    public void testPeek(){
        Stack<Integer> pila = new VectorStack<>();
        pila.push(3);
        assertEquals(3, (int)pila.peek());

        assertEquals(1, pila.size());
    }

    @Test
    public void testIsEmpty(){
        Stack<Integer> pila = new VectorStack<>();
        assertTrue(pila.isEmpty());

        pila.push(5);

        assertFalse(pila.isEmpty());
    }
    
    @Test
    public void clearTest() {
        Stack<Integer> pila = new VectorStack<>();
        pila.push(1);
        pila.push(2);
        pila.push(3);
        assertEquals(3, pila.size());
        pila.clear();
        assertTrue(pila.isEmpty());
    }
}
