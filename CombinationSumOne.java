import javax.print.DocFlavor;
import java.util.*;

class CombinationSumOne {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        HashSet<List<Integer>> set = new HashSet<>();
        helper(set, new ArrayList<>(), 0, candidates, target, 0);
        for (int i = candidates.length - 1; i >= 0; i--){
            helper(set, new ArrayList<>(), i, candidates, target, 0);
        }
        return new ArrayList<>(set);
    }

    private void helper(HashSet<List<Integer>> set, ArrayList<Integer> integers, int start, int[] candidates, int target, int curSum) {
        if (start < 0)return;
        int presentSum = curSum+candidates[start];
        if (presentSum == target){
            integers.add(candidates[start]);
            set.add(new ArrayList<>(integers));
            integers.remove(integers.size() - 1);
            // return;
        }

        if(presentSum < target){
            integers.add(candidates[start]);
            helper(set,integers,start,candidates,target,presentSum);
            integers.remove(integers.size()-1);
        }
        helper(set,integers, start-1,candidates,target,curSum);
    }
}


