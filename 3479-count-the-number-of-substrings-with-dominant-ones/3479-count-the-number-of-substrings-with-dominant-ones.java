class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] pref = new int[n + 1];
        pref[0] = -1;

        for(int i = 0; i < n; i++) {
            if(i == 0 || (i > 0 && s.charAt(i - 1) == '0')) {
                pref[i + 1] = i;
            } else {
                pref[i + 1] = pref[i];
            }
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            int zeroCount = s.charAt(i - 1) == '0' ? 1 : 0;
            int j = i;

            while(j > 0 && zeroCount * zeroCount <= n) {
                int oneCount = (i - pref[j]) - zeroCount;
                if (zeroCount * zeroCount <= oneCount) {
                    result += Math.min(j - pref[j], oneCount - zeroCount * zeroCount + 1);
                }

                j = pref[j];
                zeroCount++;
            }
        }

        return result;
    }
}