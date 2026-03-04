class Solution {
    public int romanToInt(String s) {
        
        int total = 0;
        int prev = 0;
        
        for(int i = s.length() - 1; i >= 0; i--) {
            
            int current = value(s.charAt(i));
            
            if(current < prev) {
                total -= current;
            } else {
                total += current;
            }
            
            prev = current;
        }
        
        return total;
    }
    
    public int value(char c) {
        if(c == 'I') return 1;
        if(c == 'V') return 5;
        if(c == 'X') return 10;
        if(c == 'L') return 50;
        if(c == 'C') return 100;
        if(c == 'D') return 500;
        if(c == 'M') return 1000;
        return 0;
    }
}