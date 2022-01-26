import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class MaxDistToClosestPerson {
    public int maxDistToClosest(int[] seats) {
        Queue<Integer> filled = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0; i < seats.length; i++){
            if(seats[i] == 1){
                filled.add(i);
            }
        }
        int prev = seats[seats.length - 1] == 0 ? -1:seats.length-1;
        int curMax = 0;
        while(!filled.isEmpty()){
            int nextSeated = filled.poll();
            if(prev == -1){
                curMax = Math.max(curMax, seats.length - 1 - nextSeated);
            }else{
                curMax = Math.max(curMax, (prev - nextSeated)/2);
            }
            prev = nextSeated;
        }
        if(prev > 0){
            curMax = Math.max(curMax, prev);
        }
        return curMax;
    }

    public static void main(String[] args) {
        System.out.println(new Scratch().maxDistToClosest(new int[]{1,1,1,1,1,1,0,1,1,1,1}));
    }
}