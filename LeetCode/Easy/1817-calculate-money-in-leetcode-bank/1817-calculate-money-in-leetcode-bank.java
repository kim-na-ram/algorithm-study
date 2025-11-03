class Solution {
    public int totalMoney(int n) {
        int prevDay = 1;
        int prevMonday = prevDay;

        int sum = prevMonday;
        for(int i = 1; i < n; i++) {
            if(i % 7 == 0) {
                prevMonday = prevMonday + 1;
                prevDay = prevMonday;
            } else {
                prevDay += 1;
            }

            sum += prevDay;
        }

        return sum;
    }
}