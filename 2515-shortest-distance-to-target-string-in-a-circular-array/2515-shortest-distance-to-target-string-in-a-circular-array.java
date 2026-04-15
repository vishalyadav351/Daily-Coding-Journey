class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        // Humne 101 liya kyunki max length 100 hai, toh 101 sabse bada distance hoga
        int finalAns = 101; 
        
        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                
                int dist1 = i - startIndex;
                if (dist1 < 0) {
                    dist1 = -dist1; 
                }
                
                int dist2 = n - dist1;
                
                int currentBest;
                if (dist1 < dist2) {
                    currentBest = dist1;
                } else {
                    currentBest = dist2;
                }
                
                                if (currentBest < finalAns) {
                    finalAns = currentBest;
                }
            }
        }
                if (finalAns == 101) {
            return -1;
        } else {
            return finalAns;
        }
    }
}