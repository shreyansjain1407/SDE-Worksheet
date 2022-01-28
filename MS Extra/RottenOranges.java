class RottenOranges {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> rotten = new LinkedList<>();
        int fresh = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2)
                    rotten.add(new int[]{i,j});
                else if(grid[i][j] == 1)
                    fresh++;
            }
        }
        if(fresh == 0)return 0;
        int minutes = 0;
        while(!rotten.isEmpty()){
            int size = rotten.size();
            for(int i = 0; i < size; i++){
                int[] temp = rotten.poll();
                addRotten(temp[0]-1, temp[1], rotten, grid);
                addRotten(temp[0], temp[1]-1, rotten, grid);
                addRotten(temp[0]+1, temp[1], rotten, grid);
                addRotten(temp[0], temp[1]+1, rotten, grid);
            }
            fresh -= rotten.size();
            if(rotten.size() > 0)minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }

    private void addRotten(int i, int j, Queue<int[]> rotten, int[][] grid) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1){
            return;
        }
        if(grid[i][j] == 1){
            rotten.add(new int[]{i, j});
            grid[i][j] = 2;
        }
    }
}