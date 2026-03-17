class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        
        for (String op : operations) {
           
            if (op.charAt(1) == '+') {
                x++;
            } else {
                x--;
            }
        }
        
        return x;
    }
}