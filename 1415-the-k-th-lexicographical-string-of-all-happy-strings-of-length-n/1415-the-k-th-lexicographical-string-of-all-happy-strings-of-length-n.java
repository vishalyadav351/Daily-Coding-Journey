class Solution {
    int count = 0; 
    String result = "";

    public String getHappyString(int n, int k) {
        count = 0;
        result = "";
        
      
        generateStrings(n, k, new StringBuilder());
        
        return result;
    }

    private void generateStrings(int n, int k, StringBuilder current) {
        if (!result.isEmpty()) return;


        if (current.length() == n) {
            count++;
            if (count == k) {
                result = current.toString();
            }
            return;
        }

  
        for (char ch = 'a'; ch <= 'c'; ch++) {
          
            if (current.length() > 0 && current.charAt(current.length() - 1) == ch) {
                continue;
            }

            current.append(ch);

            generateStrings(n, k, current);

          
            current.deleteCharAt(current.length() - 1);
        }
    }
}