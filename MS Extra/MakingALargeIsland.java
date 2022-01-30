class MakingALargeIsland {
    int curArea = 0;
    public int largestIsland(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int componentID = 2;
        Map<Integer, Integer> compMap = new HashMap<>();
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    curArea = 0;
                    markComponent(grid, i, j, componentID);
                    compMap.put(componentID, curArea);
                    componentID++;
                }else if(grid[i][j] == 0){
                    queue.add(new int[]{i,j});
                }
            }
        }
        if(compMap.size() == 0)
            return 1;

        System.out.println(compMap);
        if(queue.isEmpty())
            return grid.length * grid[0].length;

        int maxArea = 0;
        while(!queue.isEmpty()){
            maxArea = Math.max(maxArea, getArea(grid, compMap, queue.poll()));
        }
        return maxArea;
    }

    private int getArea(int[][] grid, Map<Integer, Integer> compMap, int[] poll) {
        int i = poll[0], j = poll[1];
        System.out.println(i + " " + j);
        int area = 0;
        Set<Integer> set = new HashSet<>();
        if(i>0 && grid[i-1][j] != 0 && set.add(grid[i-1][j])){
            System.out.println("TOP");
            area += compMap.get(grid[i-1][j]);
        }
        if(j>0 && grid[i][j-1] != 0 && set.add(grid[i][j-1])){
            System.out.println("LEFT");
            area += compMap.get(grid[i][j-1]);
        }
        if(i < grid.length - 1 && grid[i+1][j] != 0 && set.add(grid[i+1][j])){
            System.out.println("BOTTOM");
            area += compMap.get(grid[i+1][j]);
        }
        if(j < grid[0].length - 1 && grid[i][j+1] != 0 && set.add(grid[i][j+1])){
            System.out.println("RIGHT");
            area += compMap.get(grid[i][j+1]);
        }
        return area+1;
    }

    private void markComponent(int[][] grid, int i, int j, int componentID) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0)
            return;

        if(grid[i][j] == 1){
            grid[i][j] = componentID;
            curArea++;
        }

        markComponent(grid, i-1, j, componentID);
        markComponent(grid, i, j-1, componentID);
        markComponent(grid, i+1, j, componentID);
        markComponent(grid, i, j+1, componentID);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largestIsland(new int[][]{{1,0},{0,1}}));
    }
}