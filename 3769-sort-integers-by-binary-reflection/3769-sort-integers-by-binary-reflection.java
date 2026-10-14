class Solution {
    public int[] sortByReflection(int[] nums) {
        Integer[] boxedNums = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            boxedNums[i] = nums[i];
        }

        java.util.Arrays.sort(boxedNums, (a, b) -> {
            int refA = getBinaryReflection(a);
            int refB = getBinaryReflection(b);
            if (refA != refB) {
                return Integer.compare(refA, refB);
            }
            return Integer.compare(a, b);
        });

        for (int i = 0; i < nums.length; i++) {
            nums[i] = boxedNums[i];
        }

        return nums;
    }

    private int getBinaryReflection(int n) {
        String binary = Integer.toBinaryString(n);
        String reversed = new StringBuilder(binary).reverse().toString();
        return Integer.parseInt(reversed, 2);
    }
}