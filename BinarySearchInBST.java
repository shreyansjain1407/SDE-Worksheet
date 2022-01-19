class BinarySearchInBST {
    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> lStack = new Stack<>();
        Stack<TreeNode> rStack = new Stack<>();
        TreeNode left = root;
        while(left.left != null){
            lStack.push(left);
            left = left.left;
        }
        TreeNode right = root;
        while(right.right != null){
            rStack.push(right);
            right = right.right;
        }
        while(left != right){
            int presentSum = left.val + right.val;
            if(presentSum == k){
                return true;
            }else if(presentSum < k){
                left = nextLeft(left, lStack);
            }else {
                right = nextRight(right, rStack);
            }
        }
        
        return false;
    }

    private TreeNode nextRight(TreeNode right, Stack<TreeNode> rStack) {
        if(right.left == null && right.right == null){
            return rStack.pop();
        }
        TreeNode left = null;
        if(right.left != null){
            left = right.left;
        }
        if(left == null)return rStack.pop();
        while(left.right != null){
            rStack.push(left);
            left = left.right;
        }
        return left;
    }

    private TreeNode nextLeft(TreeNode left, Stack<TreeNode> lStack) {
        if(left.left == null && left.right == null){
            return lStack.pop();
        }
        TreeNode right = null;
        if(left.right != null){
            right = left.right; 
        }
        if(right == null)return lStack.pop();
        while(right.left != null){
            lStack.push(right);
            right = right.left;
        }
        return right;
    }
}