import sun.security.provider.Sun;

import java.util.Arrays;

/**
 * @author by zling
 * @classname Solution_560
 * @description TODO
 * @date 2023/3/6 21:54
 */
public class Solution_560 {

    public int subarraySum(int[] nums, int k) {
        if (nums == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        Solution_560 solution_560 = new Solution_560();
        int[] nums = {1, 2, 3};
        System.out.println(solution_560.subarraySum(nums, 3));

    }
}
