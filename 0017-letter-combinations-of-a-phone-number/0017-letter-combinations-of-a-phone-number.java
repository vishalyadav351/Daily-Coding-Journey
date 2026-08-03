import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        
        ans.add("");
        
        String[] mapping = new String[] {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        
        for (char digitChar : digits.toCharArray()) {
            int index = digitChar - '0';
            String letters = mapping[index];
            List<String> nextList = new ArrayList<>();
           
            for (String existing : ans) {
                for (char letter : letters.toCharArray()) {
                    nextList.add(existing + letter);
                }
            }
            
            ans = nextList;
        }
        
        return ans;
    }
}