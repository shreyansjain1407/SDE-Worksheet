class BinaryTreeToDoublyLinkedList {
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        helper(root);
    }

    private TreeNode helper(TreeNode root) {
        if(root.left == null && root.right == null){
            return root;
        }
        
        TreeNode left = (root.left!=null)?helper(root.left):null;
        TreeNode right = (root.right!=null)?helper(root.right):null;
        
        if(left != null){
            TreeNode temp = left;
            while(temp.right != null){
                temp.left = null;
                temp = temp.right;
            }
            temp.right = right;
            root.right = left;
            root.left = null;
        }
        return root;
    }
}