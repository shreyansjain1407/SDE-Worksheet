class searchIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length-1, j = 0;
        boolean found = false;
        while(j < matrix[0].length && i >= 0){
            if(matrix[i][j] == target){
                found = true;
                break;
            }else if(matrix[i][j] < target){
                j++;
            }else
                i--;
        }

        return found;
    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,0,0,0};
        int[] arr4 = {2,5,6};
        int[][] arr5 = {{1,4},{2,3}};
        System.out.println((new Scratch()).searchMatrix(arr5, 10));
//        System.out.println(Arrays.toString(arr));
    }
}