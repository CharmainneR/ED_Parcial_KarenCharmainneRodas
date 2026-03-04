package benchmark;

import algorithms.Factorial;
import algorithms.Fibonacci;
import algorithms.BusquedaLineal;
import algorithms.OrdenamientoBurbuja;

import java.io.*;
import java.util.Random;

/**
 * Punto de entrada: ejecuta todos los benchmarks y exporta resultados a CSV.
 */
public class Main {

    static final int[] N_FACT_FIB     = {5, 10, 15, 20, 25, 30};
    static final int[] N_BUSQ_BURBUJA = {100, 500, 1000, 5000, 10000};

    public static void main(String[] args) throws IOException {
        System.out.println("=================================================");
        System.out.println("  Benchmark: Algoritmos Iterativos vs Recursivos");
        System.out.println("  Estructura de Datos | Ing. Brandon Chitay");
        System.out.println("=================================================\n");

        StringBuilder csv = new StringBuilder("Algoritmo,Version,n,Tiempo_ms\n");

        // ── A1: Factorial ──────────────────────────────────────────────────
        printSeparador("A1", "Factorial");
        printHeader();
        for (int n : N_FACT_FIB) {
            if (n > 20) break;
            final int fn = n;
            double ti = Medidor.promediarMs(() -> Factorial.iterativo(fn));
            double tr = Medidor.promediarMs(() -> Factorial.recursivo(fn));
            printFila(n, ti, tr);
            csv.append(String.format("A1-Factorial,Iterativo,%d,%.8f%n", n, ti));
            csv.append(String.format("A1-Factorial,Recursivo,%d,%.8f%n",  n, tr));
        }

        // ── A2: Fibonacci ──────────────────────────────────────────────────
        printSeparador("A2", "Fibonacci");
        printHeader();
        for (int n : N_FACT_FIB) {
            final int fn = n;
            double ti = Medidor.promediarMs(() -> Fibonacci.iterativo(fn));
            double tr = Medidor.promediarMs(() -> Fibonacci.recursivo(fn));
            printFila(n, ti, tr);
            csv.append(String.format("A2-Fibonacci,Iterativo,%d,%.8f%n", n, ti));
            csv.append(String.format("A2-Fibonacci,Recursivo,%d,%.8f%n",  n, tr));
        }

        // ── A3: Busqueda Lineal ────────────────────────────────────────────
        printSeparador("A3", "Busqueda Lineal");
        printHeader();
        Random rng = new Random(42);
        for (int n : N_BUSQ_BURBUJA) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = rng.nextInt(n * 10);
            int objetivo = -1; // fuerza recorrido completo
            double ti = Medidor.promediarMs(() -> BusquedaLineal.iterativo(arr, objetivo));
            double tr = Medidor.promediarMs(() -> BusquedaLineal.recursivo(arr, objetivo));
            printFila(n, ti, tr);
            csv.append(String.format("A3-BusquedaLineal,Iterativo,%d,%.8f%n", n, ti));
            csv.append(String.format("A3-BusquedaLineal,Recursivo,%d,%.8f%n",  n, tr));
        }

        // ── A4: Ordenamiento Burbuja ───────────────────────────────────────
        printSeparador("A4", "Ordenamiento Burbuja");
        printHeader();
        Random rng2 = new Random(42);
        for (int n : N_BUSQ_BURBUJA) {
            int[] base = new int[n];
            for (int i = 0; i < n; i++) base[i] = rng2.nextInt(n * 10);
            double ti = Medidor.promediarMs(() -> {
                int[] copia = base.clone();
                OrdenamientoBurbuja.iterativo(copia);
            });
            double tr = Medidor.promediarMs(() -> {
                int[] copia = base.clone();
                OrdenamientoBurbuja.recursivo(copia);
            });
            printFila(n, ti, tr);
            csv.append(String.format("A4-Burbuja,Iterativo,%d,%.8f%n", n, ti));
            csv.append(String.format("A4-Burbuja,Recursivo,%d,%.8f%n",  n, tr));
        }

        // ── Exportar CSV ───────────────────────────────────────────────────
        new File("resultados").mkdirs();
        try (PrintWriter pw = new PrintWriter(new FileWriter("resultados/tiempos.csv"))) {
            pw.print(csv);
        }
        System.out.println("\n=================================================");
        System.out.println("  [OK] CSV exportado: resultados/tiempos.csv");
        System.out.println("=================================================");
    }

    private static void printSeparador(String id, String nombre) {
        System.out.printf("%n[ %s ] %s%n", id, nombre);
        System.out.println("  " + "-".repeat(46));
    }

    private static void printHeader() {
        System.out.printf("  %-8s  %-18s  %-18s%n", "n", "Iterativo (ms)", "Recursivo (ms)");
        System.out.println("  " + "-".repeat(46));
    }

    private static void printFila(int n, double ti, double tr) {
        System.out.printf("  %-8d  %-18.8f  %-18.8f%n", n, ti, tr);
    }
}
