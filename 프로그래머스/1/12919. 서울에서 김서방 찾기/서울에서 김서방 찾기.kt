class Solution {
    fun solution(seoul: Array<String>): String {
        var count = 0
        for (i in seoul){
            if (i.equals("Kim"))
                return "김서방은 ${count}에 있다"
            count++
        }
        return ""
    }
}