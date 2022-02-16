class SnakesAndLadders {
    int n;
    public int snakesAndLadders(int[][] board) {
        n = board.length;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 1; i <= n*n; i++){
            int[] pos = getPosition(i);
            if(board[pos[0]][pos[1]] != -1){
                map.put(i, board[pos[0]][pos[1]]);
            }
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        int steps = 0, v = 1;
        while(queue.size() > 0){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                v = queue.poll();
                if(v >= n*n) return steps;
                if(visited.contains(v))continue;
                visited.add(v);
                
                for(int die = 1; die <= 6; die++){
                    int x = v+die;
                    queue.offer(map.getOrDefault(x, x));
                }
            }
            steps++;
        }

        return -1;
    }
    private int[] getPosition(int i) {
//        System.out.println(n);
        int row = (i-1)/n;
        int col = (i-1) % n;
//        System.out.println("i: " + i + " Row: " + row + " Col: " + col);
        if(row % 2 == 1){
            return new int[]{n - row - 1, n - col - 1};
        }else{
            return new int[]{n - row - 1, col};
        }
    }
}