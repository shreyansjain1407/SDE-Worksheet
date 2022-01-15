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

class CountGoodNodes {
    int output = 0;
    public int goodNodes(TreeNode root) {
        countGoodNode(root, root.val);
        return output;
    }

    private void countGoodNode(TreeNode root, int val) {
        int valNext = val;
        if(root.val >= val){
            if(root.val > val){
                valNext = root.val;
            }
            output++;
        }

        if(root.left != null){
            countGoodNode(root.left, valNext);
        }
        if(root.right != null){
            countGoodNode(root.right, valNext);
        }
    }
}