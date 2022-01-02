class NextGreaterElementApr2 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] aux = new int[nums2.length];
        Map<Integer, Integer> auxMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums2.length; i++){
            map.put(nums2[i], i);
        }

        for(int i = nums2.length; i >= 0; i++){
            if(stack.isEmpty()){
                aux[i] = -1;
                stack.push(i);
            }else{
                while(!stack.isEmpty() && nums2[stack.peek()]<=nums2[i]){
                    stack.poll();
                }
                if(stack.isEmpty()){
                    aux[i] = -1;
                }else{
                    aux[i] = nums2[stack.peek()];
                }
                stack.push(i);
            }
        }
        for(int i = 0; i < nums[1].length; i++){
            nums1[i] = aux[map.get(nums1[i])];
        }
        return nums1;
    }
}