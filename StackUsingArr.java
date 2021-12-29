class ArrStack {
    int[] arr;
    int top;
    public ArrStack (int size) {
        this.arr = new int[size];
        this.top = -1;
    }
    
    public boolean push(int value){
        if (top == arr.length - 1)
            return false;
        
        arr[++top] = value;
        return true;
    }
    
    public int pop() {
        if(top == -1)
            return -1;
        return arr[top--];
    }
    
    public int peek() {
        if (top == -1)
            return -1;
        return arr[top];
    }
}