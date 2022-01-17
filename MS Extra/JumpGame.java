enum Situation {
    G,B,U
}

class JumpGame {
    Situation[] arr;
    public boolean canJump(int[] nums) {
        arr = new Situation[nums.length];
        Arrays.fill(arr, Situation.U);
        arr[arr.length-1] = Situation.G;
        return helper(nums, 0);
    }

    private boolean helper(int[] nums, int index) {
        if(arr[index] != Situation.U){
            return arr[index] == Situation.G;
        }

        int maxJump = Math.min(index + nums[index], nums.length - 1);
        for(int i = maxJump; i > index; i--){
            if(helper(nums, i)){
                arr[i] = Situation.G;
                return true;
            }
        }
        arr[index] = Situation.B;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Scratch().canJump(new int[]{2,3,1,1,4}));
    }
}

//Supplimentary Solution DP
class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i <= max) max = Math.max(max, i + nums[i]);
        } 
        return max >= nums.length - 1;
    }
}