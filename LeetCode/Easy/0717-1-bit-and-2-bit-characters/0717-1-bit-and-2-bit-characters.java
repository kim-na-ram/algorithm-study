class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        boolean isOneBit = true;
        for(int i = 0; i < bits.length;) {
            if(bits[i] == 1) {
                isOneBit = false;
                i += 2;
            } else {
                isOneBit = true;
                i++;
            }
        }

        return isOneBit;
    }
}