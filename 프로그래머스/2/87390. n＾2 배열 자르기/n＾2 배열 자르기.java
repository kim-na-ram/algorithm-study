class Solution {
    public int[] solution(int n, long left, long right) {
        int index = 0;
        int size = (int)(right - left) + 1;
        int[] arr = new int[size];
        int row = (int)(left / n);
        int col = (int)(left % n);

        while(index < size) {
            arr[index++] = row > col ? (row + 1) : (col + 1);

            if(col < n - 1) {
                col++;
            } else {
                row++;
                col = 0;
            }
        }

        return arr;
    }
}