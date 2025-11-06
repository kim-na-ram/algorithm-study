class Solution {
    private Map<Integer, TreeSet<Integer>> hm = new HashMap<>();

    private void dfs(int x, List<Integer>[] adjacent, boolean[] visited, int id, int[] ids) {
        visited[x] = true;
        ids[x] = id;

        hm.computeIfAbsent(id, k -> new TreeSet<>()).add(x);
        for(int neighbor : adjacent[x]) {
            if(!visited[neighbor]) {
                dfs(neighbor, adjacent, visited, id, ids);
            }
        }
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        List<Integer>[] adjacent = new ArrayList[c + 1];
        for(int i = 1; i <= c; i++) adjacent[i] = new ArrayList<>();

        for(int[] connection : connections) {
            int u = connection[0], v = connection[1];
            adjacent[u].add(v);
            adjacent[v].add(u);
        }

        boolean[] visited = new boolean[c + 1];
        int[] ids = new int[c + 1];
        for(int i = 1; i <= c; i++) {
            if (!visited[i]) dfs(i, adjacent, visited, i, ids);
        }

        List<Integer> out = new ArrayList<>();
        for(int[] query : queries) {
            int type = query[0];
            int node = query[1];
            int compId = ids[node];
            TreeSet<Integer> set = hm.getOrDefault(compId, new TreeSet<>());

            if(type == 1) {
                if(set.contains(node)) {
                    out.add(node);
                } else if(!set.isEmpty()) {
                    out.add(set.first());
                } else {
                    out.add(-1);
                }
            } else if(type == 2) {
                set.remove(node);
            }
        }

        int[] results = out.stream()
                        .mapToInt(Integer::intValue)
                        .toArray();

        return results;
    }
}