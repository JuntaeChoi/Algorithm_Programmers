class Solution {
    fun solution(n: Int): Int {
         for(i in 2..n){
            if((n-1)%i==0)
                return i
        }
            return n-1
    }
}