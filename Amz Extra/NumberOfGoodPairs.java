class NumberOfGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int key : map.keySet()){
            if(map.get(key) > 1){
                count += getCount(map.get(key));
            }
        }
        return count;
    }

    private int getCount(Integer val) {
        val--;
        return (int) (val/2.0 * (2 + (val - 1)));
    }
}