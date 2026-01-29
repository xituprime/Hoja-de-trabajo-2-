package test;
import static org.junit.Assert.*;
import org.junit.Test;
import src.PostfixCalculatorImpl;
import src.Stack;
import src.VectorStack;

import src.PostfixCalculator;

public class PostfixCalculatorImplTest {

    private PostfixCalculator calculadora;

    @BeforeEach
    public void setUp() {
        Stack<Integer> pila = new VectorStack<>();
        calculadora = new PostfixCalculatorImpl(pila);
    }

    @Test
    public void testExpresionValida() throws Exception {
        int resultado = calculadora.evaluar("1 2 + 4 * 3 +");
        assertEquals(15, resultado);
    }

    @Test
    public void testVariosDigitos() throws Exception {
        int resultado = calculadora.evaluar("10 5 + 2 *");
        assertEquals(30, resultado);
    }

    @Test
    public void testDivisionEntreCero() {
        Exception exception = assertThrows(
                Exception.class,
                () -> calculadora.evaluar("10 0 /")
        );
        assertEquals("División entre cero", exception.getMessage());
    }

    @Test
    public void testOperandosInsuficientes() {
        Exception exception = assertThrows(
                Exception.class,
                () -> calculadora.evaluar("5 +")
        );
        assertEquals("Operandos insuficientes", exception.getMessage());
    }
}

