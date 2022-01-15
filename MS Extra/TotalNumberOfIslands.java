class TotalNumberOfIslands {
    public int numIslands(char[][] grid) {
        int counter = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1'){
                    counter++;
                    zeroOut(grid, i, j);
                }
            }
        }
        return counter;
    }

    private void zeroOut(char[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        zeroOut(grid, i-1, j);
        zeroOut(grid, i+1, j);
        zeroOut(grid, i, j-1);
        zeroOut(grid, i, j+1);
    }
}