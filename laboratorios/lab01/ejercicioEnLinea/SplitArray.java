package codingbat;

/**
 * Laboratorio 1. Punto 2.2. En esta clase se contiene el ejercicio SplitArray
 * de la plataforma virtual codingbat.
 *
 * @author Alejandro Cano Munera
 * @author Sebastian Giraldo Gomez
 *
 * @version Febrero 2018
 */
public class SplitArray {

    public boolean splitArray(int[] nums) {
        return aux(0, nums, 0, 0);
    }

    private boolean aux(int start, int[] nums, int sum1, int sum2) {
        if (start >= nums.length) {
            return sum1 == sum2;
        }
        return aux(start + 1, nums, sum1 + nums[start], sum2)
                || aux(start + 1, nums, sum1, sum2 + nums[start]);
    }
}
