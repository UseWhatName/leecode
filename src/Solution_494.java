import javax.swing.*;

/**
 * @author by zling
 * @classname Solution_494
 * @date 2023/3/20 17:30
 */
public class Solution_494 {

    int count = 0;

    public int findTargetSumWays(int[] nums, int target) {

        int index = 0;
        int sum = 0;
        getWay(nums, target, index, sum);
        return count;
    }



    public void getWay(int[] nums, int target, int index, int sum) {

        if (index == nums.length) {
            if (sum == target) {
                count++;
            }
            return;
        }
        this.getWay(nums, target, index + 1, sum + nums[index]);
        this.getWay(nums, target, index + 1, sum - nums[index]);
    }


    public static void main(String[] args) {

        int[] nums = {1,1,1,1,1};
        Solution_494 solution_494 = new Solution_494();
        System.out.println(solution_494.findTargetSumWays(nums, 3));




    }


}
