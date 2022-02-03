class RandomPickIndex {
    Map<Integer, List<Integer>> nodeMap;
    Random random = new Random();
    public Solution(int[] nums) {
        nodeMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!nodeMap.containsKey(nums[i])){
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                nodeMap.put(nums[i], temp);
            }else{
                nodeMap.get(nums[i]).add(i);
            }
        }
    }

    public int pick(int target) {
        List<Integer> temp = nodeMap.get(target);
        return temp.get(random.nextInt(temp.size()));
    }
}