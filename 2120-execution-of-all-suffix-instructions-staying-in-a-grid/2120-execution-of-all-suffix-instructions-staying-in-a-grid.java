class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int m = s.length();
        int[] answer = new int[m];

        for (int i = 0; i < m; i++) {
            int row = startPos[0];
            int col = startPos[1];
            int count = 0;

            for (int j = i; j < m; j++) {
                char move = s.charAt(j);

                if (move == 'L') {
                    col--;
                } else if (move == 'R') {
                    col++;
                } else if (move == 'U') {
                    row--;
                } else if (move == 'D') {
                    row++;
                }

                if (row < 0 || row >= n || col < 0 || col >= n) {
                    break;
                }

                count++;
            }

            answer[i] = count;
        }

        return answer;
    }
}