class MostFreqKUniqueInt {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums)
            map.put(num, map.getOrDefault(num, 0)+1);
        Queue<Integer> queue = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        queue.addAll(map.keySet());
        int[] arr = new int[k];
        int i = 0;
        while (i < k)
            arr[i++] = queue.poll();
        return arr;
    }
}