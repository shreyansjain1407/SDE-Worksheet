class WinnerInTicTacToe {
    int[][] tic_tac_toe = new int[3][3];
    public String tictactoe(int[][] moves) {
        int x = 3;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                tic_tac_toe[i][j] = x++;
            }
        }
        boolean player1 = true;
        boolean won = false;
        int i = 0;
        for(i = 0; i < moves.length && i<9; i++){
            int player = (player1)?1:2;
            tic_tac_toe[moves[i][0]][moves[i][1]] = player;
            won = checkVert(moves[i][0], moves[i][1], player) || checkHor(moves[i][0], moves[i][1], player) || checkDiag(moves[i][0], moves[i][1], player);
            if(won) break;

            player1 = !player1;
        }

        if(won)
            return (player1)?"A":"B";
        else if(i == 9){
            return "Draw";
        }else{
            return "Pending";
        }
    }
    public void printgrid(){
         for(int i = 0; i < 3; i++){
             for(int j = 0; j < 3; j++){
                 System.out.print(tic_tac_toe[i][j] + " ");
             }
             System.out.println(" ");
         }
     }

    private boolean checkDiag(int row, int col, int player) {
        return (tic_tac_toe[0][0] == tic_tac_toe[1][1] && tic_tac_toe[0][0] == tic_tac_toe[2][2]) ||
                (tic_tac_toe[2][0] == tic_tac_toe[1][1] && tic_tac_toe[2][0] == tic_tac_toe[0][2]);
    }

    private boolean checkHor(int row, int col, int player) {
        return tic_tac_toe[row][0] == tic_tac_toe[row][1] && tic_tac_toe[row][0] == tic_tac_toe[row][2];
    }

    private boolean checkVert(int row, int col, int player) {
        return tic_tac_toe[0][col] == tic_tac_toe[1][col] && tic_tac_toe[0][col] == tic_tac_toe[2][col];
    }
}