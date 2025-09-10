class Solution {
    public int numRabbits(int[] answers) {
        // 숲에는 수를 알 수 없는 토끼들이 살고 있습니다.
        // 우리는 토끼들에게 본인과 같은 색을 가진 토끼가 몇 마리인지 물어보고
        // 그 대답들을 anwers라는 정수형 배열에 저장합니다
        // answers[i]는 i번째 토끼에 대한 답입니다.
        // 숲에 있는 토끼의 최소한의 수를 반환하세요.

        Map<Integer, Integer> sameColorRabbit = new HashMap<Integer, Integer>();
        for(int answer : answers) {
            sameColorRabbit.put(answer, sameColorRabbit.getOrDefault(answer, 0) + 1);
        }

        int total = 0;
        for(Map.Entry<Integer, Integer> rabbit : sameColorRabbit.entrySet()) {
            total += Math.ceil((double)rabbit.getValue() / (rabbit.getKey() + 1)) * (rabbit.getKey() + 1);
        }

        return total;
    }
}