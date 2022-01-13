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

class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(list, root);
        return list;
    }

    public void helper(List<Integer> list, TreeNode root){
        if(root.left == null && root.right == null){
            list.add(root.val);
            return;
        }
        if(root.left != null){
            helper(list, root.left);
        }
        list.add(root.val);
        if(root.right != null){
            helper(list, root.right);
        }
    }
}