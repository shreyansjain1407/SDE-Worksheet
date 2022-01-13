class Node
{
    int data;
    int hd;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
class BottomViewOfTree
{
    //Function to return a list containing the bottom view of the given tree.
    int maxNeg = 0;
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        Map<Integer, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        if(root == null)return new ArrayList<>();
        root.hd = 0;
        queue.offer(root);

        while(queue.size() > 0){
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Node temp = queue.poll();
                map.put(temp.hd, temp);
                if (temp.left != null) {
                    temp.left.hd = temp.hd - 1;
                    maxNeg = Math.min(maxNeg, temp.hd - 1);
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    temp.right.hd = temp.hd + 1;
                    queue.offer(temp.right);
                }
            }
        }
        ArrayList<Integer> output = new ArrayList<>();
        while(map.containsKey(maxNeg)) {
            output.add(map.get(maxNeg).data);
            maxNeg++;
        }

        return output;
    }
}