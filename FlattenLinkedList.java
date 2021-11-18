class Node
{
    int data;
    Node next;
    Node bottom;
    
    Node(int d)
    {
        data = d;
        next = null;
        bottom = null;
    }
}

class FlattenLinkedList
{
    Node flatten(Node root)
    {
        // Your code here
        Queue<Node> q = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.data - o2.data;
            }
        });
        Node cur = root;
        while(cur != null){
            Node temp = cur;
            while(temp!=null){
                // System.out.println(temp.data);
                q.offer(temp);
                temp = temp.bottom;
            }
            cur = cur.next;
        }
        // System.out.println(q.size());
        Node head = null;
        if(q.size()>0)
            head = q.poll();
        else 
            return null;
        cur = head;
        // cur.bottom = null;
        while(q.size()>0){
            cur.bottom = q.poll();
            
            // System.out.println(cur.data);
            cur = cur.bottom;
            cur.next = null;
        }
        return head;
    }
}