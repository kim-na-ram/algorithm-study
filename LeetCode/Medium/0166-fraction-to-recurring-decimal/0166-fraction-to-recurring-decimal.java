class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0";

        StringBuilder sb = new StringBuilder();
        if((numerator < 0) ^ (denominator < 0)) sb.append("-");

        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);

        sb.append(num / den);
        long remainder = num % den;
        if(remainder == 0) return sb.toString();

        sb.append(".");
        Map<Long, Integer> hm = new HashMap<>();
        while(remainder != 0) {
            if(hm.containsKey(remainder)) {
                int idx = hm.get(remainder);
                sb.insert(idx, "(");
                sb.append(")");
                return sb.toString();
            }

            hm.put(remainder, sb.length());
            remainder *= 10;
            sb.append(remainder / den);
            remainder %= den;
        }

        return sb.toString();
    }
}