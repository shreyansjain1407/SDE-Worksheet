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

class ConstructBSTPreOrder {
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length == 0)return null;
        TreeNode root = new TreeNode(preorder[0]);
        for(int i = 1; i < preorder.length; i++){
            helper(root, preorder[i]);
        }

        return root;
    }

    private void helper(TreeNode root, int i) {
        if(i < root.val){
            if(root.left == null){
                root.left = new TreeNode(i);
            }else{
                helper(root.left, i);
            }
        }else{
            if(root.right == null){
                root.right = new TreeNode(i);
            }else {
                helper(root.right, i);
            }
        }
    }
}