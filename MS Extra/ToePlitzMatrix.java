class ToePlitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int i = 0; i < matrix[0].length; i++){
            if(!checkDiagonal(0, i, matrix))
                return false;
        }
        for(int i = 1; i < matrix.length; i++){
            if(!checkDiagonal(i,0, matrix))
                return false;
        }
        return false;
    }

    private boolean checkDiagonal(int i, int j, int[][] matrix) {
        int cur = matrix[i][j];
        while(i < matrix.length && j < matrix[0].length){
            if(matrix[i][j] != cur) {
                System.out.println(matrix[i][j] + cur);
                return false;
            }
            i++; j++;
        }
        return true;
    }
}