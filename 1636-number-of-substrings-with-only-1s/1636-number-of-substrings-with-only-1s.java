class Solution {
    Map<Long, Integer> hm;
    public int numSub(String s) {
        long count = 0;
        long answer = 0;
        int mod = 1_000_000_007;
        hm = new HashMap<>();

        char[] arr = s.toCharArray();
        for(int i = 0; i <= arr.length; i++) {
            if(i < arr.length && arr[i] == '1') {
                count++;
            } else {
                hm.put(count, hm.getOrDefault(count, 0) + 1);
                count = 0;
            }
        }

        for(long key : hm.keySet()) {
            answer += key * (key + 1) / 2 * (long)hm.get(key) % mod;
        }

        return (int)(answer % mod);
    }
}