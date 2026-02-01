package test;
import static org.junit.Assert.*;
import org.junit.Test;
import src.PostfixCalculatorImpl;
import src.Stack;
import src.VectorStack;
import org.junit.Before;

import src.PostfixCalculator;

public class PostfixCalculatorImplTest {

    private PostfixCalculator calculadora;

    @Before
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
        try {
            calculadora.evaluar("10 0 /");
            fail("Se esperaba una excepción por división entre cero");
        } catch (Exception e) {
            assertEquals("División entre cero", e.getMessage());
        }
    }

    @Test
    public void testOperandosInsuficientes() {
        try {
            calculadora.evaluar("5 +");
            fail("Se esperaba una excepción por operandos insuficientes");
        } catch (Exception e) {
            assertEquals("Operandos insuficientes", e.getMessage());
        }
    }
}

