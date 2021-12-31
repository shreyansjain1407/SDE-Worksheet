class LargestRectangleAreaAp2 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<Integer>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            if(stack.isEmpty()){
                stack.add(i);
            }else{
                while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                    int temp = heights[stack.pop()];
                    maxArea = Math.max(maxArea, (i - ((stack.isEmpty())?0:(stack.peek() + 1)))*temp);
                }
                stack.push(i);
            }
        }
        while(!stack.isEmpty() && heights[stack.peek()] > 0){
            int temp = heights[stack.pop()];
            maxArea = Math.max(maxArea, (heights.length - ((stack.isEmpty())?0:(stack.peek() + 1)))*temp);
        }
        return maxArea;
    }
}