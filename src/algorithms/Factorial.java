package algorithms;

/**
 * A1 - Factorial
 * Big-O Iterativo: O(n) | Big-O Recursivo: O(n)
 * Limite: n entre 0 y 20 para evitar desbordamiento de long.
 */
public class Factorial {

    public static long iterativo(int n) {
        if (n < 0 || n > 20)
            throw new IllegalArgumentException("n debe estar entre 0 y 20");
        long resultado = 1;
        for (int i = 2; i <= n; i++) resultado *= i;
        return resultado;
    }

    public static long recursivo(int n) {
        if (n < 0 || n > 20)
            throw new IllegalArgumentException("n debe estar entre 0 y 20");
        if (n == 0 || n == 1) return 1;
        return n * recursivo(n - 1);
    }
}
