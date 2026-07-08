class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        
        for (int w : weights) {
            low = Math.max(low, w);
            high += w;
        }
                while (low < high) {
            int mid = low + (high - low) / 2;
            
            if (canShip(weights, days, mid)) {
                high = mid;
            } else {
                low = mid + 1; 
            }
        }
        
        return low; 
    }
    
    private boolean canShip(int[] weights, int days, int capacity) {
        int daysNeeded = 1;
        int currentWeight = 0;
        
        for (int w : weights) {
            if (currentWeight + w > capacity) {
                daysNeeded++;
                currentWeight = w; 
            } else {
                currentWeight += w; 
            }
        }
                return daysNeeded <= days;
    }
}