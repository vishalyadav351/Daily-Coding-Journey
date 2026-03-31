class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int L = n + m - 1;
        char[] word = new char[L];
        boolean[] fixed = new boolean[L];
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (word[i + j] != '\0' && word[i + j] != str2.charAt(j)) {
                        return "";
                    }
                    word[i + j] = str2.charAt(j);
                    fixed[i + j] = true;
                }
            }
        }
        for (int i = 0; i < L; i++) {
            if (word[i] == '\0') {
                word[i] = 'a';
            }
        }
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {
                if (checkMatch(word, str2, i)) {
                    boolean fixed_violation = true;

                    for (int j = m - 1; j >= 0; j--) {
                        if (!fixed[i + j]) {
                            word[i + j] = 'b';
                            fixed_violation = false;
                            break; 
                        }
                    }
                    if (fixed_violation) return "";
                }
            }
        }
        for (int i = 0; i < n; i++) {
            boolean isMatch = checkMatch(word, str2, i);
            if (str1.charAt(i) == 'T' && !isMatch) return "";
            if (str1.charAt(i) == 'F' && isMatch) return "";
        }

        return new String(word);
    }
    private boolean checkMatch(char[] word, String str2, int start) {
        for (int j = 0; j < str2.length(); j++) {
            if (word[start + j] != str2.charAt(j)) return false;
        }
        return true;
    }
}