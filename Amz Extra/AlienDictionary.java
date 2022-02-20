class AlienDictionary {
    public String alienOrder(String[] words) {
        Map<Character, ArrayList<Character>> adjList = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        for(String str : words){
            for(char c : str.toCharArray()){
                indegree.putIfAbsent(c, 0);
                adjList.putIfAbsent(c,new ArrayList<>());
            }
        }

        for(int i = 0; i < words.length - 1; i++){
            String s1 = words[i];
            String s2 = words[i+1];
            if(s1.length() > s2.length() && s1.startsWith(s2)){
                return "";
            }
            for(int j = 0; j < Math.min(s1.length(), s2.length()); j++){
                if(s1.charAt(j) != s2.charAt(j)){
                    adjList.get(s1.charAt(j)).add(s2.charAt(j));
                    indegree.put(s2.charAt(j), indegree.getOrDefault(s2.charAt(j), 0) + 1);
                    break;
                }
            }
        }
        //Let's check if the graph that we have is acyclic
        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new LinkedList<>();
        for(Character c : indegree.keySet()){
            if(indegree.get(c) == 0)
                q.offer(c);
        }

        while(!q.isEmpty()){
            Character c = q.poll();
            sb.append(c);
            for(Character x : adjList.get(c)){
                indegree.put(x, indegree.get(x) - 1);
                if(indegree.get(x) == 0){
                    q.offer(x);
                }
            }
        }

        if(sb.length() != indegree.size())
            return "";
        return sb.toString();
    }
}