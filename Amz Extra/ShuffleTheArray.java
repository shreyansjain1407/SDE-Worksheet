class ShuffleTheArray {
    public int[] shuffle(int[] nums, int n) {
        int[] output = new int[nums.length];
        int ptr1 = 0, ptr2 = n;
        for(int i = 0; i < 2*n; i+=2){
            output[i] = nums[ptr1++];
            output[i+1] = nums[ptr2++];
        }
        return output;
    }
}