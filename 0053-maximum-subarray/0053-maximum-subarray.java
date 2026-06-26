class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = 0;
        int maxSum = nums[0];

        for (int num : nums){
            currentSum += num;
            if (currentSum > maxSum)
            {
                maxSum = currentSum;

            }
            if(currentSum < 0)
            {
                currentSum = 0;

            }
        }
        return maxSum;
    }
}