class High5Averages {
   public int[][] highFive(int[][] items) {
       Map<Integer, Queue<Integer>> avgMap = new HashMap<>();
       for(int[] item : items){
           if(avgMap.containsKey(item[0])){
               Queue<Integer> temp = avgMap.get(item[0]);
               temp.add(item[1]);
               if(temp.size() > 5){
                   temp.poll();
               }
           }else{
               Queue<Integer> queue = new PriorityQueue<>();
               queue.add(item[1]);
               avgMap.put(item[0], queue);

       }
       int[][] averages = new int[avgMap.size()][2];
       int i = 0;
       for(Map.Entry<Integer, Queue<Integer>> entry : avgMap.entrySet()){
           int sum = 0;
           Queue<Integer> queue = entry.getValue();
           while(!queue.isEmpty()){
               sum+= queue.poll();
           }
           averages[i][0] = entry.getKey();
           averages[i][1] = sum/5;
           i++;
       }
       return averages;
   }
}