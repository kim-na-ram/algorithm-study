class Solution {
    public int[] getNoZeroIntegers(int n) {
        int a = 0, b = 0;
        for(int i = 1; i < n; i++) {
            a = i;
            b = n - a;

            String strA = Integer.toString(a);
            String strB = Integer.toString(b);
            if(strA.contains("0") || strB.contains("0")) continue;
            else break;
        }

        return new int[]{a, b};
    }
}