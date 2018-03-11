/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab03;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class Ciclos {

    public static void main(String[] args) {
        DigraphAL g = new DigraphAL(10);
        Ciclos l3 = new Ciclos();
        l3.fillGraph(g);
        System.out.println(l3.tieneCiclos(g));

    }

    public void fillGraph(Digraph g) {
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

    }
    private void add(Digraph g, int a, int b) {
		g.addArc(a, b, 1);
		g.addArc(b, a, 1);
	}

    public boolean tieneCiclos(Digraph g) {

        for (int i = 0; i < g.size(); i++) {
            ArrayList<Integer> ar = BFS.bfs(g, i);
            for (int j = 1; j < ar.size(); j++) {
                if (BFS.bfs(g, ar.get(j)).contains(i)) {
                    return true;
                }
            }
        }
        return false;
    }
}
