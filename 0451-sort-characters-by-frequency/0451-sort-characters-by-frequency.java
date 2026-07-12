import java.util.*;

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
       
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        
        maxHeap.addAll(map.keySet());
        
        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char current = maxHeap.poll(); 
            int count = map.get(current); 
            
            for (int i = 0; i < count; i++) {
                result.append(current);
            }
        }
        
        return result.toString();
    }
}