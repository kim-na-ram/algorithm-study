class Solution {
    public int minimumTeachings(int totalLanguages, int[][] userLanguages, int[][] friendships) {
        // n은 1부터 n까지의 언어들
        // languages[i]는 i번째 유저가 아는 언어들의 집합
        // friendships[i] = [ui, vi]는 ui 유저와 vi 사이의 우정을 표현
        // "하나의 언어"를 골라서 몇몇 유저에게 가르칠 수 있고, 그를 통해 모든 친구쌍이 대화할 수 있게 하라
        // 내가 가르쳐야 하는 유저의 최소한의 숫자를 구해라

        Set<Integer> usersToTeach = new HashSet<>();
        
        for (int[] friendship : friendships) {
            int u1 = friendship[0] - 1;
            int u2 = friendship[1] - 1;
            boolean canCommunicate = false;
            
            for (int lang1 : userLanguages[u1]) {
                for (int lang2 : userLanguages[u2]) {
                    if (lang1 == lang2) {
                        canCommunicate = true;
                        break;
                    }
                }
                if (canCommunicate) break;
            }
            
            if (!canCommunicate) {
                usersToTeach.add(u1);
                usersToTeach.add(u2);
            }
        }

        int minUsersToTeach = userLanguages.length + 1;

        // 완전탐색, n이 500까지 밖에 없기 때문
        for(int lang = 1; lang <= totalLanguages; lang++) {
            int count = 0;

            for(int user : usersToTeach) {
                boolean knows = false;
                for(int l : userLanguages[user]) {
                    if (l == lang) {
                        knows = true;
                        break;
                    }
                }

                if(!knows) count++;
            }

            minUsersToTeach = Math.min(count, minUsersToTeach);
        }

        return minUsersToTeach;
    }
}