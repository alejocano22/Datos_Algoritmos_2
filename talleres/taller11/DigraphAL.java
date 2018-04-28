package taller11;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Taller11. Clase DigraphAL. Esta clase es una implementacion de un
 * digrafo usando listas de adyacencia. La plantilla de esta clase fue tomada
 * del Github del docente Mauricio Toro, en el siguiente enlace:
 * https://github.com/mauriciotoro/ST0247-Eafit/tree/master/laboratorios/lab01
 *
 * @author Alejandro Cano Munera
 * @author Sebastian Giraldo Gomez
 *
 * @version Abril 2018
 */
public class DigraphAL extends Graph {

    /**
     * Atributos. Lista enlazada de parejas.
     */
    public LinkedList<LinkedList<Pareja>> list;

    /**
     * Constructor de la clase DigraphAL. Se crea y se inicializa la lista enlazada
     * de parejas.
     *
     * @param size Es el tamaño de la lista a construir (numero de vertices en
     * la lista principal)
     */
    public DigraphAL(int size) {
        super(size);
        list = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            list.add(new LinkedList<>());
        }
    }

    /**
     * Metodo addArc. Este metodo añade un arco al grafo de listas enlazadas.
     *
     * @param source Es el nodo de salida en el grafo
     * @param destination Es el nodo de llegada en el grafo
     * @param weight Es el peso del arco en el grafo.
     */
    @Override
    public void addArc(int source, int destination, int weight) {
        boolean done = false;
        for (int i = 0; i < list.get(source).size(); i++) {
            if (list.get(source).get(i).vertice == destination) {
                done = true;
            }
        }
        if (done == false) {
            list.get(source).add(new Pareja(destination, weight));
        }

    }

    /**
     * Metodo getWeight. Este metodo retorna el peso de un arco en el grafo
     * dados sus dos nodos adyacentes.
     *
     * @param source Es el nodo de salida en el grafo.
     * @param destination Es el nodo de llegada en el grafo.
     * @return Se retorna el peso del arco encontrado, si no se encuentra el
     * arco se retorna cero.
     */
    @Override
    public int getWeight(int source, int destination) {
        for (int i = 0; i < list.get(source).size(); i++) {
            if (list.get(source).get(i).vertice == destination) {
                return list.get(source).get(i).peso;
            }
        }
        return 0;
    }

    /**
     * Metodo getSuccessors. Este metodo retorna un ArrayList con los sucesores
     * de un nodo dado en el grafo.
     *
     * @param vertice Es el nodo al que se le buscaran los sucesores.
     * @return Se rotorna un ArrayList con los sucesores de dicho nodo. Se
     * retorna un ArrayList vacio si el nodo no existe o no contiene
     * sucesores.
     */
    @Override
    public ArrayList<Integer> getSuccessors(int vertice) {
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < list.get(vertice).size(); i++) {
            array.add(list.get(vertice).get(i).vertice);
        }
        return array;
    }
}