import java.util.*

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val stack = Stack<Int>()
    for(i in 1..n){
        when(val str = readLine()){
            "pop"->{
                if(stack.isEmpty())
                    println("-1")
                else{
                    println(stack.pop())
                }
            }
            "size"-> println(stack.size)
            "empty"-> if(stack.isEmpty()) println(1) else println(0)
            "top"->{
                if(stack.isEmpty()) println("-1")
                else println(stack.peek())
            }
            else-> stack.push(str.split(" ")[1].toInt())
        }
    }
}