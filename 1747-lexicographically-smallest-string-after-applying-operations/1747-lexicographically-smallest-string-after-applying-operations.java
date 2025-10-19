class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> lexString = new HashSet<>();
        String smallest = s;

        Queue<String> q = new LinkedList<>();
        q.offer(s);
        lexString.add(s);

        while(!q.isEmpty()) {
            String pos = q.poll();
            if(pos.compareTo(smallest) < 0) smallest = pos;

            String added = addToA(pos, a);
            if(lexString.add(added)) q.offer(added);

            String rotated = rotateFromB(pos, b);
            if(lexString.add(rotated)) q.offer(rotated);
        }

        return smallest;
    }

    public String addToA(String s, int a) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(i % 2 != 0) {
                int add = Integer.parseInt(s.substring(i, i+1)) + a;
                if(add > 9) add = (add - 1) % 9;
                
                sb.append(add);
            } else {
                sb.append(s.charAt(i));
            }
        }
        
        return sb.toString();
    }

    public String rotateFromB(String s, int b) {
        StringBuilder sb = new StringBuilder();

        sb.append(s.substring(b, s.length()));
        sb.append(s.substring(0, b));

        return sb.toString();
    }
}