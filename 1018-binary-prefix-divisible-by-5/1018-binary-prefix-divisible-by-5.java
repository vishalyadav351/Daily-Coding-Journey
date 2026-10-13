import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> result = new ArrayList<>(nums.length);
        int current = 0;
        
        for (int bit : nums) {
            current = ((current << 1) + bit) % 5;
            result.add(current == 0);
        }
        
        return result;
    }
}