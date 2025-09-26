class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // list.get(r).get(i)에서는 list.get(r+1).get(i) 혹은 list.get(r+1).get(i+1)로만 이동 가능
        for(int i = triangle.size() - 2; i >= 0; i--) {
            for(int j = 0; j < triangle.get(i).size(); j++) {
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(
                    triangle.get(i + 1).get(j),
                    triangle.get(i + 1).get(j + 1)
                ));
            }
        }

        return triangle.get(0).get(0);
    }
}