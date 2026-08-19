class Solution {
    public String countAndSay(int n) {
        String current = "1";
        
        for (int i = 2; i <= n; i++) {
            StringBuilder nextString = new StringBuilder();
            int length = current.length();
            int j = 0;
            
            while (j < length) {
                int count = 1;
                while (j + 1 < length && current.charAt(j) == current.charAt(j + 1)) {
                    count++;
                    j++;
                }
                nextString.append(count).append(current.charAt(j));
                j++;
            }
            
            current = nextString.toString();
        }
        
        return current;
    }
}