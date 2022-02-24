import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CountingCars {
    public List<Integer> getMaxCount(int[] numCars, int[] hourStart){
        int[] curMax = new int[numCars.length];
        curMax[numCars.length-1] = numCars[numCars.length-1];
        int[] maxFreq = new int[numCars.length];
        maxFreq[numCars.length-1] = 1;
        for(int i = numCars.length-2; i >= 0; i--){
            curMax[i] = Math.max(curMax[i+1], numCars[i]);
        }
        int xMax = numCars[numCars.length-1];
        int curFreq = 0;
        for(int i = numCars.length-1; i >= 0; i--){
            if(xMax == numCars[i]){
                curFreq++;
            }else if(xMax < numCars[i]){
                xMax = numCars[i];
                curFreq = 1;
            }
            maxFreq[i] = curFreq;
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < hourStart.length; i++){

            list.add(maxFreq[hourStart[i]-1]);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getMax(new int[]{5,4,5,3,2}, new int[]{1,2,4,5}));
    }
}