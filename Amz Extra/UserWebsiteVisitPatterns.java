class Node{
    String user;
    int time;
    String web;

    public Node(String user, int time, String web) {
        this.user = user;
        this.time = time;
        this.web = web;
    }
}
class UserWebsiteVisitPatterns {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Queue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.user.equals(o2.user)){
                    return o1.time - o2.time;
                }else{
                    return o1.user.compareTo(o2.user);
                }
            }
        });
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < username.length; i++){
            queue.add(new Node(username[i], timestamp[i], website[i]));
        }
        Queue<Node> dq = new LinkedList<>();
        dq.add(queue.peek());
        String curUser = queue.poll().user;
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            if(temp.user.equals(curUser)){
                dq.offer(temp);
            }else{
                putAllCombinations(dq, map);
                dq.clear();
                dq.offer(temp);
                curUser = temp.user;
            }
        }
        if(dq.size() >= 3){
            putAllCombinations(dq, map);
        }
        String output = "";
        int curMax = 0;
        for(String key: map.keySet()){
            if(map.get(key) > curMax){
                output = key;
                curMax = map.get(key);
            }else if(map.get(key) == curMax){
                output = key.compareTo(output) < 1 ? key : output;
            }
        }
        return Arrays.asList(output.trim().split(","));
    }

    private void putAllCombinations(Queue<Node> dq, Map<String, Integer> map) {
        if(dq.size() < 3)return;
        List<String> visits = new ArrayList<>();
        while(!dq.isEmpty()){
            visits.add(dq.poll().web);
        }
        Set<String> set = new HashSet<>();
        for(int i = 0; i < visits.size()-2; i++){
            for(int j = i+1; j < visits.size()-1; j++){
                for (int k = j+1; k < visits.size(); k++){
                    String webPattern = visits.get(i) + "," + visits.get(j) + "," + visits.get(k);
                    if(!set.contains(webPattern))map.put(webPattern, map.getOrDefault(webPattern, 0) + 1);
                    set.add(webPattern);
                }
            }
        }
    }
}