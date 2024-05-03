class Solution {
    fun solution(num: Int): Int {
        var temp : Long = num.toLong()
        var answer = 0
        for(i in 0 .. 499){
            if(temp==1.toLong())
                return answer.toInt()
            if(temp%2==0.toLong())
                temp/=2
            else
                temp=temp*3+1
            answer++
        }
        return -1
    }
}