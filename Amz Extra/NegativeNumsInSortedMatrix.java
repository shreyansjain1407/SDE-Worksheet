class NegativeNumsInSortedMatrix {
    public int countNegatives(int[][] grid) {
        int i = grid.length-1;
        int j = 0;
        int count = 0;
        while(i >= 0 && j < grid[0].length){
            if(grid[i][j] < 0){
                count += grid[0].length - j;
                i--;
            }else{
                j++;
            }
        }
        return count;
    }
}