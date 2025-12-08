class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int i = 0; i < numbers.length; i++) {
            int search = target - numbers[i];
            int targetIndex = binarySearch(search, i, numbers);

            if(numbers[targetIndex] == search) return new int[]{i+1, targetIndex+1};
        }

        return new int[]{0, 0};
    }

    private int binarySearch(int target, int pos, int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {
            int mid = (start + end) / 2;

            if(target == arr[mid] && mid != pos) return mid;
            else if(target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return 0;
    }
}