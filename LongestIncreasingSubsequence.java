class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] dynamic = new int[nums.length];
        Arrays.fill(dynamic, 1);
        int longest = 1;
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dynamic[i] = Math.max(dynamic[i], dynamic[j] + 1);
                }
            }
            longest = Math.max(longest, dynamic[i]);
        }

        return longest;
    }
}