class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length() == 0 || text2.length() == 0){
            return 0;
        }
        int[][] dp = new int[text1.length()+1][text2.length()+1];

        for(int i = text1.length() - 1; i >= 0; i--){
            char c = text1.charAt(i);
            for(int j = text2.length() - 1; j >= 0; j--){
                if(text2.charAt(j) == c){
                    dp[i][j] = dp[i+1][j+1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        return dp[0][0];
    }
}