class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Map<Integer, Integer> visibility = new HashMap<>();
        List<Integer> twice = new ArrayList<>();
        for(int num : nums) {
            visibility.put(num, visibility.getOrDefault(num, 0) + 1);
        }

        for(int key : visibility.keySet()) {
            if(visibility.get(key) == 2) {
                twice.add(key);
            }
        }

        return twice.stream().mapToInt(Integer::intValue).toArray();
    }
}