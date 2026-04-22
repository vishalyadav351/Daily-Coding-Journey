import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();
        
        for (String q : queries) {
            for (String d : dictionary) {
                int diffCount = 0;
                                for (int i = 0; i < q.length(); i++) {
                    if (q.charAt(i) != d.charAt(i)) {
                        diffCount++;
                    }
                    if (diffCount > 2) {
                        break;
                    }
                }
                if (diffCount <= 2) {
                    result.add(q);
                    break; 
                }
            }
        }
        
        return result;
    }
}