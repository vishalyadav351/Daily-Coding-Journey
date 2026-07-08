import java.util.Arrays;

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
       
        int low = 1;
        int high = Arrays.stream(nums).max().getAsInt();
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2; 
            if (getSumAfterDivision(nums, mid) <= threshold) {
                ans = mid;         
                high = mid - 1;    
            } else {
                low = mid + 1;    
            }
        }
        
        return ans;
    }

    private int getSumAfterDivision(int[] nums, int divisor) {
        int totalSum = 0;
        for (int num : nums) {
            
            totalSum += (num + divisor - 1) / divisor;
        }
        return totalSum;
    }
}