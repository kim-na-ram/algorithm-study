class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> group = new HashMap<>();

        int max = 0;
        int answer = 0;
        for(int i = 1; i <= n; i++) {
            String s = Integer.toString(i);

            int sum = 0;
            for(int j = 0; j < s.length(); j++) {
                sum += s.charAt(j) - '0';
            }

            group.put(sum, group.getOrDefault(sum, 0) + 1);
            max = Math.max(max, group.get(sum));
        }

        for(int key : group.keySet()) {
            if(max == group.get(key)) {
                answer++;
            }
        }

        return answer;
    }
}