class RemoveDuplicatesInPlace {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0)return 0;
        int left = 1, cur = 1, curNum = nums[0];
        // int count = 0;
        while(left < nums.length){
            if(curNum == nums[left]){
                left++;
            }else{
                nums[cur] = nums[left];
                cur++;
                curNum = nums[left];
            }
        }
        return cur;
    }
}