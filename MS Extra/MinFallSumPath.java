class MinFallSumPath {
    int[][] dp;
    public int minFallingPathSum(int[][] matrix) {
        int len = matrix.length;
        dp = new int[len][len];
        for(int[] arr : dp)
            Arrays.fill(arr, 100001);
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < len; i++){
            min = Math.min(min, fallHelper(len - 1, i, matrix));
        }

        return min;
    }

    private int fallHelper(int i, int j, int[][] matrix) {
        if(i < 0 || j < 0 || i >= dp.length || j >= dp.length)return 100001;
        if(i == 0)return dp[i][j] = matrix[i][j];
        if(dp[i][j] != 100001) return dp[i][j];

        int left = fallHelper(i-1, j-1, matrix) + matrix[i][j];
        int center = fallHelper(i-1, j, matrix) + matrix[i][j];
        int right = fallHelper(i-1, j+1, matrix) + matrix[i][j];

        return dp[i][j] = Math.min(left, Math.min(center, right));
    }
}