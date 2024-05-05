class Solution {
    fun solution(answers: IntArray): IntArray {
        val first = intArrayOf(1,2,3,4,5)
        val second = intArrayOf(2,1,2,3,2,4,2,5)
        val third = intArrayOf(3,3,1,1,2,2,4,4,5,5)
        val sum = intArrayOf(0,0,0)

        answers.forEachIndexed { index, i ->
            if(first[index%5]==i)
                sum[0]++
            if(second[index%8]==i)
                sum[1]++
            if(third[index%10]==i)
                sum[2]++
        }
        val answer = mutableListOf<Int>()
        sum.forEachIndexed { index, i ->
            if(i==sum.maxOrNull())
                answer.add(index+1)
        }
        return answer.toIntArray()
    }
}