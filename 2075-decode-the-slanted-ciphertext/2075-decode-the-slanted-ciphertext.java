class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (rows == 1) return encodedText;

        int n = encodedText.length();
        int cols = n / rows;
        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < cols; j++) {
            for (int r = 0, c = j; r < rows && c < cols; r++, c++) {
                int index = r * cols + c;
                sb.append(encodedText.charAt(index));
            }
        }
        int i = sb.length() - 1;
        while (i >= 0 && sb.charAt(i) == ' ') {
            sb.deleteCharAt(i);
            i--;
        }

        return sb.toString();
    }
}
