class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int[] lsmaller = new int[heights.length];
        int[] rsmaller = new int[heights.length];
        Stack<Integer> lstack = new Stack<Integer>();
        Stack<Integer> rstack = new Stack<Integer>();
        for(int i = 0; i < heights.length; i++) {
            if(lstack.isEmpty()){
                lstack.push(i);
                lsmaller[i] = i;
            }else{
                while(!lstack.isEmpty() && heights[lstack.peek()] >= heights[i]){
                    lstack.pop();
                }
                lsmaller[i] = (lstack.isEmpty())?0:lstack.peek()+1;
                lstack.push(i);
            }

            int j = heights.length - i -1;
            if(rstack.isEmpty()){
                rstack.push(j);
                rsmaller[j] = j;
            }else{
                while(!rstack.isEmpty() && heights[rstack.peek()] >= heights[j]){
                    rstack.pop();
                }
                rsmaller[j] = (rstack.isEmpty())?heights.length-1:rstack.peek()-1;
                rstack.push(j);
            }
        }

        int maxArea = 0;
        for(int i = 0; i < heights.length; i++){
            maxArea = Math.max(maxArea, ((rsmaller[i] - lsmaller[i] +1)*heights[i]));
        }
        return maxArea;
    }
}