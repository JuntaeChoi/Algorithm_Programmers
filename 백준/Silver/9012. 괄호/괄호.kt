import java.util.*

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    for (i in 1..n){
        val stack = Stack<String>()
        val str = readLine().split("")
        var bool = true
        for(i in str){
            if(i == "("){
                stack.push(i)
            }
            else if(i == ")"){
                if(stack.isEmpty()){
                    bool = false
                }
                else if(stack.isNotEmpty())
                    stack.pop()
            }
        }
        if(stack.isNotEmpty()) bool = false
        if(bool) println("YES") else println("NO")
    }
}