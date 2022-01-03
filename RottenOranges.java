class RottenOranges {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue= new LinkedList<int[]>();
        //Initializing the number of oranges that are rotten and calculating the number of freash oranges
        int fresh = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        if (fresh == 0){
            return 0;
        }
        if (queue.size() == 0){
            return -1;
        }
        int minutes = -1;
        while(queue.size() != 0){
            minutes++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] temp = queue.poll();
                if(temp[0] > 0){
                    if(grid[temp[0]-1][temp[1]] == 1){
                        grid[temp[0]-1][temp[1]] = 2;
                        queue.offer(new int[]{temp[0]-1, temp[1]});
                    }
                }
                if(temp[1] > 0){
                    if(grid[temp[0]][temp[1]-1] == 1){
                        grid[temp[0]][temp[1]-1] = 2;
                        queue.offer(new int[]{temp[0], temp[1]-1});
                    }
                }
                if (temp[0] < grid.length-1){
                    if(grid[temp[0]+1][temp[1]] == 1){
                        grid[temp[0]+1][temp[1]] = 2;
                        queue.offer(new int[]{temp[0]+1, temp[1]});
                    }
                }
                if(temp[1] < grid[0].length -1){
                    if(grid[temp[0]][temp[1]+1] == 1){
                        grid[temp[0]][temp[1]+1] = 2;
                        queue.offer(new int[]{temp[0], temp[1]+1});
                    }
                }
            }
            fresh -= queue.size();
        }

        return (fresh != 0)?-1:minutes;
    }
}