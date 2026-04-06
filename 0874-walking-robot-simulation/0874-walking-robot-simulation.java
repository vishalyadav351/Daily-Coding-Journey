import java.util.*;

public class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
       
        Set<Long> blockedPaths = new HashSet<>();
        for (int[] obs : obstacles) {
            long ox = (long) obs[0] + 30000;
            long oy = (long) obs[1] + 30000;
            blockedPaths.add((ox << 16) | oy);
        }

        int[][] moveSteps = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        int posX = 0, posY = 0;
        int currentDir = 0; 
        int bestDistanceSq = 0;

        for (int action : commands) {
            if (action == -1) {
                currentDir = (currentDir + 1) % 4;
            } else if (action == -2) {
                currentDir = (currentDir + 3) % 4;
            } else {
                for (int step = 0; step < action; step++) {
                    int nextX = posX + moveSteps[currentDir][0];
                    int nextY = posY + moveSteps[currentDir][1];
                    
                    long nextPosKey = ((long) nextX + 30000 << 16) | ((long) nextY + 30000);
                    
                    if (blockedPaths.contains(nextPosKey)) {
                        break;
                    }
                    
                    posX = nextX;
                    posY = nextY;
                    
                    int currentDistSq = posX * posX + posY * posY;
                    if (currentDistSq > bestDistanceSq) {
                        bestDistanceSq = currentDistSq;
                    }
                }
            }
        }
        
        return bestDistanceSq;
    }
}