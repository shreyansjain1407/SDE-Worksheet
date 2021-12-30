class QueueUsingStack {
    Stack<Integer> s1;
    Stack<Integer> s2;
    boolean out = false;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        if(!out){
            while(!s1.empty()){
                s2.push(s1.pop());
            }
            if (s2.size() > 1)
                out = true;
        }else{
            if(s2.size() == 1){
                out = false;
            }
        }
        return s2.pop();
    }

    public int peek() {
        if(!out){
            while(!s1.empty()){
                s2.push(s1.pop());
            }out = true;
        }
        return s2.peek();
    }

    public boolean empty() {
        return s1.size() == 0 && s2.size() == 0;
    }
}