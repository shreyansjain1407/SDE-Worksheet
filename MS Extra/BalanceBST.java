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

class BalanceBST {
    List<TreeNode> sorted;
    public TreeNode balanceBST(TreeNode root) {
        sorted = new ArrayList<>();
        initialize(root);
        // System.out.println(sorted);
        int mid = sorted.size()/2;
//        for(TreeNode x : sorted)
//            System.out.print(x.val + " ");
        TreeNode curRoot = sorted.get(mid);
        curRoot.left = makeTree(0, mid);
        curRoot.right = makeTree(mid+1, sorted.size());

        return curRoot;
    }

    private TreeNode makeTree(int left, int right) {
        if(left >= right) return null;
        int mid = left + (right - left)/2;
        TreeNode curRoot = sorted.get(mid);
        // System.out.println(left + " " + mid + " " + right + " " + curRoot.val);
        curRoot.left = makeTree(left, mid);
        curRoot.right = makeTree(mid+1, right);
        return curRoot;
    }

    private void initialize(TreeNode root) {
        if(root.left != null){
            initialize(root.left);
        }
        root.left = null;
        sorted.add(root);
        // System.out.println(root.val);
        if(root.right != null){
            initialize(root.right);
        }
        root.right = null;
    }
}