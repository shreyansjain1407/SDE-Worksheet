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

class SumofNodesWithEvenGrandParent {
    int sum = 0;
    public int sumEvenGrandparent(TreeNode root) {
        traverse(root);
        return sum;
    }

    private void traverse(TreeNode root) {
        if(root.val % 2 == 0){
            sum(root.left, 1);
            sum(root.right, 1);
        }
        if(root.left != null)traverse(root.left);
        if(root.right != null)traverse(root.right);
    }

    public void sum(TreeNode root, int depth){
        if(root == null || depth > 2)return;
        if(depth == 2){
            sum += root.val;
        }
        sum(root.left, depth+1);
        sum(root.right, depth+1);
    }
}