package codingbat;

/**
 * Laboratorio 1. Punto 2.2. En esta clase se contiene el ejercicio SplitOdd10
 * de la plataforma virtual codingbat.
 *
 * @author Alejandro Cano Munera
 * @author Sebastian Giraldo Gomez
 *
 * @version Febrero 2018
 */
public class SplitOdd10 {

    public boolean splitOdd10(int[] nums) {
        int i = 0;
        int s1 = 0;
        int s2 = 0;
        return metodoAux(nums, i, s1, s2);
    }

    public boolean metodoAux(int[] nums, int i, int s1, int s2) {
        if (i >= nums.length) {
            return (s1 % 10 == 0 && s2 % 2 != 0) || (s2 % 10 == 0 && s1 % 2 != 0);
        }
        int v;
        v = nums[i];
        return (metodoAux(nums, i + 1, s1 + v, s2) || metodoAux(nums, i + 1, s1, s2 + v));
    }
}
