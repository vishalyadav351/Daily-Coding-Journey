class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        
        int f = 0, max = 0;
        int maz;
        for(int i=0; i<nums.length; i++)
        {
            if (nums[i]==1)
            {
                f++;
                max++;
            }
            else
            {
                f = 0;
            }
            maz=max;
            max=0;
        }
        if(maz>max){
            return maz;

        }
        else 
        {
            return max;
        }

    }

}