

import java.util.ArrayList;


public class Test {

    public static void main(String[] args) {
    
        System.out.println("Recorrido greedy -> " + convert(testRecorrido()));
    }

   

    static boolean testRecorrido() {
        GreedyTraveling bor = new GreedyTraveling();
        DigraphAL g1 = new DigraphAL(5);
        g1.addArc(0, 1, 2);
        g1.addArc(0, 2, 2);
        g1.addArc(0, 3, 1);
        g1.addArc(0, 4, 4);
        g1.addArc(1, 0, 2);
        g1.addArc(1, 2, 3);
        g1.addArc(1, 3, 2);
        g1.addArc(1, 4, 3);
        g1.addArc(2, 0, 2);
        g1.addArc(2, 1, 3);
        g1.addArc(2, 3, 2);
        g1.addArc(2, 4, 2);
        g1.addArc(3, 0, 1);
        g1.addArc(3, 1, 2);
        g1.addArc(3, 2, 2);
        g1.addArc(3, 4, 4);
        g1.addArc(4, 0, 4);
        g1.addArc(4, 1, 3);
        g1.addArc(4, 2, 2);
        g1.addArc(4, 3, 4);
        if (bor.recorrido(g1) != 12) {
            return false;
        }

        DigraphAL g2 = new DigraphAL(4);
        g2.addArc(0, 2, 15);
        g2.addArc(2, 0, 15);
        g2.addArc(0, 3, 20);
        g2.addArc(3, 0, 20);
        g2.addArc(0, 1, 10);
        g2.addArc(1, 0, 10);
        g2.addArc(3, 1, 25);
        g2.addArc(1, 3, 25);
        g2.addArc(3, 2, 30);
        g2.addArc(2, 3, 30);
        g2.addArc(1, 2, 35);
        g2.addArc(2, 1, 35);
        g2.addArc(0, 0, 0);
        g2.addArc(1, 1, 0);
        g2.addArc(2, 2, 0);
        g2.addArc(3, 3, 0);
        dibujarGrafo(g2);
        if (bor.recorrido(g2) != 80) {
            return false;
        }

        DigraphAL g3 = new DigraphAL(4);
        g3.addArc(0, 0, 0);
        g3.addArc(0, 1, 7);
        g3.addArc(0, 2, 15);
        g3.addArc(0, 3, 6);
        g3.addArc(1, 0, 2);
        g3.addArc(1, 1, 0);
        g3.addArc(1, 2, 7);
        g3.addArc(1, 3, 3);
        g3.addArc(2, 0, 9);
        g3.addArc(2, 1, 6);
        g3.addArc(2, 2, 0);
        g3.addArc(2, 3, 12);
        g3.addArc(3, 0, 10);
        g3.addArc(3, 1, 4);
        g3.addArc(3, 2, 8);
        g3.addArc(3, 3, 0);
        return bor.recorrido(g3) == 26;

    }

    static String convert(boolean b) {
        return b ? "correcta" : "incorrecta";
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