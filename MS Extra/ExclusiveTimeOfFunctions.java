class Node {
    int jobID;
    boolean start;
    int timestamp;

    public Node(String log) {
        String[] arr = log.split(":");
        this.jobID = Integer.parseInt(arr[0]);
        this.start = arr[1].equals("start");
        this.timestamp = Integer.parseInt(arr[2]);
    }
}
class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int[] totalTime = new int[n];
        int prevTime = 0;
        int curId = -1;
        for(String log : logs){
            Node cur = new Node(log);
            if(cur.start){
                if(curId != -1){
                    totalTime[curId] += cur.timestamp - prevTime;
                    stack.push(curId);
                }
                curId = cur.jobID;
                prevTime = cur.timestamp;
            }else{
                totalTime[curId] += cur.timestamp + 1 - prevTime;
                prevTime = cur.timestamp + 1;
                curId = stack.isEmpty() ? -1 : stack.pop();
            }
        }
        return totalTime;
    }
}