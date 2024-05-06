import java.util.*

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val deque = ArrayDeque<Int>(n)
    for(i in 1..n){
        deque.addFirst(i)
    }
    while(true){
        if(deque.size==1){
            println(deque.first)
            break
        }
        deque.removeLast()
        deque.addFirst(deque.pollLast())
    }
}