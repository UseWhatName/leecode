/**
 * @author by zling
 * @classname Solution_79
 * @description TODO
 * @date 2023/3/7 23:00
 */
public class Solution_79_TODO {

    public boolean exist(char[][] board, String word) {

        if (word == null) {
            return false;
        }
        char[] wordChar = word.toCharArray();
        boolean[][] exists = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            char[] row = board[i];
            for (int j = 0; j < row.length; j++) {
                if (getNextNode(board, i, j, 0, word, exists)) {
                    return true;
                }
            }

        }
        return false;
    }

    public boolean getNextNode(char[][] board, int i, int j, int index, String word, boolean[][] exists) {

        int up = i - 1;
        int right = j + 1;
        int down = i + 1;
        int left = j - 1;
        boolean ret = false;

        if (up >= 0 && board[up][j] == word.charAt(index) && !exists[up][j]) {
            exists[up][j] = true;
            ret = ret || getNextNode(board, up, j, index + 1, word, exists);
            exists[up][j] = false;
        }
        if (right < board[0].length && board[i][right] == word.charAt(index) && !exists[i][right]) {
            exists[i][right] = true;
            ret = ret || getNextNode(board, i, right, index + 1, word, exists);
            exists[i][right] = false;
        }
        if (down < board.length && board[down][j] == word.charAt(index) && !exists[down][j]) {
            exists[down][j] = true;
            ret = ret || getNextNode(board, down, j, index + 1, word, exists);
            exists[i][right] = false;
        }
        if (left >= 0 && board[i][left] == word.charAt(index) && !exists[i][left]) {
            exists[i][left] = true;
            ret = ret || getNextNode(board, i, left, index + 1, word, exists);
            exists[i][right] = false;
        }
        return ret;
    }




    public static void main(String[] args) {
        Solution_79_TODO solution_79 = new Solution_79_TODO();
        char[][] board = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        String word = "ABC";
        System.out.println(solution_79.exist(board, word));
    }
}
