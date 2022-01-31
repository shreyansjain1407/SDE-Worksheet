class FindLocalPeak {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1)return 0;
        if(nums.length == 2){
            return nums[0] > nums[1] ? 0 : 1;
        }
        for(int i = 0; i < nums.length; i++){
            if(i == 0 || i == (nums.length - 1)){
                if(i == 0 && nums[i] > nums[1]){
                    return 0;
                }else if (i == nums.length - 1){
                    if(nums[i] > nums[i-1]){
                        return i;
                    }
                }
                continue;
            }
            if(nums[i] > nums[i-1] && nums[i] > nums[i+1]){
                return i;
            }
        }
        return -1;
    }
}