package taller8;

import java.util.Arrays;

/**
 * Taller 8. Dividir y Conquistar. (MergeSort - QuickSort), algoritmos basados
 * en los siguientes dos videos: https://www.youtube.com/watch?v=EeQ8pwjQxTM
 * https://www.youtube.com/watch?v=aQiWF4E8flQ
 *
 * @author Alejandro Cano Munera
 * @author Sebastian Giraldo Gomez
 *
 * @version Abril 2018
 */
public class Taller8 {

    //Test
    public static void main(String[] args) {
        int[] a = {2, 10, 46, 1, 8};
        mergesort(a);
        int[] b = {2, 10, 46, 1, 8};
        quicksort(b);
    }

    //Punto 1.1
    public static void mergesort(int[] a) {
        System.out.println("MergeSort: ");
        System.out.println("Arreglo: " + Arrays.toString(a));
        int[] aux = new int[a.length];
        dividir(a, aux, 0, a.length - 1);
        System.out.println("Ordenado: " + Arrays.toString(a) + "\n");
    }

    //Punto 1.2
    public static void quicksort(int[] a) {
        System.out.println("QuickSort: ");
        System.out.println("Arreglo: " + Arrays.toString(a));
        quickOrdenar(a, 0, a.length - 1);
        System.out.println("Ordenado: " + Arrays.toString(a) + "\n");
    }

    /**
     * Para mergesort.
     *
     * @param a Es el arreglo de enteros el cual se dividira
     * @param aux Es un arreglo auxiliar de enteros que nos ayudara a la hora de
     * dividir el arreglo a.
     * @param primero Es la posicion del primer elemento del arreglo que estamos
     * evaluando.
     * @param ultimo Es la posicion del ultimo elemento del arreglo que estamos
     * evaluando.
     */
    private static void dividir(int[] a, int[] aux, int primero, int ultimo) {
        if (ultimo <= primero) {
            return;
        }
        int mitad = primero + (ultimo - primero) / 2;
        dividir(a, aux, primero, mitad);
        dividir(a, aux, mitad + 1, ultimo);
        ordenar(a, aux, primero, mitad, ultimo);
    }

    /**
     * Para mergesort.
     *
     * @param a Es el arreglo que se va a ordenar
     * @param aux Es un arreglo auxiliar que nos ayudara a la hora de ordenar el
     * arreglo a
     * @param primero Es la posicion del primer elemento del arreglo que estamos
     * evaluando.
     * @param mitad Es la posicion del elemento medio del arreglo que estamos
     * evaluando.
     * @param ultimo Es la posicion del ultimo elemento del arreglo que estamos
     * evaluando.
     */
    private static void ordenar(int[] a, int[] aux, int primero, int mitad, int ultimo) {
        for (int i = primero; i <= ultimo; i++) {
            aux[i] = a[i];
        }
        int i = primero, j = mitad + 1;
        for (int k = primero; k <= ultimo; k++) {
            if (i > mitad) {
                a[k] = aux[j++];
            } else if (j > ultimo) {
                a[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    /**
     * Para quicksort.
     *
     * @param a Es el arreglo que se va a ordenar
     * @param menor Es la posicion del primer elemento del arreglo.
     * @param mayor Es la posicion del ultimo elemento del arreglo.
     */
    public static void quickOrdenar(int[] a, int menor, int mayor) {
        if (a == null || a.length == 0) {
            return;
        }
        if (menor >= mayor) {
            return;
        }
        int pivote = a[menor + (mayor - menor) / 2]; //En el medio
        int i = menor, j = mayor;
        while (i <= j) {
            while (a[i] < pivote) {
                i++;
            }
            while (a[j] > pivote) {
                j--;
            }
            if (i <= j) {
                int aux = a[i];
                a[i] = a[j];
                a[j] = aux;
                i++;
                j--;
            }
        }
        if (menor < j) {
            quickOrdenar(a, menor, j);
        }
        if (mayor > i) {
            quickOrdenar(a, i, mayor);
        }
    }
}
