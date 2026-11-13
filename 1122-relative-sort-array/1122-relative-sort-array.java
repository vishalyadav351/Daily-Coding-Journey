class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];

        for (int num : arr1) {
            count[num]++;
        }

        int index = 0;

        for (int num : arr2) {
            while (count[num] > 0) {
                arr1[index++] = num;
                count[num]--;
            }
        }

        for (int i = 0; i <= 1000; i++) {
            while (count[i] > 0) {
                arr1[index++] = i;
                count[i]--;
            }
        }

        return arr1;
    }
}