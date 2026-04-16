import java.util.*;

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;

        // Step 1: map value -> indices list
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        int[] best = new int[n];
        Arrays.fill(best, -1);

        for (List<Integer> list : map.values()) {
            int size = list.size();
            if (size == 1) continue;
            for (int i = 0; i < size; i++) {
                int curr = list.get(i);
                int prev = list.get((i - 1 + size) % size);
                int next = list.get((i + 1) % size);
                int d1 = Math.abs(curr - prev);
                d1 = Math.min(d1, n - d1);
                int d2 = Math.abs(curr - next);
                d2 = Math.min(d2, n - d2);
                best[curr] = Math.min(d1, d2);
            }
        }
        List<Integer> ans = new ArrayList<>();

        for (int q : queries) {
            ans.add(best[q]);
        }

        return ans;
    }
}