import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author by zling
 * @classname Solution_75
 * @description TODO
 * @date 2023/3/6 21:27
 */
public class Solution_75 {


    public void sortColors(int[] nums) {

        if (nums == null) {
            return;
        }
        int count0 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count0++;
                for (int j = i; j > 0; j--) {
                    nums[j] = nums[j - 1];
                }
                nums[0] = 0;
            }
            if (nums[i] == 1) {
                for (int j = i; j > count0; j--) {
                    nums[j] = nums[j - 1];
                }
                nums[count0] = 1;
            }
            if (nums[i] == 2) {
                continue;
            }
        }
    }


    public static void main(String[] args) {

        Solution_75 solution_75 = new Solution_75();
        int[] nums = {2,0,1};
        solution_75.sortColors(nums);
        System.out.println(Arrays.asList(nums));


    }



}
