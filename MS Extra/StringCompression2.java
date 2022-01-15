class StringCompression2 {
    public int getLengthOfOptimalCompression(String s, int k) {
        Map<Character, Integer> freqMap = new HashMap<>();
        //We can also use an array of length 26 instead of the map
        for(char c: s.toCharArray()){
            freqMap.put(c, freqMap.getOrDefault(c,0)+1);
        }
        Queue<Character> queue = new PriorityQueue<>(Comparator.comparingInt(freqMap::get));
        queue.addAll(freqMap.keySet());
        while(queue.size()>0 && k>0){
            char c = queue.poll();
            int val = freqMap.get(c);
            if(val <= k){
                k -= val;
                freqMap.remove(c);
            }else{
                val -= k;
                k = 0;
                freqMap.put(c,val);
                queue.offer(c);
            }
        }
        System.out.println(freqMap);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!freqMap.containsKey(c))
                continue;
            int val = freqMap.get(c);
            if(val == 1){
                sb.append(c);
            }else{
                sb.append(c);
                sb.append(val);
            }
            freqMap.remove(c);
        }
        return sb.toString().length();
    }

    public static void main(String[] args) {
        System.out.println(new Scratch().getLengthOfOptimalCompression("aaaaaaaaaabbbbbbbbbbcccccccccc", 2));
    }
}