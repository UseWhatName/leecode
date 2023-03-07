/**
 * @author by zling
 * @classname Test704
 * @description TODO
 * @date 2022/5/5 16:18
 */
public class Test704 {


    public static void main(String[] args) {
        Test704 test704 = new Test704();
        int[] nums = new int[]{
                5
        };
        System.out.println(test704.search(nums, 5));

    }

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int low = 0;
        int hight = nums.length - 1;
        while (low <= hight) {
            int mid = (low + hight) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                hight = mid - 1;
            }
            if (nums[mid] < target) {
                low = mid + 1;
            }
        }
        return -1;

    }


}
