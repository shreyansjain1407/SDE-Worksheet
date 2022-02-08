class Node{
    int val;
    List<Node> children;

    public Node(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }
}
class KillProcesses {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, Node> map = new HashMap<>();
        for(int i = 0; i < pid.size(); i++){
            Node cur;
            if(map.containsKey(pid.get(i))){
                cur = map.get(pid.get(i));
            }else{
                cur = new Node(pid.get(i));
                map.put(pid.get(i), cur);
            }
            Node curParent;
            // if(ppid.get(i) == 0)continue;
            if(map.containsKey(ppid.get(i))){
                curParent = map.get(ppid.get(i));
            }else{
                curParent = new Node(ppid.get(i));
                map.put(ppid.get(i), curParent);
            }
            curParent.children.add(cur);
        }
        List<Integer> killedProcesses = new ArrayList<>();
        Queue<Node> killProcesses = new LinkedList<>();
        killProcesses.offer(map.get(kill));
        while(!killProcesses.isEmpty()){
            killedProcesses.add(killProcesses.peek().val);
            killProcesses.addAll(killProcesses.poll().children);
        }
        return killedProcesses;
    }
}