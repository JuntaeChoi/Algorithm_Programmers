class Solution {
    fun solution(n: Long): Long {
        var temp :Long = 1
        while(temp*temp<=n){
            if(temp*temp==n)
                return (temp+1)*(temp+1)
            else
                temp++
        }
        return -1
    }
}