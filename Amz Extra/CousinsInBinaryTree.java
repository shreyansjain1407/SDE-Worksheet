class Node{
    TreeNode parent;
    int depth;
    int val;
    Node(int depth, int val){
        this.val = val;
        this.depth = depth;
    }
}

class CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        Node n1 = findNode(root, x, 1);
        Node n2 = findNode(root, y, 1);
        
        if(n1.parent != n2.parent){
            if(n1.depth == n2.depth){
                return true;
            }
        }
        return false;
    }

    private Node findNode(TreeNode root, int val, int depth) {
        if(root == null)return null;
        if(root.val == val)return new Node(depth, val);
        Node n = findNode(root.left, val, depth+1);
        if(n == null) n = findNode(root.right, val, depth+1);
        if(n == null)return null;
        
        if(n.parent == null)n.parent = root;
        return n;
    }
}