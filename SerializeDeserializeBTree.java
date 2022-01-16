/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class SerializeDeserializeBTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        SerializeHelper(sb, root);
        sb.setLength(sb.length()-1);
        sb.append("]");
        // System.out.println(sb.toString());
        return sb.toString();
    }

    private void SerializeHelper(StringBuilder sb, TreeNode root) {
        if(root == null){
            sb.append("null,");
            return;
        }
        sb.append(root.val).append(",");
        SerializeHelper(sb, root.left);
        SerializeHelper(sb, root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = data.replace("[", "").replace("]", "");
        Queue<String> nodeData = new LinkedList<>(Arrays.asList(data.split(",")));
        TreeNode root = DeserializeHelper(nodeData);

        return root;
    }

    private TreeNode DeserializeHelper(Queue<String> nodeData) {
        if(nodeData.peek().equals("null")){
            nodeData.poll();
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodeData.poll()));
        root.left = DeserializeHelper(nodeData);
        root.right = DeserializeHelper(nodeData);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));