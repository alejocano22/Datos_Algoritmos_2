
package codingbat;

/**
 * Laboratorio 1. Punto 2.2. En esta clase se contiene el ejercicio GroupSum de
 * la plataforma virtual codingbat.
 *
 * @author Alejandro Cano Munera
 * @author Sebastian Giraldo Gomez
 *
 * @version Febrero 2018
 */
public class GroupSum {
    public boolean groupSum(int start, int[] nums, int target) {
    if (start >= nums.length){
      return target == 0;
    } 
    return groupSum(start + 1, nums, target - nums[start])|| 
    groupSum(start + 1, nums, target);
}
}
