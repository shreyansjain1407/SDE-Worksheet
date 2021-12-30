class StackWithQueue {
    //Previously completed using 2 queues
    //Now using one queue
    Queue<Integer> q;

    public MyStack() {
        q = new LinkedList();
    }
    
    public void push(int x) {
        q.offer(x);
    }
    
    public int pop() {
        int size = q.size();
        for(int i = 0; i < size - 1; i++){
            q.offer(q.poll());
        }
        return q.poll();
    }
    
    public int top() {
        int size = q.size();
        for(int i = 0; i < size - 1; i++){
            q.offer(q.poll());
        }
        int out = q.poll();
        q.offer(out);
        return out;
    }
    
    public boolean empty() {
        if(q.size() == 0)
            return true;
        else
            return false;
    }
}