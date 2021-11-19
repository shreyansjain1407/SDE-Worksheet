class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> out = new ArrayList();
        if(nums.length < 3)return out;
        int i = 0;
        Arrays.sort(nums);
        while(i < nums.length - 2){
            int l = i+1, r = nums.length - 1;
            while(l < r){
                int temp = nums[i] + nums[l] + nums[r];
                if(temp == 0){
                    out.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[l], nums[r])));
                    while(l < r -1 && nums[l] == nums[l+1])
                        l++;
                    while(r > l && nums[r] == nums[r-1] && l < r)
                        r--;
                    l++;
                    r--;
                }else if(temp > 0){
                    r--;
                }else if(temp < 0){
                    l++;
                }
            }
            while(i < nums.length - 1 && nums[i] == nums[i+1])
                i++;
            i++;
        }
        return out;
    }
}