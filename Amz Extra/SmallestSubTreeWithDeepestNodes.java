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

class SmallestSubTreeWithDeepestNodes {
    TreeNode deepest = null;
    int maxDepth = -1;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int maxD = helper(root, 0);
        return maxD == -1 ? null : deepest;
    }

    private int helper(TreeNode root, int depth) {
        if(root == null)return depth - 1;
        if(maxDepth < depth){
            maxDepth = depth;
            deepest = root;
        }

        int left = helper(root.left, depth+1);
        int right = helper(root.right, depth+1);

        if(left == right && left >= maxDepth){
            deepest = root;
        }

        return Math.max(left,right);
    }
}