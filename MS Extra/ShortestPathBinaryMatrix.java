class ShortestPathBinaryMatrix {

    private static final int[][] directions =
            new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {

        // Firstly, we need to check that the start and target cells are open.
        if (grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) {
            return -1;
        }

        // Set up the BFS.
        Queue<int[]> queue = new ArrayDeque<>();
        grid[0][0] = 1;
        queue.add(new int[]{0, 0});

        // Carry out the BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.remove();
            int row = cell[0];
            int col = cell[1];
            int distance = grid[row][col];
            if (row == grid.length - 1 && col == grid[0].length - 1) {
                return distance;
            }
            for (int[] neighbour : getNeighbours(row, col, grid)) {
                int neighbourRow = neighbour[0];
                int neighbourCol = neighbour[1];
                queue.add(new int[]{neighbourRow, neighbourCol});
                grid[neighbourRow][neighbourCol] = distance + 1;
            }
        }

        // The target was unreachable.
        return -1;
    }

    private List<int[]> getNeighbours(int row, int col, int[][] grid) {
        List<int[]> neighbours = new ArrayList<>();
        for (int i = 0; i < directions.length; i++) {
            int newRow = row + directions[i][0];
            int newCol = col + directions[i][1];
            if (newRow < 0 || newCol < 0 || newRow >= grid.length
                    || newCol >= grid[0].length
                    || grid[newRow][newCol] != 0) {
                continue;
            }
            neighbours.add(new int[]{newRow, newCol});
        }
        return neighbours;
    }

}

class Solution {
    private static final int[][] directions = {{-1,-1},{-1,0},{0,-1},{1,-1},{-1,1},{1,1},{1,0},{0,1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1)return -1;
        Queue<int[]> next = new LinkedList<>();
        next.add(new int[]{0,0});
        int n = grid.length - 1;
        int distance = 0;
        while(!next.isEmpty()){
            int size = next.size();
            for(int i = 0; i < size; i++){
                int[] temp = next.poll();
                if(temp[0] == n && temp[1] == n){
                    return distance;
                }
                next.addAll(getNext(grid, temp[0], temp[1]));
            }
            distance++;
        }
        return -1;
    }

    private List<int[]> getNext(int[][] grid, int i, int j) {
        grid[i][j] = -1;
        int n = grid.length - 1;
        List<int[]> list = new ArrayList<>();
        for(int[] dir : directions){
            int x = i + dir[0];
            int y = j + dir[1];
            if(x < 0 || y < 0 || x > n || y > n || grid[x][y] != 0)continue;
            list.add(new int[]{x,y});
        }
        return list;
    }
}