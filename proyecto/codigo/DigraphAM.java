
import java.util.ArrayList;

/**
 * Clase DigraphAM. Esta clase es una implementacion de un grafo usando matrices
 * de adyacencia. La plantilla de esta clase fue tomada del Github del docente
 * Mauricio Toro, en el siguiente enlace: https://github.com/mauriciotoro/
 *
 * @author Alejandro Cano Munera
 * @author Sebastián Giraldo Gómez
 *
 * @version Mayo 2018
 */
public class DigraphAM extends Digraph {

    /**
     * Atributos. Matriz sobre la cual se creara el grafo.
     */
    public double[][] matriz;

    /**
     * Constructor de la clase DigraphAM. Se crea y se inicializa la matriz; la
     * matriz es cuadrada y su tamaño viene dado por el numero de vertices.
     *
     * @param size Es el numero de vertices, es decir, es el tamaño de la matriz
     * (size x size). se inicializan todos los valores de la matriz en cero.
     */
    public DigraphAM(int size) {
        super(size);
        matriz = new double[size][size];
    }

    /**
     * Metodo addArc. Este metodo añade un arco al grafo en una matriz.
     *
     * @param source Es el nodo de salida en el grafo
     * @param destination Es el nodo de llegada en el grafo
     * @param weight Es el peso del arco en el grafo.
     */
    @Override
    public void addArc(int source, int destination, int weight) {
        matriz[source][destination] = weight;
    }

    /**
     * Metodo getWeight. Este metodo retorna el peso de un arco en el grafo
     * dados sus dos nodos adyacentes.
     *
     * @param source Es el nodo de salida en el grafo.
     * @param destination Es el nodo de llegada en el grafo.
     * @return Se retorna el peso del arco encontrado, si no se encuentra el
     * arco se retorna cero (que es el valor por omision en la matriz).
     */
    @Override
    public double getWeight(int source, int destination) {

        return matriz[source][destination];
    }

    /**
     * Metodo getSuccessors. Este metodo retorna un ArrayList con los sucesores
     * de un nodo dado en el grafo.
     *
     * @param vertex Es el nodo al que se le buscaran los sucesores.
     * @return Se rotorna un ArrayList con los sucesores de dicho nodo. Se
     * retorna un ArrayList vacio si el nodo no existe o no contiene sucesores.
     */
    @Override
    public ArrayList<Integer> getSuccessors(int vertex) {
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < matriz[vertex].length; i++) {
            if (matriz[vertex][i] != 0) {
                array.add(i);
            }
        }
        if (array.isEmpty()) {
            return null;
        }
        return array;
    }
}
