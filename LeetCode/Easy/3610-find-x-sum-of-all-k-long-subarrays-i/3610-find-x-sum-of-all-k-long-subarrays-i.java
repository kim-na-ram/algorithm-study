class Solution {
    // 1, 1, 2, 2, 3
    // 1 :: 2, 2 :: 2, 3 :: 1
    // 1, 2, 2, 3, 4
    // 1 :: 1, 2 :: 2, 3 :: 1, 4 :: 1
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        Map<Integer, Integer> hm = new HashMap<>();

        for(int i = 0; i < k; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

        int[] answer = new int[Math.max(0, n - k + 1)];

        int idx = 0;
        answer[idx++] = computeXSum(hm, n, x);

        for(int i = 1; i <= n - k; i++) {
            int prev = nums[i - 1];
            int cur = nums[i + k - 1];
            if(prev != cur) {
                hm.put(prev, hm.get(prev) - 1);
                hm.put(cur, hm.getOrDefault(cur, 0) + 1);

                answer[idx++] = computeXSum(hm, n, x);
            } else {
                answer[idx] = answer[idx-1];
                idx++;
            }
        }

        return answer;
    }

    public int computeXSum(Map<Integer, Integer> hm, int n, int x) {
        int countArr[][] = new int[n + 1][2];
        int idx = 0;
        for(int key : hm.keySet()) {
            countArr[idx][0] = key;
            countArr[idx++][1] = hm.get(key);
        }

        Arrays.sort(countArr, (o1, o2) -> {
            if(o1[1] == o2[1]) {
                return o2[0] - o1[0];
            } else return o2[1] - o1[1];
        });

        int sum = 0;
        for(int i = 0; i < x; i++) {
            sum += countArr[i][0] * countArr[i][1];
        }

        return sum;
    }
}