class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int i = 0, left, right;
        int min = Integer.MAX_VALUE, output = Integer.MAX_VALUE;
        Arrays.sort(nums);
        // -3, 0, 1, 2
        while (i < nums.length - 2){
            left = i+1;
            right = nums.length-1;
            while(left < right){
                int cur = nums[i] + nums[left] + nums[right];
                if(min > Math.abs(cur - target)){
                    min = Math.abs(cur - target);
                    output = cur;
                    // left++;right--;
                }
                if(cur < target){
                    left++;
                }else{
                    right--;
                }
            }
            i++;
        }
        return output;
    }
}