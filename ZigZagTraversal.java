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

class ZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> outputList = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        boolean dir = false;
        while(deque.size() > 0){
            int size = deque.size();
            dir = !dir;
            List<Integer> level = new ArrayList<>();
            Deque<TreeNode> queue = new LinkedList<>();
            for(int i = 0; i < size; i++){
                TreeNode cur = (dir)?deque.pollFirst():deque.pollLast();
                level.add(cur.val);
                if(dir){
                    if(cur.left != null)queue.offer(cur.left);
                    if(cur.right != null)queue.offer(cur.right);
                }else{
                    if(cur.right != null)queue.offerFirst(cur.right);
                    if(cur.left != null)queue.offerFirst(cur.left);
                }
            }
            deque.addAll(queue);
            outputList.add(level);
        }
        return outputList;
    }
}