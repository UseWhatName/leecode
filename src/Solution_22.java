import java.util.ArrayList;
import java.util.List;

/**
 * @author by zling
 * @classname Solution_22
 * @description TODO
 * @date 2023/3/12 22:29
 */
public class Solution_22 {

    public List<String> generateParenthesis(int n) {

        List<String> ret = new ArrayList<>();
        this.generateParenthesis("", n, n, ret);
        return ret;

    }


    private void generateParenthesis(String val, int left, int right, List<String> ret) {
        if (left == 0 && right == 0) {
            ret.add(val);
            return;
        }
        if (left == right) {
            this.generateParenthesis(val + "(", left - 1, right, ret);
        } else if (left < right) {
            if (left > 0) {
                this.generateParenthesis(val + "(", left - 1, right, ret);
            }
            this.generateParenthesis(val + ")", left, right - 1, ret);
        } else {

        }
    }


    public static void main(String[] args) {
        Solution_22 solution_22 = new Solution_22();
        System.out.println(solution_22.generateParenthesis(3));
    }
}
