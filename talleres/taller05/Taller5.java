
import java.util.ArrayList;

/**
 * Taller 5. Solucion del problema de colorear un grafo con n colores utilizando
 * backTraking
 *
 * @author Alejandro Cano Munera
 * @author Sebastian Giraldo Gomez
 * 
 * @version Marzo 2018
 */
public class Taller5 {

    boolean help = false;

    public void mColoring(Digraph g, int v, int m) {
        ArrayList<String> perm = new ArrayList<>();
        String gg = "";
        for (int i = 1; i <= m; i++) {
            gg += i + "";
        }
        printAll(gg, g.size, "", perm, g, v, m);
    }

    public boolean isSafe(Digraph g, int v, String[] colors, int c, String nodes) {
        nodes += v;
        ArrayList<Integer> successors = g.getSuccessors(v);
        if (successors != null) {
            for (Integer vecino : successors) {
//                System.out.println(vecino);

                if (Integer.parseInt(colors[vecino]) == c) {
                    return false;
                }
                if (!nodes.contains(vecino + "")) {
                    return isSafe(g, vecino, colors, Integer.parseInt(colors[vecino]), nodes);
                }
            }
        }
        System.out.println("¡Hay una forma de colorear el grafo!");

        return true;
    }

    public void printAll(String c, int n, String start, ArrayList<String> res, Digraph g, int v, int m) {
        if (!help) {
            if (start.length() >= n) {
                String[] col = start.split("");
                if (isSafe(g, v, col, Integer.parseInt(col[v]), "")) {
                    help = true;
                }

            } else {
                for (int i = 0; i < c.length() && !help; i++) {
                    printAll(c, n, start + c.charAt(i), res, g, v, m);
                }
            }
        }
    }

}
