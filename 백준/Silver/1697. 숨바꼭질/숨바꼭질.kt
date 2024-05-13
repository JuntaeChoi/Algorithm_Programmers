import java.util.*

var count = 0
val visited = BooleanArray(100001) { false }
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val line = readLine().split(" ")
    val n = line[0].toInt()
    val k = line[1].toInt()

    BFS(n, k)
    println(count)
}

fun BFS(n: Int, k: Int) {
    val queue = LinkedList<Pair<Int, Int>>()
    queue.add(Pair(n, 0))
    while (true) {
        val num = queue.poll()
        if(num.first < 0 || num.first > 100000||visited[num.first])
        else if (num.first == k) {
            count = num.second
            break
        } else{
                visited[num.first] = true
                queue.add(Pair(num.first * 2, num.second + 1))
                queue.add(Pair(num.first + 1, num.second + 1))
                queue.add(Pair(num.first - 1, num.second + 1))
        }
    }
}