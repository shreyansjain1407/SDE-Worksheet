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

class BoundaryOfBinaryTree {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root == null)return new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(!ifLeaf(root))output.add(root.val);
        getLeft(root, output);
        getLeaves(root, output);
        getright(root, output);
        return output;
    }

    private void getright(TreeNode root, List<Integer> output) {
        TreeNode cur = root.right;
        ArrayList<Integer> list = new ArrayList<>();
        while(cur!=null){
            if(!ifLeaf(cur))list.add(cur.val);
            if(cur.right != null)cur = cur.right;
            else cur = cur.left;
        }
        Collections.reverse(list);
        output.addAll(list);
    }

    private void getLeaves(TreeNode root, List<Integer> output) {
        if(ifLeaf(root)){
            output.add(root.val);
            return;
        }
        if(root.left != null){
            getLeaves(root.left, output);
        }
        if(root.right != null){
            getLeaves(root.right, output);
        }
    }

    private void getLeft(TreeNode root, List<Integer> output) {
        TreeNode cur = root.left;
        while(cur!=null){
            if(!ifLeaf(cur))output.add(cur.val);
            if(cur.left != null)cur = cur.left;
            else cur = cur.right;
        }
    }

    private boolean ifLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}