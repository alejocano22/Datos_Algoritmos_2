package lab03;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Laboratorio 3. Punto 1.3. Implementacion del algoritmo de recorrido BFS
 *
 * @author Alejandro Cano Munera
 * @author Sebastian Giraldo Gomez
 *
 * @version Marzo 2018
 */
public class BFS {

    /**
     * Metodo bfs. Realiza el recorrido de un grafo en BFS.
     *
     * @param g Es el grafo a recorrer.
     * @param inicio Es el nodo desde donde se va a iniciar el recorrido.
     * @return Se retorna un ArrayList con el camino del recorrido.
     */
    public static ArrayList<Integer> bfs(Digraph g, int inicio) {
        ArrayList<Integer> camino = new ArrayList<>();
        boolean[] visitados = new boolean[g.size()];
        Queue<Integer> vecinos = new LinkedList<>();
        camino.add(inicio);
        vecinos.add(inicio);
        visitados[inicio] = true;
        while (!vecinos.isEmpty()) {
            int actual = vecinos.poll();
            ArrayList<Integer> sucesores = g.getSuccessors(actual);
            if (sucesores != null) {
                if (!verificarSucesores(visitados, sucesores)) {
                    for (int i = 0; i < sucesores.size(); i++) {
                        vecinos.add(sucesores.get(i));
                        if (!visitados[sucesores.get(i)]) {
                            camino.add(sucesores.get(i));
                        }
                        visitados[sucesores.get(i)] = true;
                    }
                }
            }
        }
        return camino;
    }

    /**
     * Metodo verificar sucesores. Este metodo verifica si los sucesores de
     * determinado nodo ya estan visitados
     *
     * @param visitados Es el arreglo booleano que indica que nodos estan ya
     * visitados.
     * @param sucesores Es un ArrayList de los sucesores de determinado nodo
     * @return Se retorna true si todos los nodos ya han sido visitados, se
     * retorna false si almenos un nodo no ha sido visitado.
     */
    public static boolean verificarSucesores(boolean[] visitados, ArrayList<Integer> sucesores) {
        for (int i = 0; i < sucesores.size(); i++) {
            if (!visitados[sucesores.get(i)]) {
                return false;
            }
        }
        return true;
    }
    
}
