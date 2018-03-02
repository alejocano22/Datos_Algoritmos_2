
import java.util.ArrayList;

/**
 * Prueba las implementaciones de DigraphAL y DigraphAM con el grafo del
 * documento.
 *
 * Ejecute esta clase luego de completar las clases DigraphAL y DigraphAM para
 * tener una idea de si su implementación está correcta.
 *
 * @author Mateo Agudelo
 */
public class Test {

    public static void main(String[] args) {
        Test tt = new Test();
        Digraph ga = new DigraphAL(10);

        tt.testColoring(ga);
//                dibujarGrafo(ga);
    }

    public boolean testColoring(Digraph g) {
        add(g, 0, 1);
        add(g, 0, 2);
        add(g, 0, 5);
        add(g, 1, 0);
        add(g, 1, 6);
        add(g, 1, 7);
        add(g, 2, 3);
        add(g, 2, 8);
        add(g, 2, 0);
        add(g, 3, 2);
        add(g, 3, 4);
        add(g, 3, 7);
        add(g, 4, 3);
        add(g, 4, 5);
        add(g, 4, 6);
        add(g, 5, 0);
        add(g, 5, 4);
        add(g, 5, 9);
        add(g, 6, 1);
        add(g, 6, 4);
        add(g, 6, 8);
        add(g, 7, 1);
        add(g, 7, 3);
        add(g, 7, 9);
        add(g, 8, 2);
        add(g, 8, 6);
        add(g, 8, 9);
        add(g, 9, 5);
        add(g, 9, 7);
        add(g, 9, 8);
        Taller5 t4 = new Taller5();
        t4.mColoring(g, 0, 3);
        return false;

    }

    static void add(Digraph g, int a, int b) {
        g.addArc(a, b, 1);
        g.addArc(b, a, 1);
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
