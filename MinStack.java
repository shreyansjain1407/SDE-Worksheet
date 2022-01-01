class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty()){
           minStack.push(val); 
        }else if(minStack.peek()>=val){
            minStack.push(val);
        }
    }
    
    public void pop() {
        if(Objects.equals(minStack.peek(), stack.peek())){
            minStack.pop();
        }
        stack.pop();
        // Objects can't be compared using the '==' operator
        // if(minStack.peek() == stack.peek()){
        //     minStack.pop();
        //     stack.pop();
        // }else{
        //     stack.pop();
        // }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}