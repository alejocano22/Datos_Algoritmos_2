package lab01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Laboratorio 1 Punto 1.4. Clase LeerTxt. En esta clase se lee el txt del mapa
 * de Medellin y se indexa en un treeMap se utiliza la clase vertice para
 * guardar la informacion..
 *
 * @author Alejandro Cano Munera
 * @author Sebastian Giraldo Gomez
 *
 * @version Febrero 2018
 */
public class LeerTxt {

    TreeMap arb = new TreeMap();

    /**
     * Metodo leerTxt. el cual leer el txt del mapa de Medellin.
     *
     * @throws FileNotFoundException
     */
    public void leerTxt() throws FileNotFoundException {
        int c = 0;
        String l;
        String us;
        try {
            Scanner lec = new Scanner(new FileReader(new File("medellin_colombia-grande.txt")));
            us = lec.next();
            us = lec.next();
            us = lec.next();
            us = lec.next();
            us = lec.next();
            us = lec.next();
            while (lec.hasNext()) {
                l = lec.next();
                while (c < 4) {
                    String[] arr = new String[4];
                    arr[0] = lec.next();
                    arr[1] = lec.next();
                    arr[2] = lec.next();
                    arr[3] = lec.next();
                    arb.put(arr[0], new Vertice(arr[1], arr[2], arr[3]));
                    c++;
                }
                c = 0;
            }
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        LeerTxt a = new LeerTxt();
        a.leerTxt();
    }
}
