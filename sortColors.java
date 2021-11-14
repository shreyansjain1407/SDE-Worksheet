class Solution {
    public void sortColors(int[] nums) {
        int zero = 0, two = nums.length - 1, i = 0;
        while(i <= two){
            if(nums[i] == 0){
                nums[i] = nums[zero];
                nums[zero] = 0;
                zero++;i++;
            }else if(nums[i] == 2){
                nums[i] = nums[two];
                nums[two] = 2;
                two--;
            }else
                i++;
        }
    }
}