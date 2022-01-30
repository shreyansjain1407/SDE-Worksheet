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

class DiameterOfBinaryTree {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return diameter;
    }

    private int helper(TreeNode root) {
        if(root.left == null && root.right == null){
            return 1;
        }
        int left = 0, right = 0;
        if(root.left != null){
            left = helper(root.left);
        }
        if(root.right != null){
            right = helper(root.right);
        }
        diameter = Math.max(diameter, left+right);
        return Math.max(left, right) + 1;
    }
}