import java.util.*

val deque = ArrayDeque<Int>()
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {

    val n = readLine().toInt()
    val queue = PriorityQueue<Int>()
    for(i in 1..n){
        val num = readLine().toInt()
        if(num==0){
            if(queue.isEmpty())
                println(0)
            else
                println(queue.poll())
        }
        else{
            queue.add(num)
        }
    }
}