import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

class SubSetsWithDuplicates {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();
        helper(set, new ArrayList<Integer>(), 0, nums);
        return new ArrayList<>(set);
    }

    private void helper(HashSet<List<Integer>> set, ArrayList<Integer> integers, int start, int[] nums) {
        ArrayList temp = new ArrayList(integers);
        Collections.sort(temp);
        set.add(temp);
        for (int i = start; i < nums.length; i++){
            integers.add(nums[i]);
            helper(set, integers, i+1, nums);
            integers.remove(integers.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,2,2,1};
        System.out.println(new Solution().subsetsWithDup(arr).toString());
    }
}