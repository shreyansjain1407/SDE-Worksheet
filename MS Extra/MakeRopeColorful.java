class MakeRopeColorful {
    public int minCost(String colors, int[] neededTime) {
        int timeNeeded = 0;
        for(int i = 0; i < colors.length()-1; i++){
            if(colors.charAt(i) == colors.charAt(i+1)){
                System.out.println("EXE 1");
                Deque<Integer> q = new LinkedList<>();
                int x = i;
                q.offer(neededTime[x]);
                while(x < colors.length() - 1 && colors.charAt(x) == colors.charAt(x+1)){
                    System.out.println("EXE " + x);
                    if(neededTime[x+1] < q.peek()){
                        q.offerFirst(neededTime[x+1]);
                    }else if(neededTime[x+1] > q.peekLast()){
                        q.offerLast(neededTime[x+1]);
                    }else {
                        timeNeeded += neededTime[x+1];
                    }
                    x++;
                }
                while(q.size() > 1){
                    timeNeeded += q.pollFirst();
                }
                i = x;
            }
        }
        return timeNeeded;
    }

    public static void main(String[] args) {
        System.out.println(new Scratch().minCost("cddcdcae", new int[]{4,8,8,4,4,5,4,2}));
    }
}