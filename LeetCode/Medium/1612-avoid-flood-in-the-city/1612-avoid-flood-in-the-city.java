// class Solution {
//     public int[] avoidFlood(int[] rains) {
//         int ansIdx = 0, zeroCnt = 0;
//         int[] ans = new int[rains.length];
//         Set<Integer> lakes = new HashSet<>();
//         Queue<Integer> zero = new LinkedList<>();
//         for(int i = 0; i < rains.length; i++) {
//             if(rains[i] > 0) {
//                 if(lakes.contains(rains[i]) && zero.size() > 0) {
//                     lakes.remove(rains[i]);
//                     ans[zero.poll()] = rains[i];
//                     ans[ansIdx++] = -1;
//                 } else if(lakes.contains(rains[i]) && zero.size() <= 0) {
//                     return new int[]{};
//                 } else {
//                     lakes.add(rains[i]);
//                     ans[ansIdx++] = -1;
//                 }
//             } else {
//                 zero.add(i);
//                 ansIdx++;
//             }
//         }

//         for(int i = 0; i < ans.length; i++) {
//             if(rains[i] == 0 && ans[i] == 0) ans[i] = 1;
//         }

//         return ans;
//     }
// }

class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Map<Integer, Integer> lastRainMap = new HashMap<>();
        TreeSet<Integer> dryDaySet = new TreeSet<>();
        
        for(int i = 0; i < n; i++) {
            if(rains[i] == 0) {
                dryDaySet.add(i);
                ans[i] = 1; // 1은 default value
            } else {
                ans[i] = -1;
                if(lastRainMap.containsKey(rains[i])) {
                    Integer day = dryDaySet.higher(lastRainMap.get(rains[i]));

                    if(day == null) return new int[0];
                    ans[day] = rains[i];
                    dryDaySet.remove(day);
                }
                lastRainMap.put(rains[i], i);
            }
        }

        return ans;
    }
}