class Node{
    String name;
    Set<String> emails;
    public Node(List<String> account){
        this.name = account.get(0);
        account.remove(0);
        this.emails = new HashSet<>(account);
    }

    public List<String> getEmails() {
        List<String> ems = new ArrayList<>(this.emails);
        ems.add(0,this.name);
        return ems;
    }
}

class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Node> emailMap = new HashMap<>();
        List<Node> finalNodes = new ArrayList<>();
        for(List<String> account : accounts){
            Node n1 = new Node(account);
            Node n2;
            boolean addToList = true;
            for(String email : n1.emails){
                if(!emailMap.containsKey(email)){
                    emailMap.put(email, n1);
                }else{
                    n2 = emailMap.get(email);
                    addToList = false;
                    merge(n2, n1);
                }
            }
            if(addToList){
                finalNodes.add(n1);
            }
        }
        List<List<String>> output = new ArrayList<>();
        for(Node node: finalNodes){
            output.add(node.getEmails());
        }
        return output;
    }
    public void merge(Node n1, Node n2){
        n1.emails.addAll(n2.emails);
    }
}