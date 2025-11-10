class Solution {
    public int minOperations(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() > num)
                stack.pop();
            if (num == 0)
                continue;
            if (stack.isEmpty() || stack.peek() < num) {
                result++;
                stack.push(num);
            }
        }
        return result;
    }
}