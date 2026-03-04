package algorithms;

/**
 * A4 - Ordenamiento Burbuja
 * Ordena un arreglo de enteros de menor a mayor.
 * Big-O Iterativo: O(n^2) — dos ciclos anidados
 * Big-O Recursivo: O(n^2) — burbujea el maximo al final, reduce n en 1
 */
public class OrdenamientoBurbuja {

    public static void iterativo(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp    = arr[j];
                    arr[j]     = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    public static void recursivo(int[] arr, int n) {
        if (n <= 1) return;                           // caso base
        for (int j = 0; j < n - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int tmp    = arr[j];
                arr[j]     = arr[j + 1];
                arr[j + 1] = tmp;
            }
        }
        recursivo(arr, n - 1);                        // reduce subproblema
    }

    public static void recursivo(int[] arr) {
        recursivo(arr, arr.length);
    }
}
