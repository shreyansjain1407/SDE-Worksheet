import java.util.*;

class mergeIntervals {
    public int[][] merge(int[][] intervals) {
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0])
                    return o1[0] - o2[0];
                else
                    return o1[1] - o2[1];
            }
        });
        queue.addAll(Arrays.asList(intervals));
        List<int[]> list = new ArrayList<>();
        int[] cur = queue.poll();
        while (queue.size()>0) {
            int[] temp = queue.poll();
            System.out.println(Arrays.toString(temp));
            if(temp[1] <= cur[1]){

            }else if (temp[0] > cur[1]){
                list.add(cur);
                cur = temp;
            }else{
                cur[1] = temp[1];
            }
        }
        list.add(cur);

        return list.toArray(new int[1][2]);
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2},{4,6},{5,9}};
        int[][] arr4 = {{1,2},{1,3},{1,4},{1,5}};
        int[][] arr5 = {{1,4},{2,3}};
        for (int[] ints : (new Scratch()).merge(arr5)) System.out.println(Arrays.toString(ints));
    }
}