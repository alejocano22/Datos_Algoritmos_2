package codingbat;

/**
 * Laboratorio 1. Punto 2.2. En esta clase se contiene el ejercicio Split53 de
 * la plataforma virtual codingbat.
 *
 * @author Alejandro Cano Munera
 * @author Sebastian Giraldo Gomez
 *
 * @version Febrero 2018
 */
public class Split53 {

    public boolean split53(int[] nums) {
        int index = 0;
        int s1 = 0;
        int s2 = 0;
        return metodoAux(nums, index, s1, s2);
    }

    private boolean metodoAux(int[] nums, int index, int s1, int s2) {
        if (index >= nums.length) {
            return s1 == s2;
        }

        int value = nums[index];
        if (value % 5 == 0) {
            return metodoAux(nums, index + 1, s1 + value, s2);
        }
        if (value % 3 == 0 && value % 5 != 0) {
            return metodoAux(nums, index + 1, s1, s2 + value);
        }
        return metodoAux(nums, index + 1, s1 + value, s2) || metodoAux(nums, index + 1, s1, s2 + value);
    }
}
