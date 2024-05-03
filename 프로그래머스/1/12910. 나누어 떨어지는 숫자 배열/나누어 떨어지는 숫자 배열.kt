class Solution {
    fun solution(arr: IntArray, divisor: Int): IntArray {
        val answer = arr.sorted().filter{ it%divisor==0 }.toIntArray()
        if(answer.isEmpty())
            return intArrayOf(-1)
        else
            return answer
    }
}