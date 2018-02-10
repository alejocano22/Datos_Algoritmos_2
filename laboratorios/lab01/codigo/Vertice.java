
package lab01;

/**
 * Laboratorio 1. Punto 1.4. Clase Vertice. Esta clase es una implementacion de un
 * vertice para la informacion de el mapa de medellin. 
 *
 * @author Alejandro Cano Munera
 * @author Sebastian Giraldo Gomez
 *
 * @version Febrero 2018
 */
public class Vertice {
    /**
     * Atributos
     */
    String cY;
    String cX;
    String nombre;
    
    /**
     * Constructor de la clase Vertice.
     * @param cY Es la cordenada en Y
     * @param cX Es la cordenada en X
     * @param nombre Es el nombre del vertice.
     */
    public Vertice( String cY, String cX, String nombre){
        this.cY=cY;
        this.cX=cX;
        this.nombre=nombre;
    }
}
