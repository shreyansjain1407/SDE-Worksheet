import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++){
            for (int j = i+1; j < nums.length - 2; j++){
                int left = j+1, right = nums.length - 1;
                while (left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    System.out.println("I: " + i + " J: " + j + " left: " + left + " right: " + right);
                    if (sum == target){
                        list.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;right--;
                        while (nums[left-1] == nums[left] && left < right)
                            left++;
                        while (nums[right] == nums[right + 1] && right > left)
                            right--;
                    }else if (sum < target)
                        left++;
                    else
                        right--;
                }
                while (j+1 < nums.length && nums[j+1] == nums[j])
                    j++;
            }
            while (i+1 < nums.length && nums[i+1] == nums[i])
                i++;
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {1,0,-1,0,-2,2};
        System.out.println(new Scratch().fourSum(arr, 0).toString());
    }
}