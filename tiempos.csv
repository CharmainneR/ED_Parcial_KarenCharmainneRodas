package benchmark;

/**
 * Clase utilitaria para medir tiempos de ejecucion.
 * - Usa System.nanoTime() (mayor precision que currentTimeMillis).
 * - Ejecuta cada prueba REPETICIONES veces y retorna el PROMEDIO en ms.
 * - La inicializacion de datos NO debe estar dentro del bloque medido.
 */
public class Medidor {

    private static final int REPETICIONES = 5;

    @FunctionalInterface
    public interface Algoritmo {
        void ejecutar();
    }

    public static double promediarMs(Algoritmo algoritmo) {
        long totalNanos = 0;
        for (int i = 0; i < REPETICIONES; i++) {
            long inicio = System.nanoTime();
            algoritmo.ejecutar();
            long fin    = System.nanoTime();
            totalNanos += (fin - inicio);
        }
        double promedioNanos = (double) totalNanos / REPETICIONES;
        return promedioNanos / 1_000_000.0;
    }
}
