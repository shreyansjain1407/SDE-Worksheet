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

class LowestCommonAncestor {

    TreeNode finalOut = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashSet<TreeNode> set = new HashSet<>();
        helper(root, p, set);
        // System.out.println(set);
        helper(root, q, set);
        // System.out.println(set);
        return finalOut;
    }

    private boolean helper(TreeNode root, TreeNode p, HashSet<TreeNode> set) {
        if(root == null)return false;
        // System.out.println(root.val);
        if(root.val == p.val){
            if(!set.add(root)){
                finalOut = root;
                return false;
            }
            return true;
        }

        boolean cur = helper(root.left, p, set) || helper(root.right, p, set);
        if(cur){
            if(!set.add(root)){
                finalOut = root;
                return false;
            }
        }
        return cur;
    }
}