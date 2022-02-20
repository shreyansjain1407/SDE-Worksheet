class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int numCities = isConnected.length;
        int[] connected = new int[numCities];
        int[] visited = new int[numCities];
        int[] dfsVisited = new int[numCities];
        int count = 0;
        for(int i = 0; i < numCities; i++){
            if(visited[i] == 0) {
                dfsHelper(i, isConnected, visited, dfsVisited);
                count++;
            }
        }
        
        return count;
    }

    private void dfsHelper(int i, int[][] isConnected, int[] visited, int[] dfsVisited) {
        visited[i] = 1;
        if(dfsVisited[i] == 1)return;
        dfsVisited[i] = 1;

        for(int x = 0; x < isConnected.length; x++){
            if(isConnected[i][x] == 1 && x != i){
                isConnected[x][i] = 0;
                dfsHelper(x, isConnected, visited, dfsVisited);
            }
        }

        dfsVisited[i] = 0;
    }
}