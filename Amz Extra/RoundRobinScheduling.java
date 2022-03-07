class RoundRobinScheduling {
    public List<Integer> roundRobin(List<List<Integer>> list){
        Queue<Integer> rrQueue = new LinkedList<>();
        for(int i = 0; i < list.size(); i++){
            rrQueue.offer(i);
        }

        int curIndex = 0;
        boolean end = false;
        List<Integer> output = new ArrayList<>();
        while(! rrQueue.isEmpty() ){
            if(list.get(rrQueue.peek()).size() > curIndex){
                output.add(list.get(rrQueue.peek()).get(curIndex));
                if(list.get(rrQueue.peek()).size() > curIndex + 1){
                    rrQueue.offer(rrQueue.poll());
                }
            }
        }

        return output;
    }
    public static void main(String[] args) {
        
    }
}