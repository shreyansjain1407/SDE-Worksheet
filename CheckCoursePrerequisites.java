class CheckCoursePrerequisites {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];
        int[] topologicalOrder = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] preReq : prerequisites){
            adj.get(preReq[1]).add(preReq[0]);
            indegree[preReq[0]]++;
        }
        Queue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0)
                queue.offer(i);
        }
        int i = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            topologicalOrder[i++] = node;
            if(adj.get(node).size()>0){
                for(int nextNode : adj.get(node)){
                    indegree[nextNode]--;
                    if(indegree[nextNode] == 0){
                        queue.offer(nextNode);
                    }
                }
            }
        }
        if(i == numCourses){
            return topologicalOrder;
        }
        return new int[0];
    }
}