import java.util.*

val deque = ArrayDeque<Int>()
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n  = readLine().toInt()
    for (i in 1..n){
        when(val str = readLine()){
            "pop"-> if(deque.isEmpty()) println("-1") else println(deque.pop())
            "size"->println(deque.size)
            "empty"->if(deque.isEmpty()) println("1") else println("0")
            "front"->if(deque.isEmpty()) println("-1") else println(deque.first)
            "back"->if(deque.isEmpty())  println("-1") else println(deque.last)
            else->deque.addLast(str.split(" ")[1].toInt())
        }
    }
}