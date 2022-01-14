class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class IdenticalTrees {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return helper(p, q);
    }

    private boolean helper(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        } else if((p != null && q == null) || (p == null && q != null)){
            return false;
        }
        if(p.val == q.val){
            return helper(p.left, q.left) && helper(p.right, q.right);
        }
        return false;
    }
}