/**
 * @author by zling
 * @classname Solution_283
 * @description TODO
 * @date 2023/3/23 21:59
 */
public class Solution_283 {

    public void moveZeroes(int[] nums) {
        int[] numsTmp = new int[nums.length];
        for (int i =0, j = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                numsTmp[j++] = nums[i];
            }
        }
        for (int k = 0; k < nums.length; k++) {
            nums[k] = numsTmp[k];
        }
    }

    public static void main(String[] args) {


        Solution_283 solution_283 = new Solution_283();
        int[] nums = {};
        solution_283.moveZeroes(nums);


    }
}
