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

class DistributeCoinsBTree {
    public int distributeCoins(TreeNode root) {
        int[] finalOut = helper(root);
        return finalOut[1];
    }

    public int[] helper(TreeNode root){
        if(root.left == null && root.right == null){
            int valSend = root.val - 1;
            return new int[]{valSend, (valSend > 0)?valSend:-valSend};
        }
        int[] left = (root.left != null)?helper(root.left):new int[]{0,0};
        int[] right = (root.right != null)?helper(root.right):new int[]{0,0};
        int totalval = left[0] + right[0] + (root.val - 1);
        int totalDist = left[1] + right[1] + ((totalval>0)?totalval:-totalval);

        return new int[]{totalval, totalDist};
    }
}