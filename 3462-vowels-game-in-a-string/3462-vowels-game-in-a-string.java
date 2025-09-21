class Solution {
    public boolean doesAliceWin(String s) {
        List<Integer> vowelLocation = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            if(isVowel(s.charAt(i))) {
                vowelLocation.add(i);
            }
        }

        if(vowelLocation.size() == 0) return false;

        if(vowelLocation.size() % 2 == 0) {
            // vowel 총 개수가 짝수면 최대 홀수 개만큼 제거
            if(vowelLocation.size() >= 2) {
                int startIndex = vowelLocation.get(vowelLocation.size() - 2);
                if(startIndex != s.length() - 1) return true;
            }

            return false;
        } else {
            // vowel 총 개수가 홀수면 처음에 모든걸 제거
            return true;
        }
    }

    public boolean isVowel(char c) {
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
        else return false;
    }
}