class Solution {
    public int minDeletionSize(String[] strs) {
        // 입력 : n개의 strs, strs의 길이는 모두 같음
        // 출력 : strs가 정렬되어 있지 않으면 삭제하고, 삭제한 개수를 반환

        int answer = 0;
        final int len = strs[0].length();
        for(int j = 0; j < len; j++) {
            for(int i = 0; i < strs.length - 1; i++) {
                if(strs[i].charAt(j) > strs[i + 1].charAt(j)) {
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }
}