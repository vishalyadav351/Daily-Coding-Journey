class Solution {
    public int beautySum(String s) {
        int totalBeauty = 0 ;
        int n = s.length();

        for(int i =0; i< n; i++)
        {
            int [] freq = new int [26];
            for(int j =  i ; j < n; j++)
            {
                int charIndex = s.charAt(j) -'a';
                freq[charIndex]++;
                totalBeauty += getBeauty(freq);
            }
        }
        return totalBeauty;
    }
    private int getBeauty (int[] freq)
    {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int f : freq)
        {
            if (f > 0)
            {
                max = Math.max(max, f);
                min = Math.min(min, f);
            }
        }
        return (max == Integer.MAX_VALUE || min == Integer.MIN_VALUE) ? 0 : (max - min);
    }
}