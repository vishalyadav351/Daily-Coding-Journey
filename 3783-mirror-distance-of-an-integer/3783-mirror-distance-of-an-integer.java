class Solution {
    public int mirrorDistance(int n) {
        int originalN = n;
        long reversedN = 0; 
        int temp = n;
        while (temp > 0) {
            int lastDigit = temp % 10;     
            reversedN = (reversedN * 10) + lastDigit;
            temp = temp / 10;              
        }
        long result = Math.abs((long)originalN - reversedN);

        return (int)result;
    }
}