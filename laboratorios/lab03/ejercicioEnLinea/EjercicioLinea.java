/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab03;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Laboratorio 3. Punto 2.1. Ejercicio en línea
 *
 * @author Alejandro Cano Munera
 * @author Sebastian Giraldo Gomez
 *
 * @version Marzo 2018
 */
public class EjercicioLinea {
     public static void main(String[] args) {
        EjercicioLinea l3 = new EjercicioLinea();
        System.out.println(l3.leerGrafo().toString());
    }

    public ArrayList<Integer> leerGrafo() {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b[] = a.split(" ");
        DigraphAL g = new DigraphAL(Integer.parseInt(b[0]),1);
        for (int i = 0; i < Integer.parseInt(b[1]); i++) {
            String c = sc.nextLine();
            String[] d = c.split(" ");
            g.addArc(Integer.parseInt(d[0]), Integer.parseInt(d[1]), Integer.parseInt(d[2]));
        }

        return parcialMc(g, 1,g.size );
    }

    public ArrayList<Integer> parcialMc(DigraphAL g, int start, int finish) {
        ArrayList<Integer> ar = new ArrayList<>();
        return parcialMcAux(g, start,  ar, finish);
    }

    public ArrayList<Integer> parcialMcAux(DigraphAL g, int ver, ArrayList<Integer> ar, int finish) {
        System.out.println(ver+" "+finish);
        if (ver == finish) {
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
            ar.add(ver);
            return parcialMcAux(g, min,  ar, finish);
        }
    }

}
