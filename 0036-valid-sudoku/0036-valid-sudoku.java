import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char currentVal = board[i][j];
                
                if (currentVal == '.') {
                    continue;
                }

                String rowKey = currentVal + " in row " + i;
                String colKey = currentVal + " in col " + j;
                String boxKey = currentVal + " in box " + (i / 3) + "-" + (j / 3);

                if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
                    return false;
                }
            }
        }

        return true;
    }
}