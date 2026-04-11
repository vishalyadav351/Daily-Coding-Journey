import java.util.*;

class Solution {
    public int minimumDistance(int[] nums) { // 'minDistance' ko 'minimumDistance' kar diya
        Map<Integer, List<Integer>> posMap = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            posMap.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        int minDistance = Integer.MAX_VALUE;
        boolean found = false;
        
        for (List<Integer> indices : posMap.values()) {
            if (indices.size() < 3) {
                continue;
            }
            
            found = true;
            for (int i = 0; i <= indices.size() - 3; i++) {
                int firstIndex = indices.get(i);
                int thirdIndex = indices.get(i + 2);
                
                int currentDist = 2 * (thirdIndex - firstIndex);
                minDistance = Math.min(minDistance, currentDist);
            }
        }
        
        return found ? minDistance : -1;
    }
}