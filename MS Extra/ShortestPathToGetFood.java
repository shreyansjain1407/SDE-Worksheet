class ShortestPathToGetFood {
    // 74 / 85 Test Cases, Time Limit Exceeded
    // Approach 1
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

class Solution {
    //Approach 2 All test cases cleared
    int minDistance = Integer.MAX_VALUE;
    final int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
    public int getFood(char[][] grid) {

        int[] loc = findStart(grid);
        grid[loc[0]][loc[1]] = 'X';
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(loc);

        int distance = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : directions) {
                    int[] step = {cur[0] + dir[0], cur[1] + dir[1]};
                    if (valid(step, grid)) {
                        if (grid[step[0]][step[1]] == '#') {
                            return distance + 1;
                        }
                        grid[step[0]][step[1]] = 'X';
                        queue.offer(step);
                    }
                }
            }
            distance++;
        }

        return -1;
    }

    private boolean valid(int[] step, char[][] grid) {
        int row = step[0], col = step[1];
        return row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && grid[row][col] != 'X';
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