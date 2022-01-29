class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};

class LCABinaryTree3 {
    public Node lowestCommonAncestor(Node p, Node q) {
        HashSet<Node> set = new HashSet<>();
        while(p != null){
            set.add(p);
            p = p.parent;
        }
        while(q != null){
            if(set.add(q)){
                q = q.parent;
            } else {
                return q;
            }
        }
        return null;
    }
}