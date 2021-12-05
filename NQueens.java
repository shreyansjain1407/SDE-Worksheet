import java.util.ArrayList;
import java.util.List;

class NQueens {
    List<List<String>> validQueens;
    public List<List<String>> solveNQueens(int n) {
        int[][] chessBoard = new int[n][n];
        validQueens = new ArrayList<>();
        helper(chessBoard, 0, n);
        return validQueens;
    }


    public void helper(int[][] chessBoard, int row, int n){
        if(row == n){
            submit(chessBoard);
            return;
        }

        for(int i = 0; i < n; i++){
            if(check(chessBoard, row, i, n)) {
                chessBoard[row][i] = 1;
            } else {
                continue;
            }
            helper(chessBoard, row + 1, n);
            chessBoard[row][i] = 0;
        }
    }

    public boolean check(int[][] chessBoard, int row, int col, int n){
        for(int i = 0; i < n; i++){
            if(chessBoard[row][i] == 1 || chessBoard[i][col] == 1){
                return false;
            }
        }
        int r = row, c = col;
        while(r >= 0 && c >= 0){
            if(chessBoard[r][c] == 1){
                return false;
            }
            r--;c--;
        }
        r = row; c = col;
        while(r >= 0 && c < n){
            if(chessBoard[r][c] == 1){
                return false;
            }
            r--;c++;
        }
        r = row; c = col;
        while(r < n && c < n){
            if(chessBoard[r][c] == 1){
                return false;
            }
            r++;c++;
        }
        r = row; c = col;
        while(r < n && c >= 0){
            if(chessBoard[r][c] == 1){
                return false;
            }
            r++;c--;
        }
        return true;
    }

    private void submit(int[][] chessBoard) {
        List<String> list = new ArrayList<>();
        int n = chessBoard.length;
        for (int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++){
                if (chessBoard[i][j] == 0)
                    sb.append('.');
                else
                    sb.append('Q');
            }
            list.add(sb.toString());
        }
        validQueens.add(list);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solveNQueens(4).toString());
    }
}