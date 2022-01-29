class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};


class BSTToDoublyLL {
    public Node treeToDoublyList(Node root) {
        if(root == null)return root;
        Node head = new Node();
//        System.out.println(head.val);
        Node cur = head;
        cur = helper(cur, root);
        cur.right = head.right;
        head.right.left = cur;
        return head.right;
    }

    private Node helper(Node cur, Node root) {
        if(root.left == null && root.right == null){
            System.out.println("Before: " + cur.val + " " + root.val);
            cur.right = root;
            root.left = cur;
            cur = cur.right;
            System.out.println("After: " + cur.val + " " + root.val);
            return cur;
        }
        Node newCur = cur;
        if(root.left != null){
            newCur = helper(cur, root.left);
        }
        if(cur != null){
            System.out.println(cur.val + " " + root.val);
        }else{
            System.out.println("CurNull: " + root.val);
        }
        newCur.right = root;
        root.left = newCur;
        newCur = newCur.right;
        if(root.right != null){
            newCur = helper(newCur, root.right);
        }
        return newCur;
    }

    public static void main(String[] args) {
        Node root = new Node(4, new Node(2), new Node(5));
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        Node out = new Solution().treeToDoublyList(root);

        for(int i = 0 ; i < 6 && out != null; i++){
            System.out.print(out.val + " -> ");
            out = out.left;
        }
    }
}