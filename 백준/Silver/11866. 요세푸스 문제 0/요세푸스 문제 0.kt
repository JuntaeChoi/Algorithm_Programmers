import java.util.*

val deque = ArrayDeque<Int>()
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {

    val line = readLine().split(" ")
    val n = line[0].toInt()
    val k = line[1].toInt()
    var answer = "<"
    val deque = ArrayDeque<Int>()
    for(i in 1..n){
        deque.add(i)
    }
    while(deque.isNotEmpty()){
        for(i in 1 until k){
            deque.add(deque.poll())
        }
        if(deque.size==1)
            answer+="${deque.poll()}>"
        else
            answer+="${deque.poll()}, "
    }
    println(answer)
}