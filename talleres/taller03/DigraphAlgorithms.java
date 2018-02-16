package taller3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Taller3. Clase DigraphAlgorithms. This class contains algorithms for digraphs
 * Adapted from: http://cs.fit.edu/~ryan/java/programs/graph/Dijkstra-java.html
 * La plantilla de esta clase fue tomada del Github del docente Mauricio Toro,
 * en el siguiente enlace:
 * https://github.com/mauriciotoro/ST0247-Eafit/tree/master/laboratorios/lab01
 *
 * @author Alejandro Cano Munera
 * @author Sebastian Giraldo Gomez
 *
 * @version Febrero 2018
 */
public class DigraphAlgorithms {

    /**
     * Metodo sucesores. Este metodo determina cual es el vertice del grafo que
     * tiene mas sucesores en total.
     *
     * @param graph Es el grafo el cual se evaluara y donde se buscara el
     * vertice con mas sucesores.
     * @return Se retorna el vertice con mas sucesores dentro de grafo.
     */
    public static int sucesores(Graph graph) {
        int maximo = 0;
        int vertice = 0;
        if (graph instanceof DigraphAL) {
            DigraphAL grafo = (DigraphAL) graph;
            for (int i = 0; i < grafo.list.size(); i++) {
                int suc = grafo.list.get(i).size();
                if (suc > maximo) {
                    vertice = i;
                }
            }
            return vertice;
        } else {
            DigraphAM grafo = (DigraphAM) graph;
            for (int i = 0; i < grafo.matriz.length; i++) {
                int suc = grafo.getSuccessors(i).size();
                if (suc > maximo) {
                    vertice = i;
                }
            }
            return vertice;
        }
    }

    /**
     * Metodo minVertex. Este metodo fue incluido en la plantilla dada por el
     * docente.
     *
     * @param dist Es un arreglo de enteros.
     * @param v Es un arreglo de booleanos
     * @return se retorna un valor entero.
     */
    private static int minVertex(int[] dist, boolean[] v) {
        int x = Integer.MAX_VALUE;
        int y = -1;   // graph not connected, or no unvisited vertices
        for (int i = 0; i < dist.length; i++) {
            if (!v[i] && dist[i] < x) {
                y = i;
                x = dist[i];
            }
        }
        return y;
    }

    /**
     *
     * Metodo dijsktra. Este metodo fue incluido en la plantilla dada por el
     * docente.
     *
     * @param dg Es el grafo a recorrer
     * @param source Es el nodo de salida del grafo
     * @return Se retorna un arreglo con las posiciones a recorrer.
     */
    static int[] dijsktra(Graph dg, int source) {
        final int[] dist = new int[dg.size()];  // shortest known distance from "s"
        final int[] pred = new int[dg.size()];  // preceeding node in path
        final boolean[] visited = new boolean[dg.size()]; // all false initially

        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE; //Infinity
        }
        dist[source] = 0;

