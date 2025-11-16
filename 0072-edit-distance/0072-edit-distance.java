class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int max = 0;

        if(word1.isEmpty() || word2.isEmpty()) return n > m ? n : m;
        if(word1.equals(word2)) return 0;

        int[][] lcs = new int[n + 1][m + 1];
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                if(i == 0 || j == 0) {
                    lcs[i][j] = i == 0 ? j : i;
                } else {
                    if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        lcs[i][j] = lcs[i - 1][j - 1];
                        max = max > lcs[i][j] ? max : lcs[i][j];
                    } else {
                        lcs[i][j] = Math.min(lcs[i - 1][j], Math.min(lcs[i][j - 1], lcs[i - 1][j - 1])) + 1;
                    }
                }
            }
        }

        return lcs[n][m];
    }
}