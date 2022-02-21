class InsertNodeInBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // if(root == null)return new TreeNode(val);
        return helper(root, val);
    }

    private TreeNode helper(TreeNode root, int val) {
        if(root == null)return new TreeNode(val);
        if(root.val > val)
            root.left = helper(root.left, val);
        else
            root.right = helper(root.right, val);
        return root;
    }
}