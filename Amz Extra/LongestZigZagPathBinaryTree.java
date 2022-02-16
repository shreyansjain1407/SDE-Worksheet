class LongestZigZagPathBinaryTree {
    int max = 0;
    public int longestZigZag(TreeNode root) {
        if(root == null)return max;
        helper(root.left, 'l', 1);
        helper(root.right, 'r', 1);
        return max;
    }

    private void helper(TreeNode root, char dir, int pathLength) {
        if(root == null)return;
        
        max = Math.max(max, pathLength);
        if(dir == 'l'){
            helper(root.left, 'l', 1);
            helper(root.right, 'r', pathLength+1);
        }else{
            helper(root.left, 'l', pathLength+1);
            helper(root.right, 'r', 1);
        }
    }
}