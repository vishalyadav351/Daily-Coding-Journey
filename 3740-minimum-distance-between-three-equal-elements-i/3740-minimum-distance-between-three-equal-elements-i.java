import java.util.*;

class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        
        int minDistance = Integer.MAX_VALUE;
        boolean found = false;
                for (List<Integer> indices : map.values()) {
            if (indices.size() >= 3) {
                found = true;
                for (int i = 0; i <= indices.size() - 3; i++) {
                    int first = indices.get(i);
                    int third = indices.get(i + 2);
                                        int currentDistance = 2 * (third - first);
                    minDistance = Math.min(minDistance, currentDistance);
                }
            }
        }
                return found ? minDistance : -1;
    }
}