class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // 1. Agar target mid par hi mil gaya
            if (nums[mid] == target) {
                return true;
            }
            
            // 2. Special Duplicate Case: Agar left, mid, aur right teeno barabar hain
            // Toh hum decide nahi kar sakte kaun sa part sorted hai. Ek-ek step andar badhenge.
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
                continue;
            }
            
            // 3. Case A: Left side perfect sorted hai
            if (nums[left] <= nums[mid]) {
                // Check karo kya target is left sorted part ki range mein aata hai?
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Left side mein dhoondo
                } else {
                    left = mid + 1;  // Right side mein dhoondo
                }
            } 
            // 4. Case B: Right side perfect sorted hai
            else {
                // Check karo kya target is right sorted part ki range mein aata hai?
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;  // Right side mein dhoondo
                } else {
                    right = mid - 1; // Left side mein dhoondo
                }
            }
        }
        
        return false;
    }
}