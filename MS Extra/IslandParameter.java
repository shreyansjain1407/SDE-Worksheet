class IslandParameter {
    int parameter = 0;
    public int islandPerimeter(int[][] grid) {
        int[] loc = findIsland(grid);
        helper(grid, loc[0], loc[1]);
        return parameter;
    }

    private void helper(int[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0){
            parameter++;
            return;
        }
        if(grid[i][j] == -1)return;
        
        if(grid[i][j] == 1){
            grid[i][j] = -1;
        }
        
        helper(grid, i-1, j);
        helper(grid, i, j-1);
        helper(grid, i+1, j);
        helper(grid, i, j+1);
    }

    private int[] findIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}