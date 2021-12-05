import java.util.Arrays;

class Sudoku {
    boolean set = false;
    public void solveSudoku(char[][] board) {
        helper(board,0,0);
    }

    public void helper(char[][] board, int row, int col){
        if(col == 9){
            col = 0;
            row++;
        }
        if(row == 9){
            set = true;
            return;
        }
        if(board[row][col] != '.'){
            helper(board,row,col+1);
        }else {
            for(int k = 1; k <= 9; k++){
//            System.out.println("Exe");
                if(row < 9 && col < 9 && board[row][col] == '.') {
                    if (!checkDuplicate(board, row, col, k)) {
                        System.out.println("Exe");
                        System.out.println(Character.forDigit(k,10));
                        board[row][col] = Character.forDigit(k,10);
                    } else {
                        continue;
                    }
                    helper(board, row, col+1);
                    if (set)
                        break;
                    board[row][col] = '.';
                }
                if (set)
                    break;
            }
        }

    }

    private boolean checkDuplicate(char[][] board, int row, int col, int k) {
        //Checking row and column
        for(int i = 0; i < 9; i++) {
            if (board[i][col] == Character.forDigit(k,10) || board[row][i] == Character.forDigit(k,10)) {
                return true;
            }
        }

        //Checking 3*3 grid
        int gridRow = (row/3)*3;
        int gridCol = (col/3)*3;
        for(int i = gridRow; i < gridRow + 3; i++){
            for(int j = gridCol; j < gridCol + 3; j++){
                if (board[i][j] == Character.forDigit(k,10))
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
//        char[][] board =
//                {{'5','3','.','.','7','.','.','.','.'},
//                {'6','.','.','1','9','5','.','.','.'},
//                {'.','9','8','.','.','.','.','6','.'},
//                {'8','.','.','.','6','.','.','.','3'},
//                {'4','.','.','8','.','3','.','.','1'},
//                {'7','.','.','.','2','.','.','.','6'},
//                {'.','6','.','.','.','.','2','8','.'},
//                {'.','.','.','4','1','9','.','.','5'},
//                {'.','.','.','.','8','.','.','7','9'}};
        char[][] board =
                {{'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'}};
        print(board);
        System.out.println("\n");
        new Solution().solveSudoku(board);
        print(board);
    }

    private static void print(char[][] board) {
        for (int i = 0; i < 9; i++){
            System.out.println(Arrays.toString(board[i]));
        }
    }
}