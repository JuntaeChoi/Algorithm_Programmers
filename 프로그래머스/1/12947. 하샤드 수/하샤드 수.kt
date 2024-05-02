class Solution {
    fun solution(x: Int): Boolean {
        val sum = x.toString().map { e -> e.toString().toInt() }.toIntArray().sum()
        return x%sum==0
    }
}