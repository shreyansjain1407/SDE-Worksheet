class MaxAreaInHistogramRewrite {
    public int largestRectangleArea(int[] heights) {
        int[] prevSmallest = new int[heights.length];
        int[] lastSmallest = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < heights.length; i++){
            if(stack.isEmpty() || heights[stack.peek()] < heights[i]){
                if(stack.isEmpty()){
                    prevSmallest[i] = 0;
                }else {
                    prevSmallest[i] = stack.peek()+1;
                }
                stack.push(i);
            }else{
                while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    stack.push(i);
                    prevSmallest[i] = 0;
                }else {
                    prevSmallest[i] = stack.peek()+1;
                    stack.push(i);
                }
            }
        }
        stack.clear();
        for(int i = heights.length-1; i >= 0; i--){
            if(stack.isEmpty() || heights[stack.peek()] < heights[i]){
                if(stack.isEmpty()){
                    lastSmallest[i] = heights.length;
                }else {
                    lastSmallest[i] = stack.peek();
                }
                stack.push(i);
            }else{
                while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    stack.push(i);
                    lastSmallest[i] = heights.length;
                }else {
                    lastSmallest[i] = stack.peek();
                    stack.push(i);
                }
            }
        }
        int maxArea = 0;
        for(int i = 0; i < heights.length; i++){
            maxArea = Math.max((lastSmallest[i] - prevSmallest[i])*heights[i], maxArea);
        }
        return maxArea;
    }
}