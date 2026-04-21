import java.util.*;

class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        UnionFind uf = new UnionFind(n);

        // 1. Group indices using Union-Find
        for (int[] swap : allowedSwaps) {
            uf.union(swap[0], swap[1]);
        }

        // 2. Map each root to the values available in its component
        // Map: RootIndex -> {Value -> Frequency}
        Map<Integer, Map<Integer, Integer>> components = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            components.putIfAbsent(root, new HashMap<>());
            Map<Integer, Integer> counts = components.get(root);
            counts.put(source[i], counts.getOrDefault(source[i], 0) + 1);
        }

        // 3. Compare with target
        int totalMatches = 0;
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            Map<Integer, Integer> counts = components.get(root);
            int targetVal = target[i];
            
            if (counts.getOrDefault(targetVal, 0) > 0) {
                totalMatches++;
                counts.put(targetVal, counts.get(targetVal) - 1);
            }
        }

        // Hamming distance = Total elements - matching elements
        return n - totalMatches;
    }

    // Standard Union-Find (Disjoint Set Union) Class
    class UnionFind {
        private int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        public int find(int i) {
            if (parent[i] == i) return i;
            return parent[i] = find(parent[i]); // Path compression
        }

        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                parent[rootI] = rootJ;
            }
        }
    }
}