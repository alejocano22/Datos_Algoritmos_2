/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab03;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author ASUS
 */
public class CaminoCorto {
    public static void main(String[] args) {
         DigraphAL g1 = new DigraphAL(5);
         CaminoCorto c=new CaminoCorto();
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
        System.out.println("El camino más corto es de "+c.recorridoCorto(g1,0,3));
          
    }
    /**
     * Metodo recorrido. El cual se utiliza para invocar el metodo recorridoAux
     * y darle los parametros iniciales.
     *
     * @param g Es el grafo a recorrer
     * @return Se retorna el camino entre los nodos.
     */
 

     public ArrayList<Integer> recorridoCorto(DigraphAL g, int start, int finish) {
        ArrayList<Integer> ar = new ArrayList<>();
        return parcialMcAux(g, start,  ar, finish,0);
    }

    public ArrayList<Integer> parcialMcAux(DigraphAL g, int ver, ArrayList<Integer> ar, int finish,int way) {
        System.out.println(ver+" "+finish);
        if (ver == finish) {
            System.out.println("El peso del camino es: "+way);
            ar.add(ver);
            return ar;
        } else {
            ArrayList<Integer> suc = g.getSuccessors(ver);
            int min = suc.get(0);
            int valorM = Integer.MAX_VALUE;
            for (int i = 0; i < suc.size(); i++) {
                
                    int w = g.getWeight(ver, suc.get(i));
                    if (ver != suc.get(i)) {
                        if (w < valorM) {
                            min = suc.get(i);
                            valorM = w;
                        }
                    }

                
            }
            //Ultimo valor.
            if (valorM == Integer.MAX_VALUE) {
                valorM = g.getWeight(ver, suc.get(0));
            }
            way+=valorM;
            ar.add(ver);
            return parcialMcAux(g, min,  ar, finish,way);
        }
    }
}
