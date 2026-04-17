import java.util.HashMap;

public class Solution {
    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;
        boolean found = false;

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int mirrorOfCurrent = reverse(current);
            if (map.containsKey(mirrorOfCurrent)) {
                int distance = i - map.get(mirrorOfCurrent);
                minDistance = Math.min(minDistance, distance);
                found = true;
            }

           
            map.put(current, i);
        }

        return found ? minDistance : -1;
    }

    private int reverse(int n) {
        int rev = 0;
        while (n > 0) {
            rev = (rev * 10) + (n % 10);
            n /= 10;
        }
        return rev;
    }
}