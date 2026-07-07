class Solution {
    // Helper function: चेक करने के लिए कि क्या 'days' दिनों में m गुलदस्ते बन सकते हैं
    private boolean canMakeBouquets(int[] bloomDay, int days, int m, int k) {
        int bouquets = 0;
        int count = 0;

        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= days) {
                count++; 
                if (count == k) {
                    bouquets++;
                    count = 0; 
                }
            } else {
                count = 0; 
            }
        }
        return bouquets >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        
        if ((long) m * k > bloomDay.length) {
            return -1;
        }
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }

        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canMakeBouquets(bloomDay, mid, m, k)) {
                ans = mid;        
                high = mid - 1;  
            } else {
                low = mid + 1;    
            }
        }
        return ans;
    }
}