class Node {
    char cur;
    Map<Character, Node> next;
    List<String> items;

    public Node(char cur) {
        this.cur = cur;
        next = new HashMap<>();
        items = new ArrayList<>();
    }
}

class SearchSuggestionSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Map<Character, Node> charMap = new HashMap<>();
        Arrays.sort(products);
        for(String prod : products){
            if(charMap.containsKey(prod.charAt(0))){
                buildTrie(charMap.get(prod.charAt(0)), prod, 0);
            }else{
                Node temp = new Node(prod.charAt(0));
                charMap.put(prod.charAt(0), temp);
                buildTrie(temp, prod, 0);
            }
        }
        List<List<String>> results = new ArrayList<>();
        if(charMap.containsKey(searchWord.charAt(0)))
            getItems(searchWord, results, 0, charMap.get(searchWord.charAt(0)));
        for(int i = results.size(); i < searchWord.length(); i++){
            results.add(new ArrayList<>());
        }

        return results;
    }

    private void getItems(String searchWord, List<List<String>> results, int i, Node node) {
        if(i == searchWord.length())return;
        if(node.items.size() > 3){
            List<String> temp = new ArrayList<>();
            for(int x = 0; x < 3; x++)
                temp.add(node.items.get(x));
            results.add(temp);
        }else{
            results.add(new ArrayList<>(node.items));
        }

        if(i + 1 < searchWord.length()){
            if(node.next.containsKey(searchWord.charAt(i+1))){
                getItems(searchWord, results, i+1, node.next.get(searchWord.charAt(i+1)));
            }
        }
    }

    private void buildTrie(Node temp, String prod, int i) {
        if(i == prod.length())return;
        temp.items.add(prod);
        System.out.println(prod + " " + i + " " + temp.items);
        if(i+1 < prod.length()){
            if(temp.next.containsKey(prod.charAt(i+1))){
                buildTrie(temp.next.get(prod.charAt(i+1)), prod, i+1);
            }else{
                Node cur = new Node(prod.charAt(i+1));
                temp.next.put(prod.charAt(i+1), cur);
                buildTrie(cur, prod, i+1);
            }
        }
    }

    public static void main(String[] args) {
        String[] arr = {"mobile","mouse","moneypot","monitor","mousepad"};
        System.out.println(new Solution().suggestedProducts(arr, "mouse"));
    }
}