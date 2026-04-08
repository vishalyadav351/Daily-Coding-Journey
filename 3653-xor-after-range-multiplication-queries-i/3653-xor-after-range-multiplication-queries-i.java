class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        long _M = 1000000007L;
        for (int[] q : queries) {
            int _s = q[0];
            int _e = q[1]; 
            int _j = q[2]; 
            long _v = q[3]; 
            
            for (int k = _s; k <= _e; k += _j) {
                nums[k] = (int)(( (long)nums[k] * _v ) % _M);
            }
        }
        int result = 0;
        for (int element : nums) {
            result ^= element;
        }
        
        return result;
    }
}
