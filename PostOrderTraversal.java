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

class PostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        helper(list, root);
        return list;
    }

    private void helper(List<Integer> list, TreeNode root) {
        if(root.left == null && root.right == null){
            list.add(root.val);
            return;
        }
        if(root.left != null) {
            helper(list, root.left);
        }
        if(root.right != null){
            helper(list, root.right);
        }
        list.add(root.val);
    }
}