        for (int i = 0; i < dist.length; i++) {
            final int next = minVertex(dist, visited);
            visited[next] = true;

            // The shortest path to next is dist[next] and via pred[next].
            final ArrayList<Integer> n = dg.getSuccessors(next);
            for (int j = 0; j < n.size(); j++) {
                final int v = n.get(j);
                final int d = dist[next] + dg.getWeight(next, v);
                if (dist[v] > d) {
                    dist[v] = d;
                    pred[v] = next;
                }
            }
        }
        return pred;  // (ignore pred[s]==0!)
    }

    /**
     * Metodo getPath. Este metodo fue incluido en la plantilla dada por el
     * docente.
     *
     * @param pred Es un arreglo de enteros
     * @param s Es un valor entero
     * @param e Es un valor entero
     * @return Se retorna un ArrayList.
     */
    public static ArrayList getPath(int[] pred, int s, int e) {
        final java.util.ArrayList path = new java.util.ArrayList();
        int x = e;
        while (x != s) {
            path.add(0, x);
            x = pred[x];
        }
        path.add(0, s);
        return path;
    }

    // Codigo para dibujar el grafo en GraphViz
    // Recomiendo www.webgraphviz.com/
    /**
     * Metodo dibujarGrafo. Este metodo fue incluido en la plantilla dada por el
     * docente.
     *
     * @param g Es el grafo a ser dibujado.
     */
    public static void dibujarGrafo(Graph g) {
        System.out.println("digraph Grafo {");
        System.out.println("node [color=cyan, style=filled];");
        int nv = g.size();
        for (int i = 0; i < nv; i++) {
            ArrayList<Integer> lista = g.getSuccessors(i);
            for (int j = 0; j < lista.size(); j++) {
                System.out.println("\"" + i + "\" -> \"" + lista.get(j) + "\" [ label=\"" + g.getWeight(i, lista.get(j)) + "\"];");
            }
        }
        System.out.println("}");
    }

    //algoritmo DFS   
    /**
     * Nota. El siguiente codigo sobre el cual se desarrolla el algoritmo de
     * recorrido en profundidad DFS, fue tomado, adaptado y analizado de la
     * siguiente pagina web: https://java2blog.com/depth-first-search-in-java/
     */
    static class Node {

        int data;
        boolean visited;
        List<Node> neighbours;

        Node(int data) {
            this.data = data;
            this.neighbours = new ArrayList<>();

        }

        public void addneighbours(Node neighbourNode) {
            this.neighbours.add(neighbourNode);
        }

        public List<Node> getNeighbours() {
            return neighbours;
        }

        public void setNeighbours(List<Node> neighbours) {
            this.neighbours = neighbours;
        }
    }

    // Recursive DFS
    public void dfs(Node node) {
        System.out.print(node.data + " ");
        List<Node> neighbours = node.getNeighbours();
        node.visited = true;
        for (int i = 0; i < neighbours.size(); i++) {
            Node n = neighbours.get(i);
            if (n != null && !n.visited) {
                dfs(n);
            }
        }
    }

    // Iterative DFS using stack
    public void dfsUsingStack(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.add(node);
        node.visited = true;
        while (!stack.isEmpty()) {
            Node element = stack.pop();
            System.out.print(element.data + " ");

            List<Node> neighbours = element.getNeighbours();
            for (int i = 0; i < neighbours.size(); i++) {
                Node n = neighbours.get(i);
                if (n != null && !n.visited) {
                    stack.add(n);
                    n.visited = true;

                }
            }
        }
    }

    //Final codigo refereniado
    /**
     * Mrtodo main. Aqui se realizan las pruebas de las implementaciones.
     *
     * @param args
     */
    public static void main(String[] args) {
        DigraphAL dgal = new DigraphAL(5);
        dgal.addArc(0, 1, 10);
        dgal.addArc(0, 2, 3);
        dgal.addArc(1, 2, 1);
        dgal.addArc(1, 3, 2);
        dgal.addArc(2, 1, 4);
        dgal.addArc(2, 3, 8);
        dgal.addArc(2, 4, 2);
        dgal.addArc(3, 4, 7);
        dgal.addArc(4, 3, 9);

        System.out.println(getPath(dijsktra(dgal, 0), 0, 3));

        DigraphAM dgam = new DigraphAM(5);
        dgam.addArc(0, 1, 10);
        dgam.addArc(0, 2, 3);
        dgam.addArc(1, 2, 1);
        dgam.addArc(1, 3, 2);
        dgam.addArc(2, 1, 4);
        dgam.addArc(2, 3, 8);
        dgam.addArc(2, 4, 2);
        dgam.addArc(3, 4, 7);
        dgam.addArc(4, 3, 9);

        System.out.println(getPath(dijsktra(dgam, 0), 0, 3));

        DigraphAlgorithms.dibujarGrafo(dgal);

    }
}
