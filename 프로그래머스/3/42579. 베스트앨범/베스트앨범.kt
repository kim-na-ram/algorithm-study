class Solution {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        return plays.withIndex()
            .groupBy { genres[it.index] }
            .values.sortedByDescending { v -> v.sumOf { it.value } }
            .asSequence()
            .map { v ->
                v.sortedByDescending { it.value }.map { it.index }.take(2)
            }.fold(intArrayOf()) { acc, list -> acc + list }
    }
}