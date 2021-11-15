class majorityElementV2 {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for(int n : nums)
            map.put(n, map.getOrDefault(n,0)+1);
        List<Integer> out = new ArrayList<>();
        long x = nums.length/3;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if (entry.getValue() > x){
                out.add(entry.getKey());
            }
        }
        return out;
    }
}