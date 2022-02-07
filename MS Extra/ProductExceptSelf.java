class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        long product = 1;
        boolean single = false, dzero = false;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                // System.out.println(single + " " + nums[i]);
                if(single){
                    dzero = true;
                    break;
                }
                single = true;
            }else{
                product *= nums[i];
            }
        }
        if(dzero)
            return new int[nums.length];

        int[] output = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(single && nums[i] != 0){
                output[i] = 0;
            }else if(nums[i] != 0){
                output[i] = (int) product / nums[i];
            }else{
                output[i] = (int) product;
            }
        }
        return output;
    }
}