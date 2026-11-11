class Solution {
    public double[] sampleStats(int[] count) {
        double[] ans = new double[5];

        long total = 0;
        long sum = 0;
        int min = -1;
        int max = -1;
        int mode = 0;
        int maxFreq = 0;

        for (int i = 0; i < 256; i++) {
            if (count[i] > 0) {
                if (min == -1) {
                    min = i;
                }
                max = i;

                total += count[i];
                sum += (long) i * count[i];

                if (count[i] > maxFreq) {
                    maxFreq = count[i];
                    mode = i;
                }
            }
        }

        ans[0] = min;
        ans[1] = max;
        ans[2] = (double) sum / total;
        ans[4] = mode;

        long mid1 = (total + 1) / 2;
        long mid2 = (total + 2) / 2;

        long cumulative = 0;
        double median1 = 0;
        double median2 = 0;

        for (int i = 0; i < 256; i++) {
            cumulative += count[i];

            if (cumulative >= mid1 && median1 == 0) {
                median1 = i;
            }

            if (cumulative >= mid2) {
                median2 = i;
                break;
            }
        }

        ans[3] = (median1 + median2) / 2.0;

        return ans;
    }
}