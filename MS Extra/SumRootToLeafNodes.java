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

class SumRootToLeafNodes {
    int totalSum = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return totalSum;
    }

    private void helper(TreeNode root, int pathSum) {
        if(root.left == null && root.right == null){
            totalSum += pathSum + root.val;
            // System.out.println(pathSum + root.val);
            return;
        }
        int curSum = (pathSum + root.val) * 10;
        if(root.left != null){
            helper(root.left, curSum);
        }
        if(root.right != null){
            helper(root.right, curSum);
        }
    }
}