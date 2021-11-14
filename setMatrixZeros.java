class Solution {
    public void setZeroes(int[][] matrix) {
        List<int[]> list = new ArrayList();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    list.add(new int[]{i,j});
                }
            }
        }
        for(int i = 0; i < list.size(); i++){
            zeroOut(list.get(i)[0], list.get(i)[1], matrix);
        }
    }
    
    public void zeroOut(int i, int j, int[][] matrix){
        for(int x = 0; x < matrix.length; x++)
            matrix[x][j] = 0;
        for(int x = 0; x < matrix[0].length; x++)
            matrix[i][x] = 0;
    }
}