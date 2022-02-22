class MaxDiffBwNodeAndAncestor {
    int maxDiff = 0;
    public int maxAncestorDiff(TreeNode root) {
        int[] extremes = helper(root);
        return maxDiff;
    }

    private int[] helper(TreeNode root) {
        if(root == null)return new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE};
        if(root.left == null && root.right == null) return new int[]{root.val, root.val};
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int[] extreme = new int[2];
        extreme[0] = Math.min(left[0], right[0]);
        extreme[1] = Math.max(left[1], right[1]);
        int dif = 0;
        if(extreme[0] != Integer.MAX_VALUE)
            dif = Math.max(dif, Math.abs(root.val - extreme[0]));
        if(extreme[1] != Integer.MIN_VALUE)
            dif = Math.max(dif, Math.abs(root.val - extreme[1]));
        maxDiff = Math.max(maxDiff, dif);
        extreme[0] = Math.min(extreme[0], root.val);
        extreme[1] = Math.max(extreme[1], root.val);
        return extreme;
    }
}