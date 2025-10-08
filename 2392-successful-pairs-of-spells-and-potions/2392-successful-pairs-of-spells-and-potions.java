class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] pairs = new int[n];

        // sorting
        Arrays.sort(potions);

        for(int i = 0; i < n; i++) {
            // binarySearch
            int start = 0;
            int end = m - 1;
            while(start <= end) {
                 int mid = (start + end) / 2;
                 long pair = (long)spells[i] * potions[mid];

                 if(pair >= success) {
                    end = mid - 1;
                 } else {
                    start = mid + 1;
                 }
            }

            pairs[i] = m - start;
        }

        return pairs;
    }
}