class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        final int n = apple.length, m = capacity.length;

        int sum = 0;
        for(int a : apple) {
            sum += a;
        }

        Arrays.sort(capacity);

        for(int i = m - 1; i >= 0; i--) {
            sum -= capacity[i];

            if(sum <= 0) return m - i;
        }

        return m;
    }
}