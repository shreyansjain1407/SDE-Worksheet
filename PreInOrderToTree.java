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

class PreInOrderToTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0)return null;
        if(preorder.length == 1)return new TreeNode(preorder[0]);
        TreeNode root = new TreeNode(preorder[0]);
        int inIndex = findIndex(preorder[0], inorder);
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + inIndex), Arrays.copyOfRange(inorder, 0, inIndex));
        root.right = buildTree(Arrays.copyOfRange(preorder, 1 + inIndex, preorder.length), Arrays.copyOfRange(inorder, inIndex + 1, inorder.length));
        return root;
    }

    private int findIndex(int needle, int[] inorder) {
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == needle){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        new Scratch().buildTree(preorder, inorder);
    }
}