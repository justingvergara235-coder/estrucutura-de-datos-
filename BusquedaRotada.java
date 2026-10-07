 /*
     * Caso base:
     * Si lo  hi, significa que ya no quedan elementos para buscar.
     *
     * División:
     * Dividimos el arreglo por la mitad usando mid.
     *
     * Recursión:
     * Solo se busca en UNA mitad, porque una de las dos
     * mitades siempre está ordenada.
     *
     * Combinación:
     * No es necesaria porque solo buscamos una posición.
     *
     * Recurrencia:
     * T(n) = T(n/2) + O(1)
     *
     * Complejidad:
     * O(log n)
     */

    static int buscarRotado(int[] a, int objetivo, int lo, int hi) {

        // Caso base
        if (lo > hi) {
            return -1;
        }

        int mid = (lo + hi) / 2;

        // Si encontramos el objetivo, retornamos su posición.
        if (a[mid] == objetivo) {
            return mid;
        }

        // Revisamos si la mitad izquierda está ordenada.
        if (a[lo] <= a[mid]) {

            // Si el objetivo está dentro de la mitad izquierda.
            if (objetivo >= a[lo] && objetivo < a[mid]) {
                return buscarRotado(a, objetivo, lo, mid - 1);
            }

            // Si no, buscamos en la mitad derecha.
            return buscarRotado(a, objetivo, mid + 1, hi);

        } else {

            // La mitad derecha está ordenada.
            if (objetivo > a[mid] && objetivo <= a[hi]) {
                return buscarRotado(a, objetivo, mid + 1, hi);
            }

            // Si no, buscamos en la mitad izquierda.
            return buscarRotado(a, objetivo, lo, mid - 1);
        }
    }

    public static void main(String[] args) {

        int[] arreglo = {6, 7, 8, 1, 2, 3, 4, 5};

        // Ejemplo 1: buscar el número 3.
        System.out.println("Buscar 3: "
                + buscarRotado(arreglo, 3, 0, arreglo.length - 1));

        // Ejemplo 2: buscar el número 9.
        System.out.println("Buscar 9: "
                + buscarRotado(arreglo, 9, 0, arreglo.length - 1));

        // Caso borde: arreglo vacío.
        int[] vacio = {};
        System.out.println("Arreglo vacío: "
                + buscarRotado(vacio, 3, 0, vacio.length - 1));

        // Caso borde: un solo elemento.
        int[] uno = {5};
        System.out.println("Un solo elemento: "
                + buscarRotado(uno, 5, 0, uno.length - 1));
    }
}
