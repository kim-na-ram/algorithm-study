class Solution {
    public int nthUglyNumber(int n) {
        int[] primes = {2, 3, 5};
        PriorityQueue<Long> uglyPQ = new PriorityQueue<>();
        HashSet<Long> visited = new HashSet<>();

        uglyPQ.add(1L);
        visited.add(1L);

        long cur = 1L;
        for(int i = 0; i < n; i++) {
            cur = uglyPQ.poll();

            for(int prime : primes) {
                long newUgly = cur * prime;
                if(!visited.contains(newUgly)) {
                    uglyPQ.add(newUgly);
                    visited.add(newUgly);
                }
            }
        }

        return (int)cur;
    }
}