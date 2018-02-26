package lab02;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Laboratorio 2. Aqui se encuentran los punto 1.2 (Pruebas en JUnit) del
 * laboratorio.
 *
 * @author Alejandro Cano Munera
 * @author Sebastian Giraldo Gomez
 * @version Febrero 2018
 */
public class EjerciciosTest {

    public EjerciciosTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of queens method, of class Ejercicios.
     */
    @Test
    public void testQueens() {
        System.out.println("queens");
        //Variables
        int a = 6;
        int b = 7;
        int c = 8;
        int d = 9;

        //Instancias
        Ejercicios instance = new Ejercicios();

        //Resultados Esperados
        int expResultA = 4;
        int expResultB = 40;
        int expResultC = 92;
        int expResultD = 352;

        //Resultados Obtenidos
        int resultA = instance.queens(a).size();
        int resultB = instance.queens(b).size();
        int resultC = instance.queens(c).size();
        int resultD = instance.queens(d).size();

        //Pruebas
        assertEquals(expResultA, resultA);
        assertEquals(expResultB, resultB);
        assertEquals(expResultC, resultC);
        assertEquals(expResultD, resultD);

    }

}
