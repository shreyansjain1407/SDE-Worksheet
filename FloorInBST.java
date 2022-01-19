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

public class FloorInBST {

    public static int floorInBST(TreeNode<Integer> root, int X) {
        //    Write your code here.
        TreeNode<Integer> cur = root;
        int output = Integer.MIN_VALUE;
        while(cur != null){
//             System.out.println(cur.data);
            if(cur.data == X){
                return cur.data;
            }
            if(cur.data < X){
                if(cur.data <= X)
                    output = Math.max(output, cur.data);
                cur = cur.right;
            }else{
                if(cur.data <= X)
                    output = Math.max(output, cur.data);
                cur = cur.left;
            }
        }
        return output;
    }
}