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

class MaxDepthBinaryTree {
    int maxHeight = 0;
    public int maxDepth(TreeNode root) {
        if(root == null)return 0;
        helper(root, 1);
        return maxHeight;
    }

    private void helper(TreeNode root, int i) {
        maxHeight = Math.max(i, maxHeight);
        if(root.left != null){
            helper(root.left, i+1);
        }
        if(root.right != null){
            helper(root.right,i+1);
        }
    }
}