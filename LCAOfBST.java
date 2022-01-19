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

class LCAOfBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)return null;
        if(p.val > q.val){
            if(root.val <= p.val && root.val >= q.val)return root;
            if(root.val > p.val){
                return lowestCommonAncestor(root.left, p, q);
            }else if(root.val < q.val){
                return lowestCommonAncestor(root.right, p, q);
            }
        }else{
            if(root.val >= p.val && root.val <= q.val)return root;
            if(root.val > q.val){
                return lowestCommonAncestor(root.left, p, q);
            }else if(root.val < p.val){
                return lowestCommonAncestor(root.right, p, q);
            }
        }
        return null;
    }
}