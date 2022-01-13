//A Binary Tree node
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
    int hd;
    int lvl;
    Tuple (TreeNode node, int hd, int lvl){
        this.node = node;
        this.hd = hd;
        this.lvl = lvl;
    }
}

class VerticalOrderTraversal {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, PriorityQueue<Tuple>> map = new HashMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        if(root == null)return new ArrayList<>();
        queue.offer(new Tuple(root, 0, 0));
        int maxNeg = 0;

        Comparator<Tuple> comparator = new Comparator<Tuple>() {
            @Override
            public int compare(Tuple o1, Tuple o2) {
                if(o1.lvl == o2.lvl){
                    return o1.node.val - o2.node.val;
                }else{
                    return o1.lvl - o2.lvl;
                }
            }
        };

        while(queue.size() > 0){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Tuple temp = queue.poll();
                TreeNode tempNode = temp.node;
                if(map.containsKey(temp.hd)){
                    map.get(temp.hd).add(temp);
                }else{
                    PriorityQueue<Tuple> pq = new PriorityQueue<>(comparator);
                    pq.offer(temp);
                    map.put(temp.hd, pq);
                }
                if(tempNode.left != null){
                    maxNeg = Math.min(maxNeg, temp.hd - 1);
                    queue.offer(new Tuple(tempNode.left, temp.hd - 1, temp.lvl + 1));
                }
                if(tempNode.right != null){
                    queue.offer(new Tuple(tempNode.right, temp.hd + 1, temp.lvl + 1));
                }
            }
        }
        List<List<Integer>> topView = new ArrayList<>();
        while(map.containsKey(maxNeg)){
            PriorityQueue<Tuple> temp = map.get(maxNeg);
            ArrayList<Integer> list = new ArrayList<>();
            while(temp.size() > 0){
                list.add(temp.poll().node.val);
            }
            topView.add(list);
            maxNeg++;
        }
        return topView;
    }
}