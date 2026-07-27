import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, candidates, target, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int index, int[] candidates, int target, List<Integer> currentList, List<List<Integer>> result) {
      
        if (target == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }
        
        if (target < 0) {
            return;
        }
        
        for (int i = index; i < candidates.length; i++) {
            currentList.add(candidates[i]);
          
            backtrack(i, candidates, target - candidates[i], currentList, result);
          
            currentList.remove(currentList.size() - 1);
        }
    }
}