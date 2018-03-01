
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author cl18417
 */
public class Taller4 {

   

    public boolean mColoring(Digraph g, int v, int m) {
        ArrayList<String> perm = new ArrayList<>();
        String gg ="";
        for (int i = 1; i < m; i++) {
            gg+=i+"";
        }
        printAll(gg, m, "", perm);
        for (int i = 0; i < perm.size(); i++) {
            String[] col = perm.get(i).split("");
            if (!isSafe(g, v, col, Integer.parseInt(col[v]))) {
                return false;
            }
        }
        return true;
    }

    public boolean isSafe(Digraph g, int v, String[] colors, int c) {
        ArrayList<Integer> successors = g.getSuccessors(v);
        if (successors != null) {
            for (Integer vecino : successors) {
                if (Integer.parseInt(colors[vecino]) == c) {
                    return false;
                }
                return isSafe(g, vecino, colors, Integer.parseInt(colors[vecino]));
            }
        }
        return true;
    }

    public void printAll(String c, int n, String start, ArrayList<String> res) {
        if (start.length() >= n) {
            res.add(start);
        } else {
            for (int i = 0; i < c.length(); i++) { // not a valid syntax in Java
                printAll(c, n, start + c.charAt(i), res);
            }
        }
    }

}
