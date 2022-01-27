class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> outputList = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0, l = 0, r = 0;
        while(i < nums.length){
            l = i+1;
            r = nums.length - 1;
            while (l < r){
                int curSum = nums[i] + nums[l] + nums[r];
                if(curSum == 0){
                    outputList.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l+1]){
                        l++;
                    }
                    while (r > l && nums[r] == nums[r-1]){
                        r--;
                    }
                    l++;r--;
                }else if(curSum < 0){
                    l++;
                }else{
                    r--;
                }
            }
            i++;
            while(i < nums.length && nums[i-1] == nums[i]){
                i++;
            }
        }
        return outputList;
    }
}