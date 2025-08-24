public class MergeSort {
    // Método principal para probar el algoritmo
    public static void main(String[] args) {
        int[] numeros = {8, 3, 1, 7, 0, 10, 2};
        // Se llama al método mergeSort que ordenará el arreglo completo
        mergeSort(numeros, 0, numeros.length - 1);

        // Se imprime el resultado ya ordenado
        for (int num : numeros) {
            System.out.print(num + " ");
        }
    }

    /**
     * mergeSort divide el arreglo en mitades hasta llegar a subarreglos
     * de un solo elemento. Luego va combinando las mitades de forma ordenada.
     *
     * @param arr  Arreglo que se va a ordenar.
     * @param izq  Índice inicial del subarreglo.
     * @param der  Índice final del subarreglo.
     */
    public static void mergeSort(int[] arr, int izq, int der) {
        // Si izq es mayor o igual que der significa que el subarreglo
        // tiene cero o un elemento y no necesita ordenarse
        if (izq >= der) {
            return; // Caso base de la recursión
        }

        // Se calcula el índice medio para dividir el arreglo
        int medio = (izq + der) / 2;

        // Llamada recursiva para ordenar la mitad izquierda
        mergeSort(arr, izq, medio);
        // Llamada recursiva para ordenar la mitad derecha
        mergeSort(arr, medio + 1, der);

        // Finalmente se combinan las dos mitades ya ordenadas
        merge(arr, izq, medio, der);
    }

    /**
     * merge combina dos subarreglos ordenados en un solo arreglo ordenado.
     *
     * @param arr   Arreglo que contiene las dos mitades a combinar.
     * @param izq   Índice inicial de la primera mitad.
     * @param medio Índice final de la primera mitad.
     * @param der   Índice final de la segunda mitad.
     */
    private static void merge(int[] arr, int izq, int medio, int der) {
        // Calculamos la longitud de cada mitad
        int n1 = medio - izq + 1;
        int n2 = der - medio;

        // Arreglos temporales para guardar las mitades
        int[] izquierda = new int[n1];
        int[] derecha = new int[n2];

        // Copiamos los elementos a los arreglos temporales
        for (int i = 0; i < n1; i++) {
            izquierda[i] = arr[izq + i];
        }
        for (int j = 0; j < n2; j++) {
            derecha[j] = arr[medio + 1 + j];
        }

        // Indices iniciales para recorrer los arreglos temporales
        int i = 0; // índice para izquierda
        int j = 0; // índice para derecha
        int k = izq; // índice para la posición actual en arr

        // Mientras ambos arreglos tengan elementos por comparar
        while (i < n1 && j < n2) {
            // Se coloca en arr el menor de los elementos actuales
            if (izquierda[i] <= derecha[j]) {
                arr[k] = izquierda[i];
                i++;
            } else {
                arr[k] = derecha[j];
                j++;
            }
            k++;
        }

        // Copiamos los elementos restantes de izquierda (si hay)
        while (i < n1) {
            arr[k] = izquierda[i];
            i++;
            k++;
        }

        // Copiamos los elementos restantes de derecha (si hay)
        while (j < n2) {
            arr[k] = derecha[j];
            j++;
            k++;
        }
    }
}

