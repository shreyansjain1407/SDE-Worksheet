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
class RightViewOfTree {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> finalList = new ArrayList<>();
        if(root == null){
            return finalList;
        }
        queue.offer(root);
        while(queue.size() > 0){
            int size = queue.size();
            finalList.add(queue.peek().val);
            for(int i = 0; i < size; i++){
                TreeNode temp = queue.poll();
                if(temp.right != null){
                    queue.offer(temp.right);
                }
                if(temp.left != null){
                    queue.offer(temp.left);
                }
            }
        }
        return finalList;
    }
}