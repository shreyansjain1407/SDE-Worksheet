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

class PreOrderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        helper(list, root);
        return list;
    }

    public void helper(List<Integer> list, TreeNode root){
        list.add(root.val);
        if(root.left != null){
            helper(list, root.left);
        }
        if(root.right != null){
            helper(list, root.right);
        }
    }
}