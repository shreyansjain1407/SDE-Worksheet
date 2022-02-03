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

class ConstructBinaryTreeFromString {
    public TreeNode str2tree(String s) {
        if(s.length() == 0)return null;
        int node1 = s.indexOf('(');
        int curVal = node1 == -1 ? Integer.parseInt(s) : Integer.parseInt(s.substring(0, node1));
        TreeNode root = new TreeNode(curVal);
        if(node1 == -1) return root;
        System.out.println(curVal);
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(node1));
        int node2 = node1+1;
        while(!stack.isEmpty() && node2 < s.length()){
            if(s.charAt(node2) == '('){
                stack.push(s.charAt(node2));
            }else if(s.charAt(node2) == ')'){
                stack.pop();
            }
            node2++;
        }

        root.left = str2tree(s.substring(node1 + 1, node2 - 1));
        root.right = node2 == s.length() ? null : str2tree(s.substring(node2+1, s.length() - 1));
        return root;
    }
}