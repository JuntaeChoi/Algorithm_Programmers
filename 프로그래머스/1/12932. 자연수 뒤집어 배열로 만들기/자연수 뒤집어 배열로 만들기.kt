class Solution {
    fun solution(n: Long): IntArray {
        var answer = n.toString().reversed().map { e -> e.toString().toInt() }.toIntArray()
        return answer
    }
}