package taller1;

import java.util.ArrayList;

/**
 * Taller 1. Clase Abstracta Graph. Clase para la implementacion de
 * grafos. La plantilla de esta clase fue tomada del Github del docente Mauricio
 * Toro, en el siguiente enlace:
 * https://github.com/mauriciotoro/ST0247-Eafit/tree/master/talleres/taller01
 *
 * @author Alejandro Cano Munera
 * @author Sebastian Giraldo Gomez
 *
 * @version Febrero 2018
 */
public abstract class Digraph {

    /**
     * Atributos.
     */
    protected int size;

    /**
     * Constructor base de una clase que hereda de la clase Graph.
     *
     * @param vertices
     */
    public Digraph(int vertices) {
        size = vertices;
    }

    /**
     * Metodo addArc. Este metodo añade un arco al grafo.
     *
     * @param source Es el nodo de salida en el grafo
     * @param destination Es el nodo de llegada en el grafo
     * @param weight Es el peso del arco en el grafo.
     */
    public abstract void addArc(int source, int destination, int weight);

    /**
     * Metodo getWeight. Este metodo retorna el peso de un arco en el grafo
     * dados sus dos nodos adyacentes.
     *
     * @param source Es el nodo de salida en el grafo.
     * @param destination Es el nodo de llegada en el grafo.
     * @return Se retorna el peso del arco encontrado, si no se encuentra el
     * arco se retorna cero.
     */
    public abstract int getWeight(int source, int destination);

    /**
     * Metodo getSuccessors. Este metodo retorna un ArrayList con los sucesores
     * de un nodo dado en el grafo.
     *
     * @param vertice Es el nodo al que se le buscaran los sucesores.
     * @return Se rotorna un ArrayList con los sucesores de dicho nodo. Se
     * retorna un ArrayList vacio si el nodo no existe o no contiene sucesores.
     */
    public abstract ArrayList<Integer> getSuccessors(int vertice);

    /**
     * Meotodo size. El cual retorna el numero de vertices (size) del grafo
     *
     * @return Se retorna el numero de vertices en el grafo.
     */
    public int size() {
        return size;
    }
}