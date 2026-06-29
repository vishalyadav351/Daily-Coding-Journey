import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (numRows <= 0) {
            return result;
        }
        
        for (int i = 0; i < numRows; i++) {
            List<Integer> currentRow = new ArrayList<>();
                        for (int j = 0; j <= i; j++) {
               
                if (j == 0 || j == i) {
                    currentRow.add(1);
                } else {
                   
                    List<Integer> prevRow = result.get(i - 1);
                    int sum = prevRow.get(j - 1) + prevRow.get(j);
                    currentRow.add(sum);
                }
            }
                        result.add(currentRow);
        }
        
        return result;
    }
}