class Solution {
    public int maxFreqSum(String s) {
        Map<Character, Integer> alphabetNumbering = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            alphabetNumbering.put(s.charAt(i), alphabetNumbering.getOrDefault(s.charAt(i), 0) + 1);
        }

        int vowelMax = 0;
        int consonantMax = 0;
        for(Character key : alphabetNumbering.keySet()) {
            if(key == 'a' || key == 'e' || key == 'i' || key == 'o' || key == 'u') {
                vowelMax = Math.max(vowelMax, alphabetNumbering.get(key));
            } else {
                consonantMax = Math.max(consonantMax, alphabetNumbering.get(key));
            }
        }

        return vowelMax + consonantMax;
    }
}