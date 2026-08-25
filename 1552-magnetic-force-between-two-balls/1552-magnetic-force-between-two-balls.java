class Solution {

    boolean isPossible(int[] position, int distance, int m) {
        int balls = 1;
        int lastPos = position[0];

        for (int i = 1; i < position.length; i++) {

            if (position[i] - lastPos >= distance) {
                balls++;
                lastPos = position[i];

                if (balls == m) {
                    return true;
                }
            }
        }

        return false;
    }

    public int maxDistance(int[] position, int m) {

        Arrays.sort(position);

        int start = 1;
        int end = position[position.length - 1] - position[0];

        int ans = 0;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (isPossible(position, mid, m)) {
                ans = mid;
                start = mid + 1;
            } 
            else {
                end = mid - 1;
            }
        }

        return ans;
    }
}