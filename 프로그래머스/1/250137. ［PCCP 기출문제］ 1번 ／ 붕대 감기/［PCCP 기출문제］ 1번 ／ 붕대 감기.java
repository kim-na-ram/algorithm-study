class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        // t초 동안
	    int t = bandage[0];
	    // 1초마다 x만큼 체력 회복
	    int x = bandage[1];
	    // t초 연속으로 붕대를 감으면 y만큼 추가 회복
	    int y = bandage[2];
        
        // 최대체력
	    int maxHealth = health;
        // 현재체력
	    int nowHealth = health;
        // 초기 공격 시간
        int firstAttackTime = attacks[0][0];
        // 마지막 공격 시간
	    int lastAttackTime = attacks[attacks.length - 1][0];
        
        int idx = 0;
        // 연속 붕대감기 체크
        int sequence = 0;
        for(int i = firstAttackTime; i <= lastAttackTime; i++) {
            if(i == attacks[idx][0]) {
                nowHealth -= attacks[idx][1];
                
                if(nowHealth <= 0) return -1;
                
                sequence = 1;
                idx++;
            } else {
                if(sequence == t) {
                    nowHealth = y + nowHealth > maxHealth ? maxHealth : y + nowHealth;
                    sequence = 0;
                }
                
                sequence++;
                nowHealth = x + nowHealth > maxHealth ? maxHealth : x + nowHealth;
            }
        }
        
        return nowHealth;
    }
}