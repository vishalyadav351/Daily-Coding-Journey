class Solution {
    public boolean hasAlternatingBits(int n) {
        long allOnes = (long) n ^ (n >> 1);
        return (allOnes & (allOnes + 1)) == 0;
    }
}