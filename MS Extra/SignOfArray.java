class SignOfArray {
    public int arraySign(int[] nums) {
        int negs = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0){
                negs++;
            }else if(nums[i] == 0){
                return 0;
            }
        }
        return (negs % 2 == 0)?1:-1;
    }
}