class Solution {
    public String clearStars(String s) {
        int n = s.length();
        List<Integer>[] pos = new ArrayList[26];

        for (int i = 0; i < 26; i++) {
            pos[i] = new ArrayList<>();
        }

        boolean[] removed = new boolean[n];

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == '*') {
                removed[i] = true;

                for (int j = 0; j < 26; j++) {
                    if (!pos[j].isEmpty()) {
                        int idx = pos[j].remove(pos[j].size() - 1);
                        removed[idx] = true;
                        break;
                    }
                }
            } else {
                pos[c - 'a'].add(i);
            }
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (!removed[i]) {
                ans.append(s.charAt(i));
            }
        }

        return ans.toString();
    }
}