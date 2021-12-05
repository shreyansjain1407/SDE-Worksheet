import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PermutationsOfUniqueList {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        for (int n : nums)
            numbers.add(n);
        helper(list, numbers, new ArrayList<Integer>());
        return list;
    }

    private void helper(List<List<Integer>> list, List<Integer> numbers, ArrayList<Integer> integers) {
        if(numbers.size() == 1){
            integers.add(numbers.get(0));
            list.add(new ArrayList<>(integers));
            integers.remove(integers.size()-1);
        }
        for(int i = 0; i < numbers.size(); i++){
            integers.add(numbers.remove(i));
            helper(list, numbers, integers);
            numbers.add(i,integers.remove(integers.size()-1));
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(new Solution().permute(nums).toString());
    }
}