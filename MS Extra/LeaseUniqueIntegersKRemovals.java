class LeaseUniqueIntegersKRemovals {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num: arr)
            map.put(num, map.getOrDefault(num, 0)+1);
        Queue<Integer> queue = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));
        queue.addAll(map.keySet());
        while(k > 0){
            if(map.get(queue.peek()) <= k){
                k -= map.get(queue.peek());
                map.remove(queue.poll());
            }else{
                map.put(queue.peek(), map.get(queue.peek()) - k);
                k = 0;
            }
        }
        return map.size();
    }
}