class Solution {
    public int solution(int[] wallet, int[] bill) {
        int ans = 0;
        
        int ww = Math.max(wallet[0], wallet[1]);
        int wh = Math.min(wallet[0], wallet[1]);
        
        int bw = Math.max(bill[0], bill[1]);
        int bh = Math.min(bill[0], bill[1]);
        
        while(bw > ww || bh > wh) {
            // 반으로 접음
            int half = bw / 2;
            ans++;
            
            // 반으로 접으면 넣을 수 있는지 확인
            if(half <= ww && bh <= wh) {
                break;
            }
            // 90도 돌리면 넣을 수 있는지 확인
            else if(half <= wh && bh <= ww) {
                break;
            }
            
            bw = Math.max(bh, half);
            bh = Math.min(bh, half);
        }
        
        return ans;
    }
}