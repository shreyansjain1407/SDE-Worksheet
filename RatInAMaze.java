import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class RatInAMaze {
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> paths = new ArrayList<String>();
        new Solution().helper(m,new StringBuilder(), paths, 0,0);

        if (paths.size() == 0)
            paths.add("-1");
        Collections.sort(paths);
        return paths;
    }

    public void helper(int[][] m, StringBuilder sb, List<String> paths, int row, int col){
        if(row < 0 || col < 0 || row >= m.length || col >= m.length)
            return;

        if(row == m.length -1 && col == m.length -1){
            paths.add(sb.toString());
            return;
        }
        if(m[row][col] == 1) {
            m[row][col] = 0;
            if (row > 0 && m[row - 1][col] == 1) {
                sb.append("U");
                helper(m, sb, paths, row - 1, col);
                sb.deleteCharAt(sb.length() - 1);
            }
            if (col > 0 && m[row][col - 1] == 1) {
                sb.append("L");
                helper(m, sb, paths, row, col - 1);
                sb.deleteCharAt(sb.length() - 1);
            }
            if (row < m.length - 1 && m[row + 1][col] == 1) {
                sb.append("D");
                helper(m, sb, paths, row + 1, col);
                sb.deleteCharAt(sb.length() - 1);
            }
            if (col < m.length - 1 && m[row][col + 1] == 1) {
                sb.append("R");
                helper(m, sb, paths, row, col + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
            m[row][col] = 1;
        }
    }

    public static void main(String[] args) {
//        int[][] arr =
//                {{1, 0, 0, 0},
//                {1, 1, 0, 1},
//                {1, 1, 0, 0},
//                {0, 1, 1, 1}};
        int[][] arr = {{1,0},{1,1}};
        System.out.println(findPath(arr,arr.length).toString());
    }
}