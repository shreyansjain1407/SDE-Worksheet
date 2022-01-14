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
class Tuple {
    TreeNode node;
    int index;
    int lvl;
    Tuple (TreeNode node, int index){
        this.node = node;
        this.index = index;
    }
}

class MaxWidthBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        int maxNeg = 0, maxPos = 0;
        Deque<Tuple> queue = new LinkedList<>();
        if(root == null) return 0;
        int totalMax = 1;
        queue.offer(new Tuple(root, 0));
        while(queue.size() > 0){
            int size = queue.size();
            int curLeft = Integer.MAX_VALUE, curRight = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++){
                Tuple temp = queue.poll();
                if(temp.node.left != null){
                    maxNeg = Math.min(temp.index -1, maxNeg);
                    curLeft = Math.min(curLeft, temp.index - 1);
                    queue.offer(new Tuple(temp.node.left, (2*temp.index)+1));
                }
                if(temp.node.right != null){
                    maxPos = Math.max(temp.index + 1, maxPos);
                    curRight = Math.max(curRight, temp.index + 1);
                    queue.offer(new Tuple(temp.node.right, (2*temp.index) + 2));
                }
            }
            if (queue.size() > 0) totalMax = Math.max(totalMax, queue.peekLast().index - queue.peekFirst().index + 1);
        }

        return totalMax;
    }
}