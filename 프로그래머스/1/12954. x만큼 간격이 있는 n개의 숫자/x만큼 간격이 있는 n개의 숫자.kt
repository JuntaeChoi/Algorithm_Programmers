class Solution {
    fun solution(x: Int, n: Int): LongArray {
        var answer :LongArray = LongArray(n){ index -> (index+1)*x.toLong()}
        return answer
    }
}