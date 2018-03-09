
import java.util.ArrayList;

/**
 * Taller 6. Punto 2. Vecino más cercano.
 *
 * @author Alejandro Cano Munera
 * @author Sebastián Giraldo Gómez
 *
 * @version Marzo 2018
 */
public class NearestNeighbor {

    /**
     * Metodo recorrido. El cual se utiliza para invocar el metodo recorridoAux
     * y darle los parametros iniciales.
     *
     * @param g Es el grafo a recorrer
     * @return Se retorna el camino entre los nodos.
     */
    public int recorrido(DigraphAL g) {
        boolean[] a = new boolean[g.size];
        return recorridoAux(g, 0, a, 0);
    }

    /**
     * Metodo recorridoAux. Este metodo mediante recursion determina el camino
     * posiblemente mas rapido que describe un circuito hamiltoniano, utilizando
     * algoritmos boraces.
     *
     * @param g Es el grafo a recorrer
     * @param ver Es el vertice actual
     * @param vis Es el arreglo de vertices visitados
     * @param way Es el camino recorrido
     * @return Se retorna el camino total entre los nodos.
     */
    public int recorridoAux(DigraphAL g, int ver, boolean[] vis, int way) {
        if (comprobar(vis)) {
            return way;
        } else {
            ArrayList<Integer> suc = g.getSuccessors(ver);
            int min = suc.get(0);
            int valorM = Integer.MAX_VALUE;
            for (int i = 0; i < suc.size(); i++) {
                if (!vis[suc.get(i)]) {
                    int w = g.getWeight(ver, suc.get(i));
                    if (ver != suc.get(i)) {
                        if (w < valorM) {
                            min = suc.get(i);
                            valorM = w;
                        }
                    }

                }
            }
            //Ultimo valor.
            if (valorM == Integer.MAX_VALUE) {
                valorM = g.getWeight(ver, suc.get(0));
            }
            vis[ver] = true;
            way += valorM;
            return recorridoAux(g, min, vis, way);
        }
    }

    /**
     * Metodo comprobar. Este metodo recive un arreglo de tipo booleano y
     * verifica si este tiene todos sus elementos en true.
     *
     * @param a Es el arreglo booleano
     * @return Se retorna true sin todos los elementos del arreglo son true, y
     * se retorna false si almenos un elemento del arreglo es false.
     */
    public boolean comprobar(boolean[] a) {
        for (int i = 0; i < a.length; i++) {
            if (!a[i]) {
                return false;
            }
        }
        return true;
    }
}
