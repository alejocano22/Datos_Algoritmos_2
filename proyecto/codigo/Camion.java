
import java.util.LinkedList;

/**
 * Clase Camion. En esta clase se implementa la plantilla basica de un camion y
 * sus atributos.
 *
 * @author Alejandro Cano Munera
 * @author Sebastian Giraldo Gomez
 *
 * @version Mayo 2018
 */
public class Camion {

    //Atributos
    //id: Es el numero de identificacion del camion.
    static int id;
    double time;
    double bat;
    double x;
    double y;
    LinkedList<Node> visited;

    /**
     * Constructor de la clase camion.
     *
     * @param bat Es la bateria con la que inicia un camion.
     * @param x Es la posicion x en la que se encuentra el camion.
     * @param y Es la posicion y en la que se encuentra el camion.
     * @param time Es el tiempo restante que un camion puede hacer el recorrido.
     */
    public Camion(double bat, double x, double y, double time) {
        id++;
        this.time = time;
        this.bat = bat;
        this.x = x;
        this.y = y;
        this.visited = new LinkedList<>();
    }
}
