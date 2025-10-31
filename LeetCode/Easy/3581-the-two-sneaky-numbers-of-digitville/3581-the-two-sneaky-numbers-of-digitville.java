class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Map<Integer, Integer> visibility = new HashMap<>();
        for(int num : nums) {
            visibility.put(num, visibility.getOrDefault(num, 0) + 1);
        }

        int[] answer = new int[2];
        int index = 0;
        for(int key : visibility.keySet()) {
            if(visibility.get(key) == 2) {
                answer[index++] = key;
            }
        }

        return answer;
    }
}