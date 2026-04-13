class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int result = nums.length; 

        for (int index = 0; index < nums.length; index++) {
            if (nums[index] == target) {
                int gap = index - start;
                
                                if (gap < 0) {
                    gap = -gap;
                }
                if (gap < result) {
                    result = gap;
                }
                

                if (result == 0) return 0;
            }
        }
        return result;
    }
}