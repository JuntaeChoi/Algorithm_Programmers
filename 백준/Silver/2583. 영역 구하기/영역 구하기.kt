import java.util.*
lateinit var visited : Array<BooleanArray>
val dx = intArrayOf(1,-1,0,0)
val dy = intArrayOf(0,0,1,-1)
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (n,m,k) = readLine().split(" ").map { it.toInt() }
    visited = Array(n){BooleanArray(m){false} }
    repeat(k){
        val (x1,y1,x2,y2) = readLine().split(" ").map { it.toInt() }
        for(i in n-y2 until n-y1) {
            for(j in x1 until x2){
                visited[i][j]=true
            }
        }
    }
    val answer = mutableListOf<Int>()
    for(i in 0 until n){
        for(j in 0 until m){
            if(!visited[i][j]){
                answer.add(BFS(j,i,n,m))
            }
        }
    }
    println(answer.size)
    println(answer.sorted().joinToString(" "))
}

fun BFS(x: Int, y: Int, n: Int, m: Int):Int{
    val queue = LinkedList<Pair<Int,Int>>()
    queue.push(Pair(x,y))
    visited[y][x]=true
    var width = 0

    while(queue.isNotEmpty()){
        val (nx,ny) = queue.poll()
        width++

        for(i in 0 until 4){
            if(nx+dx[i] in 0 until m && ny+dy[i] in 0 until n&& !visited[ny+dy[i]][nx+dx[i]]){
                queue.add(Pair(nx+dx[i],ny+dy[i]))
                visited[ny+dy[i]][nx+dx[i]]=true
            }
        }
    }
    return width
}