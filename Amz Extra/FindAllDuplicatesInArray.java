class FindAllDuplicatesInArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> output = new ArrayList();
        for(int i = 0; i < nums.length; i++){
            int cur = Math.abs(nums[i]);
            if(nums[cur - 1] < 0){
                output.add(cur);
            }else{
                nums[cur - 1] = -nums[cur - 1];
            }
        }
        return output;
    }
}