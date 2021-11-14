import java.util.Arrays;

class rotateImage {
    public void rotate(int[][] matrix) {
        int l = 0, r = matrix.length;
        int n = matrix.length-1;
        while(l < r){
            for(int i = l; i < r-1; i++){
                int temp = matrix[l][i];
                matrix[l][i] = matrix[n-i][l];
                matrix[n-i][l] = matrix[n-l][n-i];
                matrix[n-l][n-i] = matrix[i][n-l];
                matrix[i][n-l] = temp;
            }
            l++;r--;
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] arr1 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] arr2 = {{1}};
        int[][] arr3 = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        (new Scratch()).rotate(arr3);
        for (int[] ints : arr3) System.out.println(Arrays.toString(ints));
    }
}