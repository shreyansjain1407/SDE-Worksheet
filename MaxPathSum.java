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

class MaxPathSum {
    int maxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int x = helper(root);

        return maxPath;
    }

    private int helper(TreeNode root) {
        if(root.left == null && root.right == null){
            maxPath = Math.max(maxPath, root.val);
            return root.val;
        }

        int left = (root.left != null)?helper(root.left):0;
        int right = (root.right != null)?helper(root.right):0;
        int total = left + right + root.val;
        maxPath = Math.max(maxPath, total);
        int max = Math.max(left+root.val, Math.max(right+root.val, root.val));
        maxPath = Math.max(maxPath, max);
        return max;
    }
}