import java.util.*


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (n,k) = readLine().split(" ").map { it.toInt() }
    println(findMin(n,k))
}

fun findMin(n:Int,k:Int):Int {
    val map = mutableMapOf<Int,Int>()
    val queue = LinkedList<Int>()
    queue.add(n)
    map[n]=0
    while(queue.isNotEmpty()){
        val now = queue.poll()
        if (now==k)
            return map[now]!!
        if(now-1 in 0 .. 100000 &&(map[now-1]==null || map[now-1]!!>map[now]!!+1)){
            map[now-1]= map[now]!! +1
            queue.add(now-1)
        }
        if(now+1 in 0 .. 100000 &&(map[now+1]==null ||map[now+1]!!>map[now]!!+1)){
            map[now+1]= map[now]!! +1
            queue.add(now+1)
        }
        if(now*2 in 0 .. 100000 &&(map[now*2]==null ||map[now*2]!!>map[now]!!)){
            map[now*2]=map[now]!!
            queue.add(now*2)
        }
    }
    return -1
}
