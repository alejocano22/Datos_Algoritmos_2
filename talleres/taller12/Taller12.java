package taller12;

import java.util.ArrayList;
import java.util.Arrays;

public class Taller12 {

    static int posicion = 0;
    static int minimo = Integer.MAX_VALUE;
    static int[] ganador = {};

    public static void main(String[] args) {
//        for (int i = 0; i < tablero.length; i++) {
//            tablero[i] = (int) Math.floor(Math.random() * n);
//        }

//----------Ya encuentra los golpes, verificar cuando se mueven las reinas
        Taller12 r = new Taller12();
        int[] cer = {0, 0, 0, 0};
        System.out.println(Arrays.toString(cer));
        r.queensAux(cer);
        ganador = cer;
        for (int i = 0; i < cer.length; i++) {
            for (int j = 0; j < cer.length; j++) {
                int mientras = minimo;
                cer[i] = j;
                r.queensAux(cer);
                System.out.println(minimo);
                
                   
                
            }
        }
        System.out.println(Arrays.toString(ganador));
        System.out.println(minimo);
    }

    /**
     * Metodo queensAux. Se utiliza para verificar las diferentes diagonales de
     * una reina.
     *
     * @param array Es el arreglo de reinas que se evaluara.
     * @return Se retorna el arreglo si es buena combinacion y null de lo
     * contrario.
     */
    public int[] queensAux(int[] array) {
        if (comprobar(array)) {
            if (comprobar(voltear(array))) {
                return array;
            } else {
                return null;
            }
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
    public static boolean comprobar(int[] array) {
        int golpes = 0;
        boolean variable = false;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    golpes++;
                }
            }
        }

        for (int i = 0; i < array.length - 1; i++) {
            int cont = 0; //Para llevar las posiciones
            int num = array[i];
            for (int j = i + 1; j < array.length; j++) {
                int comp = array[j];
                cont++;
                if ((num + cont) == comp || (num - cont) == comp) {
                    golpes++;
                    variable = false;
                }
            }
        }
//        System.out.println(golpes);

        if (golpes < minimo) {
            minimo = golpes;
            ganador = array;
        }
        return variable;
    }

    /**
     * Metodo voltear. Este metodo recibe un arreglo y retorna este mismo con
     * los elementos invertidos.
     *
     * @param array Es el arreglo que se va a invertir
     * @return Se retorna el arreglo invertido.
     */
    public static int[] voltear(int[] array) {
        int[] aux = new int[array.length];
        int cont = array.length - 1;
        for (int array1 : array) {
            aux[cont] = array1;
            cont--;
        }
        return aux;
    }
}
