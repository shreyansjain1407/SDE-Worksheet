class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, i = 0;
        while(i < nums.length){
            if(nums[i] == 1){
                int cur = 0, x = i;
                while(x < nums.length && nums[x] == 1){
                    cur++;
                    x++;
                }
                max = Math.max(cur, max);
                i = x;
            }else{
                i++;
            }
        }
        return max;
    }
}