package lab02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Laboratorio 2. Aqui se encuentran los punto 1 y 2 del laboratorio.
 *
 * @author Alejandro Cano Munera
 * @author Sebastian Giraldo Gomez
 * @version Febrero 2018
 */
public class Ejercicios {

    static Scanner sc = new Scanner(System.in);

    /**
     * Metodo main. Aqui se realiza la ejecucion y prueba de los ejercicios
     * planteados.
     *
     * @param args
     */
    public static void main(String[] args) {
        Ejercicios lb2 = new Ejercicios();

        System.out.println("Punto 1.1");
        int n = 8;
        System.out.print(n + " Combinaciones posibles: ");
        ArrayList<String[]> a = lb2.queens(n);
        System.out.println(a.size());
        for (int i = 0; i < a.size(); i++) {
            System.out.print("[ ");
            for (String get : a.get(i)) {
                System.out.print(get + " ");
            }
            System.out.println("]");
        }

        System.out.println("Punto 2.1");
        Queue<Integer> p2 = lb2.ejercicioEnLinea();
        int cont = 1;
        while (!p2.isEmpty()) {
            System.out.println("Case " + cont + " :" + p2.poll());
            cont++;
        }
    }

    /**
     * Metodo permutaciones. Este metodo calcula las permutacion posibles en un
     * String.
     *
     * @param b Es una Cadena auxiliar para evaluar
     * @param c Es la Cadena a evaluar
     * @param arr Es un Arreglo con las permutaciones
     */
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
        for (int i = 0; i < n; i++) {//
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

        return arrB;
    }

    //Punto 2.1
    public Queue<Integer> ejercicioEnLinea() {
        Queue<Integer> res = new LinkedList<>();
        int n;
        int cont;
        do {
            n = sc.nextInt();
            sc.nextLine();
            String[][] a;
            if (n == 0) {
                break;
            } else {
                a = leer(n);
            }
            ArrayList<String[]> b = queens(n);
            cont = b.size();
            for (int i = 0; i < b.size(); i++) {
                String[] c = b.get(i);
                boolean can = true;
                for (int j = 0; j < c.length; j++) {
                    int col = j;
                    int fil = Integer.parseInt(c[j]);
                    if (a[fil][col].equals("*")) {
                        can = false;
                        cont--;
                        break;
                    }
                }
            }
            res.add(cont);
        } while (n != 0);
        return res;
    }

    private String[][] leer(int n) {
        String[][] a = new String[n][n];
        for (int i = n - 1; i >= 0; i--) {
            a[i] = sc.nextLine().split("");
        }
        return a;
    }
}
