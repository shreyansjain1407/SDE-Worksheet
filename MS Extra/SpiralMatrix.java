class SpiralMatrix {
    enum Direction {
        F, D, B, U
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int minRow = 0, minCol = 0, maxRow = row - 1, maxCol = col - 1, i = 0, j = 0;
        List<Integer> parseMatrix = new ArrayList<Integer>();
        Direction dir = Direction.F;
        while(parseMatrix.size() < row*col){
            if(dir == Direction.F){
                parseMatrix.add(matrix[i][j]);
                if(j < maxCol){
                    j++;
                }else{
                    dir = Direction.D;
                    minRow++;
                    i++;
                }
            }else if(dir == Direction.D){
                parseMatrix.add(matrix[i][j]);
                if(i < maxRow){
                    i++;
                }else{
                    dir = Direction.B;
                    maxCol--;
                    j--;
                }
            }else if(dir == Direction.B){
                parseMatrix.add(matrix[i][j]);
                if(j > minCol){
                    j--;
                }else{
                    dir = Direction.U;
                    maxRow--;
                    i--;
                }
            }else{
                parseMatrix.add(matrix[i][j]);
                if(i > minRow){
                    i--;
                }else{
                    dir = Direction.F;
                    minCol++;
                    j++;
                }
            }
        }
        return parseMatrix;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        System.out.println(new Scratch().spiralOrder(arr));
    }
}