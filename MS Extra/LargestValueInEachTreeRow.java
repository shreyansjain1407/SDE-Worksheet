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

class LargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        if(root == null)return new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            Queue<TreeNode> level = new PriorityQueue<>(new Comparator<TreeNode>() {
                @Override
                public int compare(TreeNode o1, TreeNode o2) {
                    if(o2.val > o1.val)
                        return 1;
                    else if(o1.val > o2.val)
                        return -1;
                    else
                        return 0;
                }
            });
            output.add(queue.peek().val);
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                if(cur.left != null)
                    level.add(cur.left);
                if(cur.right != null)
                    level.add(cur.right);
            }
            queue.addAll(level);
        }
        return output;
    }
}