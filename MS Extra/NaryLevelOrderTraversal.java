class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};


class NaryLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> traversals = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        while(queue.size() > 0){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                Node temp = queue.poll();
                list.add(temp.val);
                queue.addAll(temp.children);
            }
            traversals.add(list);
        }
        return traversals;
    }
}