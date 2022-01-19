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

class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return helper(root.left, root.val, null) && helper(root.right, null, root.val);
    }

    private boolean helper(TreeNode root, Integer high, Integer low) {
        if(root == null)return true;
        if(high != null && root.val >= high)return false;
        if(low != null && root.val <= low) return false;
        return helper(root,root.val,low) && helper(root,high,root.val);
    }
}