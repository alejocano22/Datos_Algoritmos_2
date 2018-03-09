
/**
 * Talller 6. Punto 1. Monedas
 *
 * @author Alejandro Cano Munera
 * @author Sebastian Giraldo Gómez
 *
 * @version Marzo 2018
 */
public class Monedas {

    public static void main(String[] args) {
        Monedas t6 = new Monedas();
        int coins[] = {300, 500, 200, 50};
        t6.cambioGreedy(900, coins);

    }

    public int[] cambioGreedy(int n, int[] coins) {
        int[] res = new int[coins.length];
        res = cambioGreedyAux(n, coins, 0, res);
        return res;
    }

    /**
     * Metodo voltear. Este metodo recibe un arreglo y retorna este mismo con
     * los elementos invertidos.
     *
     * @param array Es el arreglo que se va a invertir
     * @return Se retorna el arreglo invertido.
     */
    public int[] voltear(int[] array) {
        int[] aux = new int[array.length];
        int cont = array.length - 1;
        for (int array1 : array) {
            aux[cont] = array1;
            cont--;
        }
        return aux;
    }

    private int[] cambioGreedyAux(int n, int[] coins, int i, int[] res) {
        if (i >= coins.length) {
            if (n == 0) {
                return res;
            } else {
                return null;
            }
        } else if (n > coins[i]) {
            int num = n / coins[i];
            n -= num * coins[i];
            res[i] = num;
            i++;

        } else {
            res[i] = 0;
            i++;
        }
        return cambioGreedyAux(n, coins, i, res);

    }
}
