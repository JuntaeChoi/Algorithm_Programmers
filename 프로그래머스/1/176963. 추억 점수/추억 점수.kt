class Solution {
    fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {
        val yearningMap = mutableMapOf<String, Int>()
        name.forEachIndexed{ index, it ->
            yearningMap[it] = yearning[index]
        }
        
        val answer = IntArray(photo.size)
        photo.forEachIndexed{ index, it->
            var yearningSum = 0
            it.forEach{
                yearningSum += yearningMap[it] ?: 0
            }
            answer[index]=yearningSum
        }
        return answer
    }
}