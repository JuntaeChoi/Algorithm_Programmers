class Solution {
    fun solution(targets: Array<IntArray>): Int {
        var answer = 0
        var end = -1
        for(target in targets.sortedWith(compareBy({it[1]},{it.first()}))){
            val start = target.first()
            val last = target.last()
            if(start<end)
                continue
           else{
                end = last
                answer+=1
                println("start : ${start}, end : ${end}")
            }
        }
        return answer
    }
}