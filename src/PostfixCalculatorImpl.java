package src;
import src.Stack;


public class PostfixCalculatorImpl implements PostfixCalculator {

    // Pila que se usa para evaluar la expresión
    private Stack<Integer> pilaOperandos;

    // Constructor: recibe la pila (inyección de dependencias)
    public PostfixCalculatorImpl(Stack<Integer> pilaOperandos) {
        this.pilaOperandos = pilaOperandos;
    }

    // Método principal que evalúa la expresión postfix
    @Override
    public int evaluar(String expresionActual) throws Exception {

        // Separar la expresión por espacios
        String[] elementosExpresion = expresionActual.split(" ");

        // Recorrer cada token de izquierda a derecha
        for (String token : elementosExpresion) {

            // Si el token es un operando (número entero positivo)
            if (esOperando(token)) {
                pilaOperandos.push(Integer.parseInt(token));

            // Si el token es un operador válido
            } else if (esOperadorValido(token)) {

                // Verificar que existan al menos dos operandos
                if (pilaOperandos.size() < 2) {
                    throw new Exception("Operandos insuficientes");
                }

                // Extraer operandos (orden importante)
                int valorDerecho = pilaOperandos.pop();
                int valorIzquierdo = pilaOperandos.pop();

                // Aplicar la operación
                int resultadoOperacion = aplicarOperacion(
                        valorIzquierdo,
                        valorDerecho,
                        token.charAt(0)
                );

                // Insertar el resultado en la pila
                pilaOperandos.push(resultadoOperacion);

            } else {
                // Token inválido
                throw new Exception("Token inválido: " + token);
            }
        }

        // Al finalizar, debe quedar un solo valor
        if (pilaOperandos.size() != 1) {
            throw new Exception("Expresión postfix inválida");
        }

        // Retornar el resultado final
        return pilaOperandos.pop();
    }

    // Verifica si el token es un número entero positivo (uno o más dígitos)
    private boolean esOperando(String token) {
        return token.matches("\\d+");
    }

    // Verifica si es un operador aritmético válido
    private boolean esOperadorValido(String token) {
        return token.equals("+") || token.equals("-")
            || token.equals("*") || token.equals("/")
            || token.equals("%");
    }

    // Realiza la operación aritmética correspondiente
    private int aplicarOperacion(int valorIzquierdo, int valorDerecho, char simboloOperacion)
            throws Exception {

        switch (simboloOperacion) {
            case '+':
                return valorIzquierdo + valorDerecho;
            case '-':
                return valorIzquierdo - valorDerecho;
            case '*':
                return valorIzquierdo * valorDerecho;
            case '/':
                if (valorDerecho == 0) {
                    throw new Exception("División entre cero");
                }
                return valorIzquierdo / valorDerecho;
            case '%':
                if (valorDerecho == 0) {
                    throw new Exception("Módulo entre cero");
                }
                return valorIzquierdo % valorDerecho;
            default:
                throw new Exception("Operador no válido");
        }
    }
}
