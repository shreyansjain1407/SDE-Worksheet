class Node{
    String url;
    Node prev;
    Node next;

    public Node(String url) {
        this.url = url;
    }
}

class BrowserHistory {
    Node home;
    public BrowserHistory(String homepage) {
        home = new Node(homepage);
    }

    public void visit(String url) {
        home.next = new Node(url);
        home.next.prev = home;
        home = home.next;
    }

    public String back(int steps) {
        while(steps > 0 && home.prev != null) {
            home = home.prev;
            steps--;
        }
        return home.url;
    }

    public String forward(int steps) {
        while(steps > 0 && home.next != null) {
            home = home.next;
            steps--;
        }
        return home.url;
    }
}