import java.util.*

lateinit var array: Array<IntArray>
var count = 0
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    while (true) {
        val init = readLine().split(" ")
        val w = init[0].toInt()
        val h = init[1].toInt()
        if (w == 0 && h == 0)
            break
        array = Array(h) { IntArray(w) }
        for (i in 0 until h) {
            val nums = readLine().split(" ").map { it.toInt() }.toIntArray()
            for (j in 0 until w) {
                array[i][j] = nums[j]
            }
        }
        for (i in 0 until h) {
            for (j in 0 until w) {
                if (DFS(j, i,w,h)) {
                    count++
                }
            }
        }
        println(count)
        count = 0
    }
}

fun DFS(x: Int, y: Int,w:Int,h:Int): Boolean {
    val dx = intArrayOf(1, 1, 1, -1, -1, -1, 0, 0)
    val dy = intArrayOf(1, -1, 0, 1, -1, 0, 1, -1)

    if (array[y][x] == 0) {
        return false
    }
    array[y][x] = 0
    for (i in 0 until 8) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx in 0 until w &&ny in 0 until h && array[ny][nx] == 1) {
            DFS(nx, ny,w,h)
        }
    }
    return true
}