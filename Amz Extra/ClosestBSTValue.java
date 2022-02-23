class ClosestBSTValue {
    double minDiff = Double.MAX_VALUE;
    int val = Integer.MAX_VALUE;
    public int closestValue(TreeNode root, double target) {
        helper(root, target);
        return val;
    }

    private void helper(TreeNode root, double target) {
        if(root == null)return;
        double diff = Math.abs(root.val - target);
        if(diff < minDiff){
            minDiff = diff;
            val = root.val;
        }
        if(root.val > target){
            helper(root.left, target);
        }else if(root.val < target){
            helper(root.right, target);
        }
    }
}