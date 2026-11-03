class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        int n = vals.length;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (vals[v] > 0) adj.get(u).add(vals[v]);
            if (vals[u] > 0) adj.get(v).add(vals[u]);
        }

        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            List<Integer> neighbors = adj.get(i);
            neighbors.sort(Collections.reverseOrder());

            int sum = vals[i];

            for (int j = 0; j < Math.min(k, neighbors.size()); j++) {
                sum += neighbors.get(j);
            }

            ans = Math.max(ans, sum);
        }

        return ans;
    }
}