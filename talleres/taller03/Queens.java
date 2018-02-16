package taller3;

import java.util.ArrayList;

/**
 * Taller 3. BackTracking.
 *
 * @author Alejandro Cano Munera
 * @author Sebastian Giraldo Gomez
 *
 * @version Febrero 2018
 */
public class Queens {

    //Pruebas
    public static void main(String[] args) {
        Queens t3 = new Queens();
        int n = 8;
        System.out.print("Para n = " + n + ", hay ");
        t3.queens(n);
        System.out.println(" combinaciones posibles.");
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
        System.out.print(arrB.size());
        return arrB;
    }

    public void permutaciones(String b, String c, ArrayList<String> arr) {
        if (c.length() > 0) {
            for (int i = 0; i < c.length(); i++) {
                permutaciones(b.concat(c.charAt(i) + ""), c.substring(0, i) + c.substring(i + 1), arr);
            }

        } else {
            arr.add(b);
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
        if (test(array) && test(invertirArray(array))) {
            return array;
        } else {
            return null;
        }
    }

    /**
     * Metodo invertir. Este metodo recibe un arreglo y retorna este mismo con
     * los elementos invertidos.
     *
     * @param array Es el arreglo que se va a invertir
     * @return Se retorna el arreglo invertido.
     */
    public static String[] invertirArray(String[] array) {
        String[] aux = new String[array.length];
        int cont = array.length - 1;
        for (String array1 : array) {
            aux[cont] = array1;
            cont--;
        }
        return aux;
    }

    /**
     * Metodo comprobar. Este metodo se encarga de verificar las diagonales de
     * cada reina en el arreglo.
     *
     * @param array Es la posicion de las reinas en el tablero.
     * @return Se retorna verdadero si la reina esta bien ubicada, y falso de lo
     * contrario.
     */
    public static boolean test(String[] array) {
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

}
