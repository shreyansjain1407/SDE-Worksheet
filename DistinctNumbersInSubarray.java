class DistinctNumbersInSubarray {
    public int[] distinctNumbers(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] distincts = new int[nums.length - k + 1];
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if(i - k >= 0){
                if(map.get(nums[i-k]) > 1){
                    map.put(nums[i-k], map.get(nums[i-k]) - 1);
                }else{
                    map.remove(nums[i-k]);
                }
            }
            if(i - k + 1 >= 0){
                distincts[j++] = map.size();
            }
        }
        
        return distincts;
    }
}