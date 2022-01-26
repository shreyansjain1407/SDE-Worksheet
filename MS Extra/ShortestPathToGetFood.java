class ShortestPathToGetFood {
    // 74 / 85 Test Cases, Time Limit Exceeded
    int minDistance = Integer.MAX_VALUE;
    int[][] curDistance;
    public int getFood(char[][] grid) {
        curDistance = new int[grid.length][grid[0].length];
        for(int[] nums: curDistance)
            Arrays.fill(nums, Integer.MAX_VALUE);

        int[] loc = findStart(grid);
        helper(grid, loc[0], loc[1], 0);

        return (minDistance == Integer.MAX_VALUE)?-1: minDistance;
    }

    private void helper(char[][] grid, int row, int col, int curDist) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 'X' || curDistance[row][col] <= curDist)return;

        if(grid[row][col] == '#'){
            minDistance = Math.min(minDistance, curDist);
            return;
        }
        curDistance[row][col] = curDist;
        helper(grid, row+1, col, curDist + 1);
        helper(grid, row, col+1, curDist + 1);
        helper(grid, row-1, col, curDist + 1);
        helper(grid, row, col-1, curDist + 1);

    }

    private int[] findStart(char[][] grid) {
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '*'){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1,-1};
    }
}