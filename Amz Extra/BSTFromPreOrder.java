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

class BSTFromPreOrder {
    int index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length == 0)return null;
        TreeNode root = new TreeNode(preorder[index++]);
        root.left = bstHelper(root, preorder, null, root.val);
        root.right = bstHelper(root, preorder, root.val, null);
        return root;
    }

    private TreeNode bstHelper(TreeNode root, int[] preorder, Integer low, Integer high) {
        if(index == preorder.length)return null;
        TreeNode curRoot = null;
        if(low == null && preorder[index] > high)return null;
        if(high == null && preorder[index] < low)return null;

        if(low != null && high != null){
            if(preorder[index] > low && preorder[index] < high){
                curRoot = new TreeNode(preorder[index++]);
                curRoot.left = bstHelper(curRoot, preorder, low, curRoot.val);
                curRoot.right = bstHelper(curRoot, preorder, curRoot.val, high);
            }
        }else if(low == null && preorder[index] < high){
            curRoot = new TreeNode(preorder[index++]);
            curRoot.left = bstHelper(curRoot, preorder, low, curRoot.val);
            curRoot.right = bstHelper(curRoot, preorder, curRoot.val, high);
        }else if(high == null && preorder[index] > low){
            curRoot = new TreeNode(preorder[index++]);
            curRoot.left = bstHelper(curRoot, preorder, low, curRoot.val);
            curRoot.right = bstHelper(curRoot, preorder, curRoot.val, high);
        }
        return curRoot;
    }
}