class CountSquareSubMatricesWithAllOnes {
    public int countSquares(int[][] matrix) {
        int count = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 1){
                    count++;
                    if(i > 0 && j > 0){
                        matrix[i][j] = Math.min(matrix[i-1][j-1], Math.min(matrix[i-1][j], matrix[i][j-1])) + 1;
                        count += matrix[i][j] - 1;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        sb.append("[");
        for(int i = 0; i < 300; i++){
            sb.append("[");
            for(int j = 0; j < 300; j++){
                sb.append(random.nextInt(2)).append(",");
            }
            sb.setLength(sb.length() - 1);
            sb.append("],");
        }
        sb.setLength(sb.length()-1);
        sb.append("]");
        System.out.println(sb.toString());
    }
}