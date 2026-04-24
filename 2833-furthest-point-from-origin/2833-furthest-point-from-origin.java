class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int countL = 0;
        int countR = 0;
        int countUnderscore = 0;
        for (int i = 0; i < moves.length(); i++) {
            char move = moves.charAt(i);
            if (move == 'L') {
                countL++;
            } else if (move == 'R') {
                countR++;
                } else {
                countUnderscore++;
            }
        }
        int baseDistance = Math.abs(countL - countR);
        return baseDistance + countUnderscore;
        }
}