lateinit var arr: Array<IntArray>

data class Tetromino(val x: Int, val y: Int, val count: Int, var sum: Int, val visited: MutableSet<Pair<Int, Int>>)

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    arr = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }
    val visited = mutableSetOf<Pair<Int, Int>>()
    var max = 0
    for (i in 0 until n) {
        for (j in 0 until m) {
            max = Integer.max(max, findMax(n, m, Tetromino(j, i, 1, arr[i][j], visited)))
        }
    }
    println(max)
}

fun findMax(n: Int, m: Int, tet: Tetromino): Int {
    val (x,y,_,sum,_)=tet
    var max = 0
    max = maxOf(max, dfs(n,m, tet))
    // 'ㅗ' 모양 체크
    if (x > 0 && x < m - 1 && y > 0) max = maxOf(max, sum + arr[y][x-1] + arr[y][x+1] + arr[y-1][x])
    if (x > 0 && x < m - 1 && y < n - 1) max = maxOf(max, sum + arr[y][x-1] + arr[y][x+1] + arr[y+1][x] )
    if (y > 0 && y < n - 1 && x > 0) max = maxOf(max, sum + arr[y-1][x] + arr[y+1][x] + arr[y][x-1])
    if (y > 0 && y < n - 1 && x < m - 1) max = maxOf(max, sum + arr[y-1][x] + arr[y+1][x] + arr[y][x+1])

    return max
}
fun dfs(n: Int, m: Int, tet: Tetromino): Int {
    val (x,y,count,sum,visited)=tet
    if(count==4){
        return sum
    }

    val dx = listOf(1, -1, 0, 0)
    val dy = listOf(0, 0, 1, -1)
    visited.add(Pair(x, y))
    var max = 0
    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx in 0 until m && ny in 0 until n && !visited.contains(Pair(nx, ny))){
            max = maxOf(max, dfs(n, m, Tetromino(nx, ny, count + 1, sum + arr[ny][nx], visited)))
        }
    }
    visited.remove(Pair(x,y))
    return max
}