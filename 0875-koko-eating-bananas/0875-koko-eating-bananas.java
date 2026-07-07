import java.util.Arrays;

public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }
        
        int result = high;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (canEatAll(piles, h, mid)) {
                result = mid; 
                high = mid - 1; 
            } else {
                low = mid + 1;
            }
        }
        
        return result;
    }
    
    
    private boolean canEatAll(int[] piles, int h, int k) {
        long hoursSpent = 0;
        
        for (int pile : piles) {
            hoursSpent += (pile + k - 1) / k;
            
            if (hoursSpent > h) {
                return false;
            }
        }
        
        return hoursSpent <= h;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        
        int[] piles1 = {3, 6, 7, 11};
        int h1 = 8;
        System.out.println("Output 1: " + sol.minEatingSpeed(piles1, h1)); // 

        int[] piles2 = {30, 11, 23, 4, 20};
        int h2 = 5;
        System.out.println("Output 2: " + sol.minEatingSpeed(piles2, h2)); 
    }
}