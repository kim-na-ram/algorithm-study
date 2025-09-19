class Solution {
    public int maxFreqSum(String s) {
        int[] frep = new int[26];
        int maxVowel = 0;
        int maxConsonant = 0;

        for(int i = 0; i < s.length(); i++) {
            int alpha = s.charAt(i) - 'a';
            frep[alpha]++;

            if(alpha == 'a' - 'a' || alpha == 'e' - 'a' || alpha == 'i' - 'a' || alpha == 'o' - 'a' || alpha == 'u' - 'a') {
                maxVowel = Math.max(maxVowel, frep[alpha]);
            } else {
                maxConsonant = Math.max(maxConsonant, frep[alpha]);
            }
        }

        return maxVowel + maxConsonant;
    }
}