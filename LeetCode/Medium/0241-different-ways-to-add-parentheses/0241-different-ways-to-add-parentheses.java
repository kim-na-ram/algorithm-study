class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        return recursion(expression, 0, expression.length() - 1);
    }

    public List<Integer> recursion(String expression, int start, int end) {
        List<Integer> res = new ArrayList<>();

        if (start == end) {
            int num = expression.charAt(start) - '0';
            res.add(num);
            return res;
        } else if (end - start == 1 && Character.isDigit(expression.charAt(start))) {
            int num = Integer.parseInt(expression.substring(start, end + 1));
            res.add(num);
            return res;
        }

        for (int i = start; i <= end; i++) {
            if (Character.isDigit(expression.charAt(i))) {
                continue;
            }
            
            char op = expression.charAt(i);
            List<Integer> left = recursion(expression, start, i - 1);
            List<Integer> right = recursion(expression, i + 1, end);
            
            for (int l : left) {
                for (int r : right) {
                    if (op == '*') {
                        res.add(l * r);
                    } else if (op == '+') {
                        res.add(l + r);
                    } else if (op == '-') {
                        res.add(l - r);
                    }
                }
            }
        }
        return res;
    }
}