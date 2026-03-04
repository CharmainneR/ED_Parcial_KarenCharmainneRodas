# ED_Parcial — Algoritmos Iterativos vs Recursivos

**Universidad Da Vinci de Guatemala**
**Asignatura:** Estructura de Datos | **Catedratico:** Ing. Brandon Chitay

---

## Descripcion del Proyecto

Implementacion en Java de 4 algoritmos clasicos en sus versiones iterativa y recursiva,
con medicion de tiempos usando `System.nanoTime()` (promedio de 5 ejecuciones) y
analisis experimental de complejidad temporal Big-O.

| # | Algoritmo | Big-O Iterativo | Big-O Recursivo |
|---|-----------|----------------|----------------|
| A1 | Factorial | O(n) | O(n) |
| A2 | Fibonacci | O(n) | O(2^n) |
| A3 | Busqueda Lineal | O(n) | O(n) |
| A4 | Ordenamiento Burbuja | O(n^2) | O(n^2) |

---

## Estructura del Proyecto

```
ProyectoED_Demo/
├── src/
│   ├── algorithms/
│   │   ├── Factorial.java           ← A1: iterativo O(n) y recursivo O(n)
│   │   ├── Fibonacci.java           ← A2: iterativo O(n) y recursivo O(2^n)
│   │   ├── BusquedaLineal.java      ← A3: iterativo O(n) y recursivo O(n)
│   │   └── OrdenamientoBurbuja.java ← A4: iterativo O(n^2) y recursivo O(n^2)
│   └── benchmark/
│       ├── Medidor.java             ← Mide tiempos con System.nanoTime()
│       └── Main.java                ← Punto de entrada, exporta CSV
├── resultados/
│   └── tiempos.csv                  ← Se genera al ejecutar el programa
├── Tiempos_Rendimiento.xlsx         ← Analisis en Excel (4 hojas + graficas)
├── out/                             ← Archivos .class compilados
├── .sdkmanrc                        ← Configura Java 11 con SDKMAN
└── README.md
```

---

## Instrucciones para Compilar y Ejecutar

### Requisitos
- Java 11 o superior (`java --version`)

### Compilar
```bash
javac -d out \
  src/algorithms/Factorial.java \
  src/algorithms/Fibonacci.java \
  src/algorithms/BusquedaLineal.java \
  src/algorithms/OrdenamientoBurbuja.java \
  src/benchmark/Medidor.java \
  src/benchmark/Main.java
```

### Ejecutar
```bash
java -cp out benchmark.Main
```

Los resultados se exportan automaticamente a `resultados/tiempos.csv`.

---

## Enlace al Video de Demostracion

> **[Agregar enlace de YouTube aqui]**

---

## Prompts de IA Utilizados (Anexo)

1. Implementacion iterativa y recursiva del Factorial en Java con caso base 0!=1 y limite n=20
2. Fibonacci iterativo O(n) y recursivo O(2^n) sin memoizacion en Java, limite n=30
3. BusquedaLineal iterativa y recursiva retornando indice o -1 si no existe
4. OrdenamientoBurbuja iterativo con ciclos anidados y recursivo reduciendo subproblema en 1
5. Medidor.java usando System.nanoTime() promediando 5 ejecuciones y retornando milisegundos
6. Main.java ejecutando todos los benchmarks con los tamanos requeridos y exportando CSV
7. Script Python con openpyxl generando Excel de 4 hojas con graficas de dispersion y trendlines
8. Generacion de datos de benchmark reales mediante simulacion de los algoritmos en Python
