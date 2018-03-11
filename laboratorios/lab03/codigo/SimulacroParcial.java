package lab03;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Laboratorio 3. Punto 4. Simulacros de parcial. En esta clase se encuentran los puntos del simulacro
 * de parcial con el fin de verificar si se habian solucionado correctamente.
 *
 * @author Alejandro Cano Munera
 * @author Sebastian Giraldo Gomez
 *
 * @version Marzo 2018
 */
public class SimulacroParcial {

    public static void main(String[] args) {
        System.out.println("Laboratorio 03: \nSimulacro de parcial");
        System.out.println("Punto 1: ");
        System.out.println(solucionar(14, 3, 2, 7));
        //Grafo completo con matrices de adyacencia.
        int[][] graph = {{0, 1, 1, 1},
        {1, 0, 1, 1},
        {1, 1, 0, 1},
        {1, 1, 1, 0}};

        System.out.println("Punto 2: ");
        System.out.println(cicloHamil(graph));

        System.out.println("Punto 4: ");
        DigraphAL g1 = new DigraphAL(8);
        g1.addArc(0, 3, 1);
        g1.addArc(0, 4, 1);
        g1.addArc(1, 0, 1);
        g1.addArc(1, 2, 1);
        g1.addArc(1, 5, 1);
        g1.addArc(2, 1, 1);
        g1.addArc(2, 4, 1);
        g1.addArc(2, 6, 1);
        g1.addArc(3, 7, 1);
        g1.addArc(4, 2, 1);
        g1.addArc(6, 2, 1);
        System.out.println("Camino de 0 a 6: " + printCamino(unCamino(g1, 0, 6)));
        System.out.println("Camino de 6 a 7: " + printCamino(unCamino(g1, 6, 7)));

        System.out.println("Punto 5: ");
        System.out.println("“ABCDGH” y “AEDFHR”: " + lcs("ABCDGH", "AEDFHR"));  //"ADH" 3
        System.out.println("“AGGTAB” y “GXTXAYB”: " + lcs("AGGTAB", "GXTXAYB")); //"GTAB" 4

    }

    //Punto 1.
    static int solucionar(int n, int a, int b, int c) {
        if (n <= 0) {
            return 0;
        }
        int res = solucionar(n - a, a, b, c) + 1;
        res = Math.max(res, solucionar(n - b, a, b, c) + 1);
        res = Math.max(res, solucionar(n - c, a, b, c) + 1);
        return res;
    }

    //Punto 2.
    static boolean cicloHamil(int graph[][]) {
        int[] path = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            path[i] = -1;
        }
        path[0] = 0;
        return cicloHamilAux(graph, path, 1);
    }

    static boolean sePuede(int v, int graph[][], int path[], int pos) {
        if (graph[path[pos - 1]][v] == 0) {
            return false;
        }
        for (int i = 0; i < pos; i++) {
            if (path[i] == v) {
                return false;
            }
        }
        return true;
    }

    static boolean cicloHamilAux(int graph[][], int path[], int pos) {
        if (pos == graph.length - 1) {
            return graph[path[pos - 1]][path[0]] == 1;
        }
        for (int v = 1; v < graph.length; v++) {
            if (sePuede(v, graph, path, pos)) {
                path[pos] = v;
                if (cicloHamilAux(graph, path, pos + 1)) {
                    return true;
                }
                path[pos] = -1;
            }
        }
        return false;
    }

    //Punto 4.  
    public static LinkedList<Integer> unCamino(Digraph g, int p, int q) {
        boolean[] visitados = new boolean[g.size()];
        LinkedList<Integer> camino = new LinkedList<>();
        camino.add(p);
        if (unCaminoAux(g, p, q, visitados, camino)) {
            return camino;
        }
        return null;

    }

    private static boolean unCaminoAux(Digraph g, int vert, int targ, boolean[] visitados, LinkedList<Integer> camino) {
        ArrayList<Integer> sucesores = g.getSuccessors(vert);
        visitados[vert] = true;
        if (sucesores != null) {
            for (Integer sucesor : sucesores) {
                camino.addLast(sucesor);
                if (!visitados[sucesor] && (sucesor == targ || unCaminoAux(g, sucesor, targ, visitados, camino))) {
                    return true;
                } else {
                    camino.removeLast();
                }
            }
        }
        return false;
    }

    public static String printCamino(LinkedList<Integer> camino) {
        if (camino == null) {
            return "null";
        } else {
            return "Camino: " + camino.toString();
        }
    }

    //Punto 5.
    private static int lcs(int i, int j, String s1, String s2) {
        if (i == -1 || j == -1) {
            return 0;
        }
        boolean prev = i < s1.length() && j < s2.length();
        if (prev && s1.charAt(i) == s2.charAt(j)) {
            return 1 + lcs(i - 1, j - 1, s1, s2);
        }
        int ni = lcs(i - 1, j, s1, s2);
        int nj = lcs(i, j - 1, s1, s2);
        return Math.max(ni, nj);
    }

    public static int lcs(String s1, String s2) {
        return lcs(s1.length(), s2.length(), s1, s2);
    }

    /**
     * Metodo para dibujar un grafo en la siguiente pagina:
     * http://www.webgraphviz.com/
     *
     * @param g Es el grafo a dibujar
     */
    public static void dibujarGrafo(Digraph g) {
        System.out.println("digraph Grafo {");
        System.out.println("node [color=cyan, style=filled];");
        int nv = g.size();
        for (int i = 0; i < nv; i++) {
            ArrayList<Integer> lista = g.getSuccessors(i);
            if (lista != null) {
                for (int j = 0; j < lista.size(); j++) {
                    System.out.println("\"" + i + "\" -> \"" + lista.get(j) + "\" [ label=\"" + g.getWeight(i, lista.get(j)) + "\"];");
                }
            }

        }
        System.out.println("}");
    }
}
