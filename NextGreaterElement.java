class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> greater = new Stack<>();
        int[] aux = new int[nums2.length];
        for (int i = nums2.length-1; i >=0; i--){
            map.put(nums2[i], i);
            if(greater.isEmpty()){
                aux[i] = -1;
                greater.push(nums2[i]);
            }else{
                int temp = -1;
                while(!greater.isEmpty()){
                    if(greater.peek() > nums2[i]){
                        temp = greater.peek();
                        break;
                    }else {
                        greater.pop();
                    }
                }
                greater.push(nums2[i]);
                aux[i] = temp;
            }
        }
        int[] out = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++){
            out[i] = aux[map.get(nums1[i])];
        }
        return out;
    }
}