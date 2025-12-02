class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        ans[1] = 1;
        int square = 2, next = (int)Math.pow(2, square);
        for(int i = 2; i <= n; i++) {
            int current = (int)Math.pow(2, square - 1);
            if(i == current) ans[i] = 1;
            else if(i < next) {
                ans[i] = ans[current] + ans[i - current];
            } else {
                ans[i] = 1;
                square++;
                next = (int)Math.pow(2, square);
            }
        }

        return ans;
    }
}