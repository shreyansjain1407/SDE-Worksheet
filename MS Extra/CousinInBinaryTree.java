class CousinInBinaryTree {
    TreeNode xParent = null, yParent = null;
    int xHeight = 0, yHeight = 0;
    public boolean isCousins(TreeNode root, int x, int y) {

        helper(root, x, y, 0);
        if(xHeight == yHeight){
            return xParent != yParent;
        }
        return false;
    }

    private void helper(TreeNode root, int x, int y, int height) {
        if(root.left != null){
            if(root.left.val == x){
                xParent = root;
                xHeight = height+1;
            }else if(root.left.val == y){
                yParent = root;
                yHeight = height+1;
            }
            helper(root.left, x, y, height+1);
        }
        if(root.right != null){
            if(root.right.val == x){
                xParent = root;
                xHeight = height+1;
            }else if(root.right.val == y){
                yParent = root;
                yHeight = height+1;
            }
            helper(root.right, x, y, height+1);
        }
    }
}