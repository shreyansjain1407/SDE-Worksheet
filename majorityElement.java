class majorityElement {
    //Primary Intuition, Follow up with O(1) space
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for(int n : nums)
            map.put(n, map.getOrDefault(n,0)+1);
        int max = 0, cur = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue()>max){
                max = entry.getValue();
                cur = entry.getKey();
            }
        }
        return cur;
    }
}

// Boyer Moore's Algorithm
// The reason this works is because the majority element always ends up coming out greater all else
// int cur = 0;
// Integer candidate = null;
// for(int num: nums) {
//     if (cur == 0)
//         candidate = num;
//     cur += (num == candidate)?1:-1;
// }
// return candidate;