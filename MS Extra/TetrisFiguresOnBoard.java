class TetrisFiguresOnBoard {
    Map<Integer, List<int[]>> map = new HashMap<>();
    public int[][] develop(int n, int m, int[] figures){
        int[][] board = new int[n][m];

        List<int[]> one = new ArrayList<>();
        List<int[]> two = new ArrayList<>();
        List<int[]> three = new ArrayList<>();
        List<int[]> four = new ArrayList<>();
        List<int[]> five = new ArrayList<>();

        one.add(new int[]{0,0});

        two.add(new int[]{0,0});
        two.add(new int[]{0,1});
        two.add(new int[]{0,1});

        three.add(new int[]{0,0});
        three.add(new int[]{0,1});
        three.add(new int[]{1,0});
        three.add(new int[]{0,-1});

        four.add(new int[]{0,0});
        four.add(new int[]{1,0});
        four.add(new int[]{0,1});
        four.add(new int[]{0,-1});
        four.add(new int[]{1,0});

        five.add(new int[]{0,0});
        five.add(new int[]{0,1});
        five.add(new int[]{1,0});
        five.add(new int[]{-1,0});
        five.add(new int[]{0,1});

        map.put(1, one);
        map.put(2, two);
        map.put(3, three);
        map.put(4, four);
        map.put(5, five);

        int index = 0;
        
        for(int i = 0; i < n && index < figures.length; i++){
            for(int j = 0; j < m && index < figures.length; j++){
                if(board[i][j] == 0){
                    if(createFigure(figures[i], board, index+1, i, j))
                        i++;
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println(" ");
        }

        return board;
    }

    private boolean createFigure(int figure, int[][] curBoard, int index, int i, int j) {
        System.out.println(i + " " + j + " " + figure);
        boolean complete = true;
        int a = i, b = j;
        int[][] board = curBoard;
        List<int[]> fig = map.get(figure);
        for(int[] x : fig){
            i = i+x[0];
            j = j+x[1];
            if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 0){
                complete = false;
                break;
            }
        }
        i = a; j = b;
        System.out.println(complete);
        if(complete){
            for(int[] x : fig){
                i = i+x[0];
                j = j+x[1];
                curBoard[i][j] = index;
            }
        }

        return complete;
    }

    public static void main(String[] args) {
        new Scratch().develop(4,4, new int[]{4,2,1,3});
    }
}