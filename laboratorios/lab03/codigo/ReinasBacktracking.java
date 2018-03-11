package lab03;

import java.util.Arrays;

/**
 * Laboratorio 3. Punto 1.1. Implementacion del ejercicio de las n reinas
 * utilizando Backtracking
 *
 * @author Alejandro Cano Munera
 * @author Sebastian Giraldo Gomez
 *
 * @version Marzo 2018
 */
public class ReinasBacktracking {

    //Variable global
    static boolean listo = false;

    /**
     * Metodo reinas. este metodo recibe un numer n y renorna una solucion del
     * problema de las reinas en un tablero nxn
     *
     * @param n Es la dimension del tablero.
     * @return Es la solucion del tablero con n numero de reinas, si la solucion
     * no es posible se retorna null.
     */
    public static int[] reinas(int n) {
        listo = false;
        int[] tablero = new int[n];
        reinasAux(0, tablero);
        if (sinSolucion(tablero)) {
            tablero = null;
        }
        return tablero;
    }

    /**
     * Metodo reinasAux. Este metodo funciona como metodo auxiliar del metodo
     * reinas para buscar una solucion al problema.
     *
     * @param n Es el numero de reinas.
     * @param tablero Es el tablero (posible solucion) que se esta evaluando.
     */
    private static void reinasAux(int n, int[] tablero) {
        if (n == tablero.length) {
            if (verificar(tablero)) {
                listo = true;
            }
        } else {
            for (int i = 0; i < tablero.length; i++) {
                if (listo == true) {
                    break;
                }
                tablero[n] = i;
                reinasAux(n + 1, tablero);
            }
        }
    }

    /**
     * Metodo verificar. Este metodo verifica si una reina se pude poner en
     * determinada posicion.
     *
     * @param tablero Es el tablero que se esta evaluando.
     * @return Se retorna true si se puede poner la reina en determinada
     * posicion, y false de lo contrario.
     */
    private static boolean verificar(int[] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = i + 1; j < tablero.length; j++) {
                if (tablero[i] == tablero[j] || Math.abs(tablero[i] - tablero[j]) == Math.abs(i - j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Metodo sin solucion. Este metodo verifica si un tablero de nxn con n
     * reinas no tiene solucion.
     *
     * @param tablero Es el tablero que se esta evaluando
     * @return Se retorna true si no tiene solucion, false de lo contrario.
     */
    private static boolean sinSolucion(int[] tablero) {
        int n = tablero.length;
        System.out.println(n);
        if (n == 1) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            if (tablero[i] != n - 1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        for (int i = 4; i < 32; i++) {
             long startTime = System.currentTimeMillis();
             reinas(i);
              long finishTime =  System.currentTimeMillis() - startTime;
              System.out.println(i+" "+finishTime);
        }

    }
}
