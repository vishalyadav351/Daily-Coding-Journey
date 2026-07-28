import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int startIndex, List<Integer> currentList, List<List<Integer>> result) {
      
        if (target == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            
            if (candidates[i] > target) break;

            if (i > startIndex && candidates[i] == candidates[i - 1]) continue;

            currentList.add(candidates[i]);
           
            backtrack(candidates, target - candidates[i], i + 1, currentList, result);
            
            currentList.remove(currentList.size() - 1);
        }
    }
}