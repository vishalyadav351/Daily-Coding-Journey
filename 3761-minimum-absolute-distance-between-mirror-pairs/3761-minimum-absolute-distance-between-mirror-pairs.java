import java.util.HashMap;

public class Solution {
    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;
        boolean found = false;

        for (int j = 0; j < nums.length; j++) {
            int currentVal = nums[j];
            if (map.containsKey(currentVal)) {
                int i = map.get(currentVal);
                int distance = j - i;
                minDistance = Math.min(minDistance, distance);
                found = true;
            }

            int reversed = reverse(currentVal);
                        map.put(reversed, j);
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