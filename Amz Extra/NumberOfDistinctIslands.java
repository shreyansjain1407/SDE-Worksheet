class NumberOfDistinctIslands {
    public int numDistinctIslands(int[][] grid) {
        Map<List<Integer>, Integer> map = new HashMap<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    List<Integer> temp = new ArrayList<>();
                    getIslands(grid, i, j, i, j, temp);
                    map.put(temp, map.getOrDefault(temp, 0) + 1);
                }
            }
        }
        return map.size();
    }

    private void getIslands(int[][] grid, int i, int j, int iInit, int jInit, List<Integer> temp) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0)return;

        temp.add(i - iInit);
        temp.add(j - jInit);
        grid[i][j] = 0;
        
        getIslands(grid, i+1, j, iInit, jInit, temp);
        getIslands(grid, i, j+1, iInit, jInit, temp);
        getIslands(grid, i-1, j, iInit, jInit, temp);
        getIslands(grid, i, j-1, iInit, jInit, temp);
    }
}