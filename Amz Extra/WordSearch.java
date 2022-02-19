class WordSearch {
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(checkString(i,j,board, 0, word))return true;
                }
            }
        }
        return false;
    }

    private boolean checkString(int i, int j, char[][] board, int index, String word) {
        if(index == word.length())return true;
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j])return false;
        if(board[i][j] != word.charAt(index))return false;
        boolean search = false;
        visited[i][j] = true;
        search |= checkString(i+1,j,board,index+1,word);
        if(!search)search |= checkString(i,j+1,board,index+1,word);
        if(!search)search |= checkString(i-1,j,board,index+1,word);
        if(!search)search |= checkString(i,j-1,board,index+1,word);
        visited[i][j] = false;
        return search;
    }
}