/**
 * @author by zling
 * @classname Solution_152
 * @description TODO
 * @date 2023/3/9 22:38
 */
public class Solution_152 {

    public int maxProduct(int[] nums) {

        int max = 1;
        int min = 1;
        int ret = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = max;
                max = min;
                min = tmp;
            }
            max = Math.max(max * nums[i], nums[i]);
            min = Math.min(min * nums[i], nums[i]);
            ret = Math.max(ret, max);
        }
        return ret;
    }

    public static void main(String[] args) {

        Solution_152 solution_152 = new Solution_152();
//        int[] val = {2,3,-2,4};
        int[] val = {2,-5,-2,-4,3};
        System.out.println(solution_152.maxProduct(val));
    }
}
