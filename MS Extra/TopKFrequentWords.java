class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freqMap = new HashMap<>();
        for(String str : words)
            freqMap.put(str, freqMap.getOrDefault(str, 0) + 1);
        Queue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(freqMap.get(o1) == freqMap.get(o2)){
                    return o1.compareTo(o2);
                }else{
                    return freqMap.get(o2) - freqMap.get(o1);
                }
            }
        });
        List<String> list = new ArrayList<>();
        queue.addAll(freqMap.keySet());
        while(!queue.isEmpty() && k > 0){
            list.add(queue.poll());
            k--;
        }
        return list;
    }
}