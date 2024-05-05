class Solution {    
    val list = charArrayOf('A','E','I','O','U')
    var answer=0
    var find=false
    
    fun solution(word: String): Int {
        DFS("",word)
        return answer
    }
    fun DFS(temp:String,word:String){
        for(i in list){
            if (find)
                break
            
            val next = temp+i
            answer++
            
            println(next)
            if(next==word)
                find=true
            else if (next.length!=5)
                DFS(next,word)
        }
    }
}