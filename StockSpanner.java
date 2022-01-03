class StockSpanner {
    int index = 0;
    Stack<int[]> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        if(stack.isEmpty()){
            stack.push(new int[]{price, index});
            return ++index;
        }
        int curIndex = index;
        while(!stack.isEmpty() && stack.peek()[0] <= price){
            stack.pop();
        }
        int output = (stack.isEmpty())?curIndex: curIndex - stack.peek()[1];
        stack.push(new int[]{price, index++});
        return output;
    }
}