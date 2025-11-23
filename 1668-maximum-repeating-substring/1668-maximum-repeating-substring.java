class Solution {
    public int maxRepeating(String sequence, String word) {
        int n = 0;
        String exist = word;

        while(sequence.contains(exist)) {
            n++;
            exist += word;
        }

        return n;
    }
}