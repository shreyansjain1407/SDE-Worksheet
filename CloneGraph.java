class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class CloneGraph {
    public Node cloneGraph(Node node) {
        if(node == null)return null;
        Map<Node, Node> nodeMap = new HashMap<>();
        Node finalNode = new Node(node.val);
        nodeMap.put(node, finalNode);
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Node temp = queue.poll();
                visited.add(temp);
                System.out.println(temp.val);
                Node newTemp;
                // System.out.println("Here");
                if (nodeMap.containsKey(temp)){
                    // System.out.println("Contained");
                    newTemp = nodeMap.get(temp);
                }else{
                    newTemp = new Node(temp.val);
                    nodeMap.put(temp, newTemp);
                }
                newTemp.neighbors = initNeighbours(temp.neighbors, nodeMap);
                for(Node neighbor: temp.neighbors){
                    if(!visited.contains(neighbor)){
                        queue.add(neighbor);
                    }
                }
            }
        }
        System.out.println(nodeMap);
        return null;
    }

    public List<Node> initNeighbours(List<Node> neighbors, Map<Node,Node> nodeMap) {
        // System.out.println("Beginning");
        ArrayList<Node> newNeighbours = new ArrayList<>();
        for (Node temp : neighbors) {
            if (nodeMap.containsKey(temp)) {
                newNeighbours.add(nodeMap.get(temp));
                // System.out.println("EXE");
            } else {
                Node newTemp = new Node(temp.val);
                nodeMap.put(temp, newTemp);
                newNeighbours.add(newTemp);
            }
        }
        return newNeighbours;
    }
}