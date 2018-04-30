package lab05;

/**
 * Laboratorio 5. Punto 1.2. Clase Test_HeldKarp. En esta clase se encuentra un
 * grafo dirigido con el cual se prueba el algoritmo de Held-Karp propuesto en
 * el laboratorio. La plantilla de esta clase fue tomada del Github del docente
 * Mauricio Toro, en el siguiente enlace:
 * https://github.com/mauriciotoro/ST0247-Eafit/tree/master/talleres/taller11
 *
 *
 * @author Alejandro Cano Munera
 * @author Sebastian Giraldo Gomez
 *
 * @version Abril 2018
 */
public class Test_HeldKarp {

    public static void main(String[] args) {
        System.out.println("Held-Karp -> " + convert(testHeldKarp()));
    }

    static boolean testHeldKarp() {
        Held_Karp n = new Held_Karp();
        DigraphAL g3 = new DigraphAL(4);
        g3.addArc(0, 0, 0);
        g3.addArc(0, 1, 7);
        g3.addArc(0, 2, 15);
        g3.addArc(0, 3, 6);
        g3.addArc(1, 0, 2);
        g3.addArc(1, 1, 0);
        g3.addArc(1, 2, 7);
        g3.addArc(1, 3, 3);
        g3.addArc(2, 0, 9);
        g3.addArc(2, 1, 6);
        g3.addArc(2, 2, 0);
        g3.addArc(2, 3, 12);
        g3.addArc(3, 0, 10);
        g3.addArc(3, 1, 4);
        g3.addArc(3, 2, 8);
        g3.addArc(3, 3, 0);
        return n.heldKarp(g3) == 22;
    }

    static String convert(boolean b) {
        return b ? "correcta" : "incorrecta";
    }
}
