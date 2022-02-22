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

class FindDistanceInBinaryTree {
    int minDistance = Integer.MAX_VALUE;
    public int findDistance(TreeNode root, int p, int q) {
        if(p == q)return 0;
        int x = helper(root, p, q);
        return minDistance;
    }

    private int helper(TreeNode root, int p, int q) {
        if(root == null)return -1;

        int left = helper(root.left, p, q);
        int right = helper(root.right, p, q);
        if(left != -1 && right != -1){
            minDistance = left + right;
            return -1;
        }else if(left != -1 && (root.val == p || root.val == q)){
            minDistance = left;
        }else if(right != 1 && (root.val == p || root.val == q)){
            minDistance = right;
        }
        if(root.val == p || root.val == q)return 1;
        return Math.max(left, right) != -1 ? Math.max(left, right) + 1 : -1;
    }
}