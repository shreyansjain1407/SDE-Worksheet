class TicTacToe {
    int[][] tic_tac_toe;
    int N;
    public TicTacToe(int n) {
        tic_tac_toe = new int[n+3][n+3];
        N = n;
    }

    public int move(int row, int col, int player) {
        tic_tac_toe[row][col] = player;
        // printgrid();
        if(checkVert(row, col, player) || checkHor(row, col, player) || checkDiag(row, col, player)){
            return player;
        }else{
            return 0;
        }
    }

    private boolean checkDiag(int row, int col, int player) {
        // if(N % 2 == 0 && N != 2){
        //     return false;
        // }
        boolean mainDiag = true, antiDiag = true;
        for(int i = 0; i < N; i++){
            if(tic_tac_toe[i][i] != player){
                mainDiag = false;
                break;
            }
        }
        for (int i = N-1; i >= 0; i--){
            if(tic_tac_toe[i][N - i - 1] != player){
                antiDiag = false;
            }
        }
        return mainDiag || antiDiag;
    }

    private boolean checkHor(int row, int col, int player) {
        tic_tac_toe[row][col] = player;
        tic_tac_toe[N][col]++;
        tic_tac_toe[N+player][col]++;
        int player2 = (player == 1)?2:1;
        if(tic_tac_toe[N+player2][col] > 0){
            return false;
        }else if(tic_tac_toe[N+player][col] == N){
            return true;
        }
        return false;
    }

    private boolean checkVert(int row, int col, int player) {
        tic_tac_toe[row][col] = player;
        tic_tac_toe[row][N]++;
        tic_tac_toe[row][N+player]++;
        int player2 = (player == 1)?2:1;
        if(tic_tac_toe[row][N+player2] > 0){
            return false;
        }else if(tic_tac_toe[row][N+player] == N){
            return true;
        }
        return false;
    }
     public void printgrid(){
         for(int i = 0; i < N; i++){
             for(int j = 0; j < N; j++){
                 System.out.print(tic_tac_toe[i][j] + " ");
             }
             System.out.println(" ");
         }
     }
}