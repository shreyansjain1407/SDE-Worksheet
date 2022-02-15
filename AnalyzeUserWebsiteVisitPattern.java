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
class AnalyzeUserWebsiteVisitPattern {
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
        return Arrays.asList(output.trim().split(" "));
    }

    private void putAllCombinations(Queue<Node> dq, Map<String, Integer> map) {
        if(dq.size() < 3)return;
        List<String> visits = new ArrayList<>();
        while(!dq.isEmpty()){
            visits.add(dq.poll().web);
        }
        System.out.println("LIST: " + visits);
        for(int i = 0; i < visits.size()-2; i++){
            StringBuilder sb = new StringBuilder(visits.get(i)).append(" ");
            for(int j = i+1; j < visits.size()-1; j++){
                sb.append(visits.get(j)).append(" ");
                for (int k = j+1; k < visits.size(); k++){
                    sb.append(visits.get(k));
                    System.out.println(sb.toString());
                    map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
                    sb.setLength(sb.length() - visits.get(k).length());
                }
                sb.setLength(sb.length() - visits.get(j).length()+1);
            }
            sb.setLength(sb.length() - visits.get(i).length()+1);
        }
    }
}