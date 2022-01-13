class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
class TopViewOfTree
{
    private static int maxNeg;
    //Function to return a list of nodes visible from the top view
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        Map<Integer, Node> map = new HashMap<>();
        helper(map, root, 0);
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) return list;
        while(map.containsKey(maxNeg)){
            list.add(map.get(maxNeg).data);
            maxNeg++;
        }

        return list;
    }

    private static void helper(Map<Integer,Node> map, Node root, int i) {
        if(!map.containsKey(i)){
            map.put(i, root);
        }
        if(root.left != null){
            maxNeg = Math.min(maxNeg, i-1);
            helper(map, root.left, i-1);
        }
        if(root.right != null){
            helper(map, root.right, i+1);
        }
    }
}