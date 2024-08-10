class Solution {
    fun solution(targets: Array<IntArray>): Int {
        var answer = 0
        var start = 100000001
        val targets = targets.sortedByDescending { it[1] }.toTypedArray()

        for (target in targets){
            val (ns,ne) = target
            if(ne<=start){
                start = ns
                answer++
            }else{
                start = maxOf(start,ns)
            }
        }
        return answer
    }
}