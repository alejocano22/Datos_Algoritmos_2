package codingbat;

/**
 * Laboratorio 1. Punto 2.2. En esta clase se contiene el ejercicio
 * GroupSumClump de la plataforma virtual codingbat.
 *
 * @author Alejandro Cano Munera
 * @author Sebastian Giraldo Gomez
 *
 * @version Febrero 2018
 */
public class GroupSumClump {

    public boolean groupSumClump(int start, int[] nums, int target) {
        if (start >= nums.length) {
            return target == 0;
        }
        int c = 1;
        for (int i = 1; i < nums.length; i++) {
            int h;
            if (nums[i - 1] == nums[i]) {
                c += 1;
            }
        }

        return groupSumClump(start + c, nums, target - nums[start]) || groupSumClump(start + 1, nums, target);

    }
}
