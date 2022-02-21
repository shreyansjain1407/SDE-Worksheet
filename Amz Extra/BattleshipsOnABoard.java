class BattleshipsOnABoard {
    public int countBattleships(char[][] board) {
        int count = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'X'){
                    count++;
                    destroyShip(board, i, j);
                }
            }
        }
        return count;
    }

    private void destroyShip(char[][] board, int i, int j) {
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'X')return;
        
        board[i][j] = '.';
        destroyShip(board, i+1, j);
        destroyShip(board, i, j+1);
        destroyShip(board, i-1, j);
        destroyShip(board, i, j-1);
    }
}