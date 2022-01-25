class Node{
    String id;
    String content;
    String log;
    Node(String id, String content, String log) {
        this.id = id;
        this.content = content;
        this.log = log;
    }
}

class ReorderLogs {
    public String[] reorderLogFiles(String[] logs) {
        Queue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(!o1.content.equals(o2.content)){
                    return o1.content.compareTo(o2.content);
                }else{
                    return o1.id.compareTo(o2.id);
                }
            }
        });
        Queue<String> queueDigital = new LinkedList<>();
        
        for(String str : logs){
            int index = str.indexOf(" ");
            String id = str.substring(0, index);
            String content = str.substring(index + 1);
            if(Character.isDigit(content.charAt(0))){
                queueDigital.add(str);
            }else{
                queue.add(new Node(id, content, str));                
            }
        }
        String[] output = new String[logs.length];
        int i = 0; 
        while(!queue.isEmpty()){
            output[i++] = queue.poll().log;
        }
        while(!queueDigital.isEmpty()){
            output[i++] = queueDigital.poll();
        }

        return output;
    }
}