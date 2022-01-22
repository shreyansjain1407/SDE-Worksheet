class Node {
    char c;
    Map<Character, Node> charMap;
    int freq;
    Node (char c, int freq){
        this.c = c;
        charMap = new HashMap<>();
        this.freq = freq;
    }
}
class Contacts {

    /*
     * Complete the 'contacts' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts 2D_STRING_ARRAY queries as parameter.
     */

    public static List<Integer> contacts(List<List<String>> queries) {
        // Write your code here
        // System.out.println(queries);
        Map<Character, Node> map = new HashMap<>();
        List<Integer> out = new ArrayList<>();
        for(List<String> cmd : queries){
            String cur = cmd.get(1);
            if(cmd.get(0).equals("add")){
                //Create Add Function
                if(map.containsKey(cur.charAt(0))){
                    map.get(cur.charAt(0)).freq++;
                    add(map.get(cur.charAt(0)), cur.substring(1));
                }else{
                    if(cur.length() == 1){
                        map.put(cur.charAt(0), new Node(cur.charAt(0), 1));
                    }else{
                        map.put(cur.charAt(0), new Node(cur.charAt(0), 1));
                        add(map.get(cur.charAt(0)), cur.substring(1));
                    }
                }
            }else{
                //Create Find Function
                if(map.containsKey(cur.charAt(0))) {
                    out.add(find(map.get(cur.charAt(0)), cur));
                }else{
                    out.add(0);
                }

            }
        }
        return out;
    }

    private static Integer find(Node root, String cur) {
        if(cur.length() == 0){
            return root.freq;
        }
        if(root.charMap.containsKey(cur.charAt(0))){
            return find(root.charMap.get(cur.charAt(0)), cur.substring(1));
        }else{
            return 0;
        }
    }

    public static void add(Node root, String rest){
        if(rest.length() == 1){
            if(root.charMap.containsKey(rest.charAt(0))){
                root.charMap.get(rest.charAt(0)).freq++;
            }else{
                root.charMap.put(rest.charAt(0), new Node(rest.charAt(0), 1));
            }
            return;
        }
        if (!root.charMap.containsKey(rest.charAt(0))) {
            root.charMap.put(rest.charAt(0), new Node(rest.charAt(0), 0));
        }
        root.charMap.get(rest.charAt(0)).freq++;
        add(root.charMap.get(rest.charAt(0)), rest.substring(1));
    }
}