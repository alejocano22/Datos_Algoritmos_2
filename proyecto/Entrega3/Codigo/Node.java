
/**
 * Clase Node. En esta clase se implementa la plantilla general de un nodo con
 * sus atributos.
 *
 * @author Alejandro Cano Munera
 * @author Sebastián Giraldo Gómez
 *
 * @version Mayo 2018
 */
public class Node {

    //Atributos
    int id;
    String nombre;
    double x;
    double y;
    char t1;
    int t2;
    double wh;

    /**
     * Constructor de la clase Node
     * @param id Es el identificador del nodo.
     * @param nombre Es el nombre del nodo.
     * @param x Es la posicion x del nodo.
     * @param y Es la posicion y del nodo.
     * @param t1 Es el tipo de nodo.
     * @param t2 Es el tipo de estacion
     * @param wh Son los whats que carga una estacion.
     */
    public Node(int id, String nombre, double x, double y, char t1, int t2, double wh) {
        this.id = id;
        this.nombre = nombre;
        this.x = x;
        this.y = y;
        this.t1 = t1;
        this.t2 = t2;
        this.wh = wh;
    }
}
