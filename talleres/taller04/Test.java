
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.HashSet;

/**
 * Prueba las implementaciones de DigraphAM .
 *
 * Ejecute esta clase luego de completar las clases DigraphAL y DigraphAM para
 * tener una idea de si su implementación está correcta.
 *
 * @author Mateo Agudelo
 */
public class Test {

    static final int SIZE = 12;
    static HashSet<Pair<Integer, Integer>> edges;
    static ArrayList<Pair<Integer, Integer>> caminos;
    static int[] sinEntradas = {0, 1, 3, 4, 5, 6, 7};

    public static void main(String[] args) {
        edges = fillEdges();

        DigraphAM gMatrix = new DigraphAM(SIZE);
        fillGraph(gMatrix);
        System.out.println("BFS");
        System.out.print("Lista de nodos que se pueden visitar desde 3, usando BFS: ");
        gMatrix.impListaBFS(gMatrix.matriz, 3);
        System.out.println("¿Se puede ir de el nodo 3 a el 10?");
        System.out.println(gMatrix.canGoToBFS(3, 10));
        System.out.println("¿Se puede ir de el nodo 2 a el 10?");
        System.out.println(gMatrix.canGoToBFS(2, 10));
        gMatrix.bfsCheaper(gMatrix.matriz, 3, 10);

        System.out.println("DFS");
        System.out.print("Lista de nodos que se pueden visitar desde 3, usando DFS: ");
        gMatrix.impListaDFS(gMatrix.matriz, 3);
        System.out.println("¿Se puede ir de el nodo 3 a el 10?");
        System.out.println(gMatrix.canGoToDFS(3, 10));
        System.out.println("¿Se puede ir de el nodo 2 a el 10?");
        System.out.println(gMatrix.canGoToDFS(2, 10));
        gMatrix.dfsCheaper(gMatrix.matriz, 3, 10);
        dibujarGrafo(gMatrix);

    }

    static HashSet<Pair<Integer, Integer>> fillEdges() {
        HashSet<Pair<Integer, Integer>> edges = new HashSet<>();
        edges.add(Pair.makePair(3, 8));
        edges.add(Pair.makePair(3, 10));
        edges.add(Pair.makePair(5, 11));
        edges.add(Pair.makePair(7, 8));
        edges.add(Pair.makePair(7, 11));
        edges.add(Pair.makePair(8, 9));
        edges.add(Pair.makePair(11, 2));
        edges.add(Pair.makePair(11, 9));
        edges.add(Pair.makePair(11, 10));
        return edges;
    }

    static boolean fillGraph(Digraph g) {
        if (edges == null || g == null) {
            return false;
        }
        for (Pair<Integer, Integer> p : edges) {
            g.addArc(p.first, p.second, 1);

        }
        return true;
    }

    /**
     * Metodo para dibujar un grafo en la herramienta:
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
