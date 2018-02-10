package lab01;

import java.util.*;

/**
 * Laboratorio 1. Clase Coloracion. En esta clase esta el codigo que corre el
 * ejercicio 2.1 propuesto en el laboratorio 6 (Ver si un grafo se puede
 * colorear con dos colores, verificando si es bipartito). Se tomo como punto de
 * partida las referencias dadas en la guia del laboratorio 6; enlace:
 * http://bit.ly/2lOsQFZ
 *
 * @author Alejandro Cano Munera
 * @author Sebastian Giraldo Gomez
 *
 * @version Febrero 2018
 */
public class Coloracion {

    /**
     * Metodo crearMatriz. Este metodo crear una matriz e ingresa los arcos
     * dados. El primer entero que se recive es el tamaño de la matriz, el
     * siguiente numero es el numero de arcos y los que le siguen es la sucesion
     * de pares de nodos entre los cuales iran los arcos.
     *
     * @return se retorna la matriz creada.
     */
    public static int[][] crearMatriz() {
        Scanner lect = new Scanner(System.in);
        int n = lect.nextInt();
        int[][] matriz = new int[n][n];
        int m = lect.nextInt();
        int a;
        int b;
        for (int i = 0; i < m; i++) {
            a = lect.nextInt();
            b = lect.nextInt();
            matriz[a][b] = 1;
        }
        return matriz;
    }

    /**
     * Metodo coloreable. Este metodo recive un grafo y determina si se puede
     * colorear usando solo dos colores (En el fondo determina si es bipartito)
     *
     * @param grafo Es el grafo que se va a evaluar.
     * @param pos Es la posicion del grafo desde la cual se comienza.
     */
    public static void coloreable(int grafo[][], int pos) {
        int vertices = grafo.length;
        int colores[] = new int[vertices];
        for (int i = 0; i < vertices; ++i) {
            colores[i] = -1;
        }
        colores[pos] = 1;
        LinkedList<Integer> lista = new LinkedList<>();
        lista.add(pos);
        while (!lista.isEmpty()) {
            int a = lista.poll();
            if (grafo[a][a] == 1) {
                System.out.println("NOT BICOLORABLE.");
                return;
            }
            for (int b = 0; b < vertices; ++b) {
                if (grafo[a][b] == 1 && colores[b] == -1) {
                    colores[b] = 1 - colores[a];
                    lista.add(b);
                } else if (grafo[a][b] == 1 && colores[b] == colores[a]) {
                    System.out.println("NOT BICOLORABLE.");
                    return;
                }
            }
        }
        System.out.println("BICOLORABLE.");
    }

    /**
     * Metodo main. Aqui se realizan las pruebas del algoritmo.
     *
     * @param args
     */
    public static void main(String[] args) {
        //Prueba para los tres test planteados.
        for (int i = 0; i < 3; i++) {
            int[][] n = crearMatriz();
            coloreable(n, 0);
        }
    }

}
