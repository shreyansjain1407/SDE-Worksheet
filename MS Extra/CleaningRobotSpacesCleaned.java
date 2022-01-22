enum Direction {
    L,D,R,U
}

class Scratch {
    public int numberOfCleanRooms(int[][] room) {
        Direction dir = Direction.L;
        int row = room.length, col = room[0].length;
        System.out.println(row + " " + col + " ROW AND COL");
        int roomsCleaned = 0;
        int i = 0, j = 0;
        int prevRooms = 0;
        Direction prevDirection = Direction.U;
        boolean loopVar = true;
        while(loopVar){
            if(room[i][j] == 0){
                room[i][j] = 2;
                roomsCleaned++;
            }
            if(prevRooms < roomsCleaned){
                prevRooms = roomsCleaned;
                prevDirection = dir;
            } else if(dir == prevDirection){
                loopVar = false;
            }
            switch(dir){
                case R :
                    if(j < col-1 && room[i][j+1] == 0){
                        j++;
                    }else if(j < col-1 && room[i][j+1] == 2){
                        loopVar = false;
                        System.out.println("EXE R");
                    }else{
                        dir = Direction.D;
                    }
                    break;
                case D :
                    if(i < row-1 && room[i+1][j] == 0){
                        i++;
                    }else if(i < row-1 && room[i+1][j] == 2){
                        loopVar = false;
                        System.out.println("EXE D");
                    }else{
                        dir = Direction.L;
                    }
                    break;
                case L :
                    if(j > 0 && room[i][j-1] == 0){
                        j--;
                    }else if(j > 0 && room[i][j-1] == 2){
                        loopVar = false;
                        System.out.println("EXE L");
                    }else{
                        dir = Direction.U;
                    }
                    break;
                case U :
                    if(i > 0 && room[i-1][j] == 0){
                        i--;
                    }else if(i > 0 && room[i-1][j] == 2){
                        loopVar = false;
                        System.out.println("EXE U");
                    }else{
                        dir = Direction.R;
                    }
                    break;
            }
        }
        return roomsCleaned;
    }

    public static void main(String[] args) {
//        int[][] arr = new int[][]{{0,0,0,0,0,0,0},{1,1,1,1,1,1,0},{0,0,0,0,0,0,0},{0,1,1,1,1,1,1},{0,0,0,0,0,0,0},{1,1,1,1,1,1,0}};
//        System.out.println(new Scratch().numberOfCleanRooms(arr));
        System.out.println(new Scratch().numberOfCleanRooms(new int[][]{{0,0,0,1},{0,1,0,1},{1,0,0,0}}));
//        System.out.println(new Scratch().numberOfCleanRooms(new int[][]{{0,0,0},{1,1,0},{0,0,0}}));
//        System.out.println(new Scratch().numberOfCleanRooms(new int[][]{{0,1,0},{1,0,0},{0,0,0}}));
        String x = "[[0,0,0,1],[0,1,0,1],[1,0,0,0]]";
        x = x.replace("[", "{").replace("]","}");
        System.out.println(x);
    }
}