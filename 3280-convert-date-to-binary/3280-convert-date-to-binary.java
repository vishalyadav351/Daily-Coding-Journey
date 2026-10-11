class Solution {
    public String convertDateToBinary(String date) {
        String[] parts = date.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        return Integer.toBinaryString(year) + "-" +
               Integer.toBinaryString(month) + "-" +
               Integer.toBinaryString(day);
    }
}