/**
 * @author by zling
 * @classname Solution_647
 * @description TODO
 * @date 2023/3/5 22:07
 */
public class Solution_647 {



    public int countSubstrings(String s) {

        if (s == null) {
            return 0;
        }
        int count = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int offset = 0;
            int left = i - offset;
            int right = i + offset;
            // 单中心的情况
            while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
                count++;
                offset++;
                left = i - offset;
                right = i + offset;
            }
        }
        // 双中心的情况
        for (int i = 0; i < chars.length; i++) {
            int right = i + 1;
            int left = i;
            while (left >=0 && right < chars.length && chars[left] == chars[right]) {
                count++;
                left--;
                right++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution_647 solution_647 = new Solution_647();
        String val = "abc";
        System.out.println(solution_647.countSubstrings(val));
    }
}
