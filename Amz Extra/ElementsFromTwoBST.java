class ElementsFromTwoBST {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> q = new ArrayList<>();
        inOrder(root1, q);
        inOrder(root2, q);
        q.sort(Comparator.comparingInt(a -> a));
        return new ArrayList<>(q);
    }

    private void inOrder(TreeNode root, List<Integer> q) {
        if(root.left != null){
            inOrder(root.left, q);
        }
        q.add(root.val);
        if(root.right != null){
            inOrder(root.right, q);
        }
    }
}

//Approach 2
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ArrayDeque<TreeNode> stack1 = new ArrayDeque<>();
        ArrayDeque<TreeNode> stack2 = new ArrayDeque<>();
        List<Integer> output = new ArrayList<>();
        while(root1 != null || root2 != null || !stack1.isEmpty() || !stack2.isEmpty()){
            while(root1 != null){
                stack1.push(root1);
                root1 = root1.left;
            }
            while(root2 != null){
                stack2.push(root2);
                root2 = root2.left;
            }

            if(stack2.isEmpty() || !stack1.isEmpty() && stack1.getFirst().val <= stack2.getFirst().val){
                output.add(stack1.peek().val);
                root1 = stack1.pop().right;
            }else{
                output.add(stack2.peek().val);
                root2 = stack2.pop().right;
            }
        }
        return output;
    }
}