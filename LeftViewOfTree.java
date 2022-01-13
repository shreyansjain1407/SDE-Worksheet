//A Binary Tree node
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

class LeftViewOfTree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> finalList = new ArrayList<>();
        if(root == null){
            return finalList;
        }
        queue.offer(root);
        while(queue.size() > 0){
            int size = queue.size();
            finalList.add(queue.peek().data);
            for(int i = 0; i < size; i++){
                Node temp = queue.poll();
                if(temp.left != null){
                    queue.offer(temp.left);
                }
                if(temp.right != null){
                    queue.offer(temp.right);
                }
            }
        }
        return finalList;
    }
}