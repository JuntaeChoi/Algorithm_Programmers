class Solution {
    fun solution(a: Int, b: Int): Long {
        var answer : Long = 0
        var min =0
        var max =0
        if (a<b){
            min=a
            max=b
        }else{
            min=b
            max=a
        }
        
        for(i in min..max){
            answer+=i
        }
        return answer
    }
}