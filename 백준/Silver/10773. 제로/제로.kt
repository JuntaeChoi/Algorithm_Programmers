import java.util.*

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val k = readLine().toInt()
    val stack = Stack<Int>()
    for(i in 1..k){
        val num = readLine().toInt()
        if(num==0)
            stack.pop()
        else
            stack.push(num)
    }
    println(stack.sum())
}