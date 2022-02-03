class WallsAndGatesBFS {
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> gates = new LinkedList<>(findGates(rooms));
        int curDist = 0;
        while (!gates.isEmpty()){
            int size = gates.size();
            for(int i = 0; i < size; i++){
                int[] temp = gates.poll();
                if(rooms[temp[0]][temp[1]] >= curDist){
                    rooms[temp[0]][temp[1]] = curDist;
                    gates.addAll(getAdjacentRooms(temp, curDist + 1, rooms));
                }
            }
            curDist++;
        }
    }

    public static int[][] directions = {{0,-1}, {-1,0}, {0,1}, {1,0}};
    private List<int[]> getAdjacentRooms(int[] temp, int distance, int[][] rooms) {
        List<int[]> adjRooms = new ArrayList<>();
//        int row = temp[0];
//        int col = temp[1];
        for(int[] dir : directions){
            int curRow = temp[0] + dir[0], curCol = temp[1] + dir[1];
            if(curRow < 0 || curCol < 0 || curRow >= rooms.length || curCol >= rooms[0].length || rooms[curRow][curCol] == -1)
                continue;
            if(rooms[curRow][curCol] > distance)
                adjRooms.add(new int[]{curRow, curCol});
        }
        return adjRooms;
    }

    private List<int[]> findGates(int[][] rooms) {
        List<int[]> gates = new ArrayList<>();
        for(int i = 0; i < rooms.length; i++)
            for(int j = 0; j < rooms[0].length; j++)
                if(rooms[i][j] == 0)
                    gates.add(new int[]{i,j});

        return gates;
    }
}