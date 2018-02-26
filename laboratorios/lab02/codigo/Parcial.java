package lab02;

import java.util.Arrays;

/**
 * Preguntas de parcial. Punto 1, 2
 *
 * @author Alejandro Cano Munera
 * @author Sebastian Giraldo Gomez
 * @version Febrero 2018
 */
public class Parcial {

    public static void main(String[] args) {
        System.out.println("Punto 1: ");
//        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        System.out.println("Suma maxima: " + subarregloMax(a));
        System.out.println();

        System.out.println("Punto 2:");
//        int[] a = {1, 2, 3, 4, 5, 6};
//        int[] b = {5, 4, 3, 2, 1, 0};
//        int[] c = {10, 7, 6, 2, 4, -1};
//        System.out.println("Arreglo I: ");
//        ordenar(a, 0);
//        System.out.println("Arreglo II: ");
//        ordenar(b, 0);
//        System.out.println("Arreglo III: ");
//        ordenar(c, 0);
        System.out.println();

        System.out.println("Punto 3: ");
//        System.out.println("atr, Patrón");
//        System.out.println("Posicion: "+indexOf("atr", "Patrón"));
//        
//        System.out.println("mat, Patrón");
//        System.out.println("Posicion: "+indexOf("mat", "Patrón"));
//        
//        System.out.println("dro, Alejandro");
//        System.out.println("Posicion: "+indexOf("dro", "Alejandro"));
//        
//        System.out.println("Cano, Alejandro");
//        System.out.println("Posicion: "+indexOf("Cano", "Alejandro"));
//        
//        System.out.println("tian, Sebastian");
//        System.out.println("Posicion: "+indexOf("tian", "Sebastian"));
//        
        System.out.println();
    }

    //Punto 1.
    //Complejidad O(n^2)
    static int subarregloMax(int[] a) {
        int maximo = 0;
        for (int i = 0; i < a.length; i++) {
            int actual = 0;
            for (int j = i; j < a.length; j++) {
                actual = actual + a[j];
                if (maximo < actual) {
                    maximo = actual;
                }
            }
        }
        return maximo;
    }

    //Punto 2.
    //Complejidad O(n^2)
    //O(n)
    static boolean estaOrdenado(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }

    //O(1)
    static void cambiar(int[] arr, int i, int k) {
        int t = arr[i];
        arr[i] = arr[k];
        arr[k] = t;
    }

    //O(n^2)
    static void ordenar(int[] arr, int k) {
        for (int i = k; i < arr.length; i++) {
            cambiar(arr, i, k);
            if (estaOrdenado(arr)) {
                System.out.println(Arrays.toString(arr));
                return;
            } else {
                ordenar(arr, k + 1);
                cambiar(arr, k, i);
            }
        }
    }

    //Punto 3.
    //Complejidad O(n*m)
    static int indexOf(String pat, String txt) {
        int m = pat.length();
        int n = txt.length();
        int i, j;
        for (i = 0, j = 0; i < n && j < m; i++) {
            if (txt.charAt(i) == pat.charAt(j)) {
                j++;
            } else {
                i = i - j;
                j = 0;
            }
        }
        if (j == m) {
            return i - (m); // encontrado 

        } else {
            return n - 1; // no encontrado 
        }
    }

}
