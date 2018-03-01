/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cl18417
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

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
	static final int SIZE = 12;
	static HashSet<Pair<Integer, Integer>> edges;
	static ArrayList<Pair<Integer, Integer>> caminos;
	static int[] sinEntradas = { 0, 1, 3, 4, 5, 6, 7 };

	public static void main(String[] args) {
		edges = fillEdges();
//
//		DigraphAM gMatrix = new DigraphAM(SIZE);
//		fillGraph(gMatrix);
//		System.out.println("DigraphAM (Matriz de Adyacencia):");
//		System.out.println("    getWeight() -> " + convert(testWeight(gMatrix)));
//		System.out.println("    getSuccesors() -> " + convert(testSuccesors(gMatrix)));
//		
//		dibujarGrafo(gMatrix);

		DigraphAL gList = new DigraphAL(SIZE);
		fillGraph(gList);
//		System.out.println("DigraphAL (Listas de Adyacencia):");
//		System.out.println("    getWeight() -> " + convert(testWeight(gList)));
//		System.out.println("    getSuccesors() -> " + convert(testSuccesors(gList)));
		Taller4 t=new Taller4();
                int []a = new int[gList.size];
                System.out.println(gList.size);
//                System.out.println(t.isSafe(gList, 3,a , 3));
//		dibujarGrafo(gList);
//		
System.out.println("Method");
                Test tt= new Test();
                Digraph ga= new DigraphAL(10);
                
                tt.testColoring(ga);
                dibujarGrafo(ga);
	}

	static HashSet<Pair<Integer, Integer>> fillEdges() {
		HashSet<Pair<Integer, Integer>> edges = new HashSet<>();
		edges.add(Pair.makePair(0, 1));
		edges.add(Pair.makePair(0, 2));
		edges.add(Pair.makePair(5, 11));
		edges.add(Pair.makePair(7, 8));
		edges.add(Pair.makePair(7, 11));
		edges.add(Pair.makePair(8, 9));
		edges.add(Pair.makePair(11, 2));
		edges.add(Pair.makePair(11, 9));
		edges.add(Pair.makePair(11, 10));
		return edges;
	}
        
        public boolean testColoring(Digraph g){
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
                Taller4 t4=new Taller4();
                System.out.println(t4.mColoring(g, 0, 3));
                return false;

        }
	static void add(Digraph g, int a, int b) {
		g.addArc(a, b, 1);
		g.addArc(b, a, 1);
	}
	static boolean fillGraph(Digraph g) {
		if (edges == null || g == null)
			return false;
		for (Pair<Integer, Integer> p : edges){
			g.addArc(p.first, p.second, 1);
                        
                }
		return true;
	}

	static boolean testWeight(Digraph g) {
		int w;
		for (int i = 0; i < SIZE; ++i)
			for (int j = 0; j < SIZE; ++j) {
				w = g.getWeight(i, j);
				if (edges.contains(Pair.makePair(i, j))) {
					if (w != 1)
						return false;
				} else {
					if (w != 0)
						return false;
				}
			}
		return true;
	}

	static boolean testSuccesors(Digraph g) {

		if (g.getSuccessors(0) != null){
			return false;}
		if (g.getSuccessors(1) != null)
			return false;
		if (g.getSuccessors(2) != null)
			return false;
		if (!g.getSuccessors(3).equals(new ArrayList<>(Arrays.asList(8, 10))))
			return false;
		if (g.getSuccessors(4) != null)
			return false;
		if (!g.getSuccessors(5).equals(new ArrayList<>(Arrays.asList(11))))
			return false;
		if (g.getSuccessors(6) != null)
			return false;
		if (!g.getSuccessors(7).equals(new ArrayList<>(Arrays.asList(8, 11))))
			return false;
		if (!g.getSuccessors(8).equals(new ArrayList<>(Arrays.asList(9))))
			return false;
		if (g.getSuccessors(9) != null)
			return false;
		if (g.getSuccessors(10) != null)
			return false;
		return g.getSuccessors(11).equals(new ArrayList<>(Arrays.asList(2, 9, 10)));
	}

       
        static String convert(boolean b) {
		return b ? "correcta" : "incorrecta";
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