class CheckBipartite {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);
        for(int i = 0; i < graph.length; i++){
            if(colors[i] == -1){
                if(!bfs(graph, colors, i))return false;
            }
        }
        return true;
    }

    private boolean bfs(int[][] graph, int[] colors, int x) {
        int initColor = 1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i = 0; i < graph[cur].length; i++){
                if(colors[graph[cur][i]] == -1){
                    colors[graph[cur][i]] = 1-colors[cur];
                    q.add(graph[cur][i]);
                }else if(colors[graph[cur][i]] == colors[cur]){
                    return false;
                }
            }
        }
        return true;
    }
}