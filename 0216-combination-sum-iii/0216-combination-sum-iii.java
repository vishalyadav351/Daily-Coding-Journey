import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, k, n, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int start, int kRemaining, int targetRemaining, List<Integer> path, List<List<Integer>> result) {
        if (kRemaining == 0 && targetRemaining == 0) {
            result.add(new ArrayList<>(path)); 
            return;
        }
        
        if (kRemaining < 0 || targetRemaining < 0) {
            return;
        }
        
        for (int i = start; i <= 9; i++) {
            path.add(i);
           
            backtrack(i + 1, kRemaining - 1, targetRemaining - i, path, result);
            
            path.remove(path.size() - 1);
        }
    }
}