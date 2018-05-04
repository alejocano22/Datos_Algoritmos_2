/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller12;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Taller 2. Fuerza Bruta.
 *
 * @author Alejandro Cano Munera
 * @author Sebastian Giraldo Gomez
 *
 * @version Febrero 2018
 */
public class Queens {

    //Pruebas
    public static void main(String[] args) {
        Queens t2 = new Queens();
        //Punto1
        System.out.println("Punto 1:");
        ArrayList<String> p1 = new ArrayList<>();
        t2.combinaciones("", "abc", p1);
        System.out.println("Cádena: abc");
        System.out.println(p1.toString());
        System.out.println("----------------------");
        //Punto 2
        System.out.println("Punto 2:");
        ArrayList<String> p2 = new ArrayList<>();
        t2.permutaciones("", "abc", p2);
        System.out.println("Cádena: abc");
        System.out.println(p2.toString());
        System.out.println("----------------------");
        //Punto 3
        System.out.println("Punto 3:");
        int n = 4;
        System.out.println("Para " + n);
        System.out.println("Combinaciones posibles: ");
        t2.queens(n);
    }

    //Punto 1
    public void combinaciones(String pre, String pos, ArrayList<String> arr) {
        if (pos.length() == 0) {
            arr.add(pre);
        } else {
            combinaciones(pre.concat(pos.charAt(0) + ""), pos.substring(1), arr);
            combinaciones(pre, pos.substring(1), arr);
        }
    }

    //Punto 2
    public void permutaciones(String b, String c, ArrayList<String> arr) {
        if (c.length() == 0) {
            arr.add(b);
        } else {
            for (int i = 0; i < c.length(); i++) {
                permutaciones(b.concat(c.charAt(i) + ""), c.substring(0, i) + c.substring(i + 1), arr);
            }
        }
    }

    /**
     * Metodo queensAux. Se utiliza para verificar las diferentes diagonales de
     * una reina.
     *
     * @param array Es el arreglo de reinas que se evaluara.
     * @return Se retorna el arreglo si es buena combinacion y null de lo
     * contrario.
     */
    public String[] queensAux(String[] array) {
        System.out.println(Arrays.toString(array));
        if (comprobar(array) && comprobar(voltear(array))) {
            return array;
        } else {
            return null;
        }
    }

    /**
     * Metodo comprobar. Este metodo se encarga de verificar las diagonales de
     * cada reina en el arreglo.
     *
     * @param array Es la posicion de las reinas en el tablero.
     * @return Se retorna verdadero si la reina esta bien ubicada, y falso de lo
     * contrario.
     */
    public static boolean comprobar(String[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int cont = 0; //Para llevar las posiciones
            int num = Integer.parseInt(array[i]);
            for (int j = i + 1; j < array.length; j++) {
                int comp = Integer.parseInt(array[j]);
                cont++;
                if ((num + cont) == comp || (num - cont) == comp) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Metodo voltear. Este metodo recibe un arreglo y retorna este mismo con
     * los elementos invertidos.
     *
     * @param array Es el arreglo que se va a invertir
     * @return Se retorna el arreglo invertido.
     */
    public static String[] voltear(String[] array) {
        String[] aux = new String[array.length];
        int cont = array.length - 1;
        for (String array1 : array) {
            aux[cont] = array1;
            cont--;
        }
        return aux;
    }

    /**
     * El método queens realiza un string de 0 a n-1, Después hace todas las
     * permutacioens posibles y las envía en forma de arreglo a el método
     * evaluador
     *
     * @param n Es el numero de reinas a posicionar
     * @return Se retorna un arreglo con todas las posibles combinaciones.
     */
    public ArrayList<String[]> queens(int n) {
        String c = "";
        for (int i = 0; i < n; i++) {
            c += i;
        }
        ArrayList<String> q = new ArrayList<>();
        ArrayList<String[]> arrB = new ArrayList<>();
        permutaciones("", c, q);
        for (int i = 0; i < q.size(); i++) {
            String[] ar = queensAux(q.get(i).split(""));
            if (ar != null) {
                arrB.add(ar);
            }
        }
        System.out.println("total: " + arrB.size());
        for (int i = 0; i < arrB.size(); i++) {
            System.out.println(Arrays.toString(arrB.get(i)));
        }
        return arrB;
    }
}
