import java.util.*;

class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] arr = new long[n];
                Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        for (List<Integer> indices : map.values()) {
            int m = indices.size();
            if (m <= 1) continue;
            long totalSum = 0;
            for (int idx : indices) {
                totalSum += idx;
            }

            long prefixSum = 0;
            for (int i = 0; i < m; i++) {
                long currentIdx = indices.get(i); 
                long leftCount = i;
                long rightCount = m - 1 - i;
                long suffixSum = totalSum - prefixSum - currentIdx;
                long leftTotal = (leftCount * currentIdx) - prefixSum;
                long rightTotal = suffixSum - (rightCount * currentIdx);
                arr[(int)currentIdx] = leftTotal + rightTotal;
                prefixSum += currentIdx;
            }
        }

        return arr;
    }
}