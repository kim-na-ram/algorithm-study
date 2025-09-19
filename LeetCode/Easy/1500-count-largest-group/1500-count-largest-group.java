class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> group = new HashMap<>();

        int max = 0;
        int answer = 0;
        for(int i = 1; i <= n; i++) {
            int sum = 0;
            int rest = i;
            while(rest > 0) {
                if(rest >= 10) {
                    sum += rest % 10;
                    rest = rest / 10;
                } else {
                    sum += rest;
                    break;
                }
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