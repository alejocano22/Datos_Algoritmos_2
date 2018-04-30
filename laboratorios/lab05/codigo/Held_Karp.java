package lab05;

/**
 * Laboratorio 5. Punto 1.2. Clase Held_Karp. Clase en la cual se implementan
 * los metodos del algoritmo de Held-Karp. La implementacion de el algoritmo de
 * Held-Karp fue tomada y modificada (Para su debido analizis) del siguiente
 * repositorio en gitHub: https://github.com/Sinclert/Heuristics-TSP
 *
 * @author Alejandro Cano Munera
 * @author Sebastian Giraldo Gomez
 *
 * @version Abril 2017
 */
/**
 * Algoritmo de Held-Karp.
 *
 * @author Alejandro Cano Munera
 * @author Sebastián Giraldo Gómez
 *
 * @version Abril 2018
 */
public class Held_Karp {

    private int[][] distancias;
    private int distanciaOptima = Integer.MAX_VALUE;
    private String camino = "";

    public Held_Karp() {
    }

    public int heldKarp(Graph g) {
        int size = g.size;
        distancias = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int col = 0; col < size; col++) {
                distancias[i][col] = g.getWeight(i, col);
            }
        }
        String recorrido = "";
        int[] vertices = new int[g.size - 1];
        for (int i = 1; i < size; i++) {
            vertices[i - 1] = i;
        }
        int result = heldKarpAux(0, vertices, recorrido, 0);
        System.out.println(result);
        System.out.println(camino);
        return result;
    }

    private int heldKarpAux(int inicio, int vertices[], String recorrido, int costoAqui) {
        recorrido = recorrido + Integer.toString(inicio) + " - ";
        int longitud = vertices.length;
        int nuevoCostoAqui;
        if (longitud == 0) {
            nuevoCostoAqui = costoAqui + distancias[inicio][0];
            if (nuevoCostoAqui < distanciaOptima) {
                distanciaOptima = nuevoCostoAqui;
                camino = recorrido + "0";
            }
            return (distancias[inicio][0]);
        } else if (costoAqui > distanciaOptima) {
            return 0;
        } else {
            int[][] nuevosVertices = new int[longitud][(longitud - 1)];
            int costoNodoAct, menorCosto;
            int mejorCosto = Integer.MAX_VALUE;
            for (int i = 0; i < longitud; i++) {
                for (int j = 0, k = 0; j < longitud; j++, k++) {
                    if (j == i) {
                        k--;
                        continue;
                    }
                    nuevosVertices[i][k] = vertices[j];
                }
                costoNodoAct = distancias[inicio][vertices[i]];
                nuevoCostoAqui = costoNodoAct + costoAqui;
                menorCosto = heldKarpAux(vertices[i], nuevosVertices[i], recorrido, nuevoCostoAqui);
                int totalCost = menorCosto + costoNodoAct;
                if (totalCost < mejorCosto) {
                    mejorCosto = totalCost;
                }
            }
            return mejorCosto;
        }
    }
}
