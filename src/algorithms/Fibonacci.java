package algorithms;

/**
 * A2 - Serie de Fibonacci
 * Big-O Iterativo: O(n)   — un solo ciclo, sin calculos repetidos
 * Big-O Recursivo: O(2^n) — cada llamada genera DOS subproblemas adicionales
 * Limite recursivo: n <= 30 para no generar tiempos exagerados.
 */
public class Fibonacci {

    public static long iterativo(int n) {
        if (n < 0) throw new IllegalArgumentException("n debe ser >= 0");
        if (n == 0) return 0;
        if (n == 1) return 1;
        long prev2 = 0, prev1 = 1, actual = 0;
        for (int i = 2; i <= n; i++) {
            actual = prev1 + prev2;
            prev2  = prev1;
            prev1  = actual;
        }
        return actual;
    }

    /** SIN memoizacion — O(2^n) */
    public static long recursivo(int n) {
        if (n < 0 || n > 30)
            throw new IllegalArgumentException("n debe estar entre 0 y 30");
        if (n == 0) return 0;                          // caso base 1
        if (n == 1) return 1;                          // caso base 2
        return recursivo(n - 1) + recursivo(n - 2);   // dos llamadas
    }
}
