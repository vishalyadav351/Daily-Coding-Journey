class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        String baseWord = strs[0];
       
        for (int i = 0; i < baseWord.length(); i++) {
            char c = baseWord.charAt(i);
            
            for (int j = 1; j < strs.length; j++) {
               
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return baseWord.substring(0, i);
                }
            }
        }
        
      
        return baseWord;
    }
}