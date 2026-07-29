import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int startIndex, int[] nums, List<Integer> currentPath, List<List<Integer>> result) {
        result.add(new ArrayList<>(currentPath));

        for (int i = startIndex; i < nums.length; i++) {
         
            if (i > startIndex && nums[i] == nums[i - 1]) {
                continue;
            }

            currentPath.add(nums[i]);
          
            backtrack(i + 1, nums, currentPath, result);
           
            currentPath.remove(currentPath.size() - 1);
        }
    }
}