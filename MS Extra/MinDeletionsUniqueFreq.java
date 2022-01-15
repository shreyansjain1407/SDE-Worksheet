class MinDeletionsUniqueFreq {
    public int minDeletions(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char c : s.toCharArray()){
            freqMap.put(c, freqMap.getOrDefault(c, 0)+1);
        }
        Queue<Character> queue = new PriorityQueue<>((a,b) -> freqMap.get(b)-freqMap.get(a));
        queue.addAll(freqMap.keySet());
        int deletions = 0;
        int prevFreq = freqMap.get(queue.poll());
        while(queue.size() > 0){
            int currentFreq = freqMap.get(queue.poll());
            while(currentFreq >= prevFreq){
                currentFreq--;
                deletions++;
            }
            prevFreq = currentFreq;
            if(currentFreq == 0)break;
        }
        while(queue.size() > 0)
            deletions += freqMap.get(queue.poll());
        
        return deletions;

        //Approach 2
        public int minDeletionsApr2(String s) {
            int[] arr = new int[26];
            for(char c: s.toCharArray()){
                arr[c - 'a']++;
            }
            
            int deletions = 0;
            Set<Integer> frequencies = new HashSet<Integer>();
            for(int i = 0; i < 26; i++){
                while(arr[i] > 0 && frequencies.contains(arr[i])){
                    arr[i]--;deletions++;
                }
                frequencies.add(arr[i]);
            }
            return deletions;
        }
    }
}