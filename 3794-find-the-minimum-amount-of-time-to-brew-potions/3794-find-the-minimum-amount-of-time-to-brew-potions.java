class Solution {
    public long minTime(int[] skill, int[] mana) {
        long[] t = new long[skill.length + 1];
        
        for(int j = 0; j < mana.length; j++) {
            for(int i = 0; i < skill.length; i++) {
                t[i + 1] = Math.max(t[i + 1], t[i]) + (long)mana[j] * skill[i];
            }
            for(int i = skill.length - 1; i > 0; --i) {
                t[i] = t[i + 1] - (long) mana[j] * skill[i];
            }
        }

        return t[skill.length];
    }
}