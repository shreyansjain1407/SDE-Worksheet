class Direction {
    int[] curVal;
    Direction left;
    Direction right;

    public Direction(int[] curVal) {
        this.curVal = curVal;
    }

    public Direction(int[] curVal, Direction left, Direction right) {
        this.curVal = curVal;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public boolean isRobotBounded(String instructions) {
        Direction N = new Direction(new int[]{0,1});
        Direction S = new Direction(new int[]{0,-1});
        Direction E = new Direction(new int[]{1,0}, N, S);
        Direction W = new Direction(new int[]{-1,0}, S, N);
        N.left = W;
        N.right = E;
        S.left = E;
        S.right = W;

        int[] loc = {0,0};
        Direction curDir = N;
        for (int i = 0; i < instructions.length(); i++) {
            char cur = instructions.charAt(i);
            if (cur == 'G') {
                loc[0] += curDir.curVal[0];
                loc[1] += curDir.curVal[1];
            } else if (cur == 'L') {
                curDir = curDir.left;
            } else {
                curDir = curDir.right;
            }
        }
        return loc[0] == 0 && loc[1] == 0 || curDir != N;
    }

    public static void main(String[] args) {
        char[] dir = {'G', 'L', 'R'};
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i < 100; i++){
            sb.append(dir[random.nextInt(3)]);
        }
        System.out.println(sb);
    }
}