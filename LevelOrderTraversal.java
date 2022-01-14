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

class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(){{add(root.val);}});
        queue.offer(root);
        while(queue.size() > 0){
            int size = queue.size();
            ArrayList<Integer> tempList = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode temp = queue.poll();
                if(temp.left != null){
                    queue.offer(temp.left);
                    tempList.add(temp.left.val);
                }
                if(temp.right != null){
                    queue.offer(temp.right);
                    tempList.add(temp.right.val);
                }
            }
            if(tempList.size()>0)list.add(tempList);
        }
        return list;
    }
}