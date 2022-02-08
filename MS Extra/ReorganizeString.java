class ReorganizeString {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Queue<Character> queue = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        queue.addAll(map.keySet());
        StringBuilder sb = new StringBuilder();
        while(queue.size() > 1){
            char c1 = queue.poll();
            char c2 = queue.poll();
            sb.append(c1).append(c2);
            if(map.get(c1) > 1) {
                map.put(c1, map.get(c1) - 1);
                queue.offer(c1);
            }else
                map.remove(c1);

            if(map.get(c2) > 1) {
                map.put(c2, map.get(c2) - 1);
                queue.offer(c2);
            }else
                map.remove(c2);
        }
        if(!queue.isEmpty()) {
            if (map.get(queue.peek()) > 1)
                return "";
            sb.append(queue.poll());
        }
        return sb.toString();
    }
}