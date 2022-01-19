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

class KthSmallestBST {
    int returnVal = Integer.MIN_VALUE;
    int counter = 0;
    public int kthSmallest(TreeNode root, int k, 0) {
        helper(root, k);
        return returnVal;
    }
    public void helper(TreeNode root, int k){
        if(root.left != null){
            helper(root.left, k);
        }
        counter++;
        if(counter == k){
            returnVal = root.val;
            return;
        }
        if(root.right != null){
            helper(root.right, k);
        }
    }
}