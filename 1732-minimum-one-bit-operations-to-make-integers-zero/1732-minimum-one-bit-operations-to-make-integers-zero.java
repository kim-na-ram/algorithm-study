class Solution {
    public int minimumOneBitOperations(int n) {
        String binary = Integer.toBinaryString(n);
        StringBuilder answer = new StringBuilder();
        answer.append(binary.charAt(0));

        for(int i = 1; i < binary.length(); i++) {
            answer.append(answer.charAt(i - 1) == binary.charAt(i) ? '0' : '1');
        }

        return Integer.parseInt(answer.toString(), 2);
    }
}