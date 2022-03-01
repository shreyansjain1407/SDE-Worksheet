class TrieNode{
    char c;
    HashMap<Character, TrieNode> nodeMap;
    String word;

    public TrieNode(char c) {
        this.c = c;
        nodeMap = new HashMap<Character, TrieNode>();
    }
}
class WordDictionary {
    HashMap<Character, TrieNode> nodeMap;
    
    public WordDictionary() {
        nodeMap = new HashMap<Character, TrieNode>();
    }

    public void addWord(String word) {
        if(word.length() == 1){
            if(nodeMap.containsKey(word.charAt(0))){
                nodeMap.get(word.charAt(0)).word = word;
            }else{
                TrieNode node = new TrieNode(word.charAt(0));
                node.word = word;
                nodeMap.put(word.charAt(0), node);
            }
            return;
        }
        if(nodeMap.containsKey(word.charAt(0))){
            initialize(nodeMap.get(word.charAt(0)), word, 1);
        }else{
            TrieNode cur = new TrieNode(word.charAt(0));
            nodeMap.put(word.charAt(0), cur);
            initialize(cur, word, 1);
        }
    }

    private void initialize(TrieNode curNode, String word, int curIndex) {
        if(curIndex == word.length()){
            curNode.word = word;
            return;
        }
        if(curNode.nodeMap.containsKey(word.charAt(curIndex))){
            initialize(curNode.nodeMap.get(word.charAt(curIndex)), word, curIndex+1);
        }else{
            TrieNode cur = new TrieNode(word.charAt(curIndex));
            curNode.nodeMap.put(word.charAt(curIndex), cur);
            initialize(cur, word, curIndex + 1);
        }
    }

    public boolean search(String word) {
        // System.out.println(nodeMap);
        if(word.length() == 1){
            if(nodeMap.containsKey(word.charAt(0))){
                return nodeMap.get(word.charAt(0)).word != null;
            }else if(word.charAt(0) == '.'){
                for(Character key : nodeMap.keySet()){
                    if(nodeMap.get(key).word != null)return true;
                }
            }
            return false;
        }
        
        boolean found = false;
        if(nodeMap.containsKey(word.charAt(0))){
            found = findWord(nodeMap.get(word.charAt(0)), word, 1);
        }else if(word.charAt(0) == '.'){
            for(Character key : nodeMap.keySet()){
                if(found)break;
                found |= findWord(nodeMap.get(key), word, 1);
            }
        }
        return found;
    }

    private boolean findWord(TrieNode curNode, String word, int curIndex) {
        // if(curNode == null)return false;
       // System.out.println(word + " " + curIndex);
       // System.out.println("Curnode map: " + curNode.nodeMap);
        if(curIndex == word.length()){
            return curNode.word != null;
        }
        boolean found = false;
        if(curNode.nodeMap.containsKey(word.charAt(curIndex))){
            // System.out.println("Exe: ");
            found = findWord(curNode.nodeMap.get(word.charAt(curIndex)), word, curIndex+1);
        }else if(word.charAt(curIndex) == '.'){
            for(Character key : curNode.nodeMap.keySet()){
                if(found)break;
                found |= findWord(curNode.nodeMap.get(key), word, curIndex+1);
            }
        }
        return found;
    }
}