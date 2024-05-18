import java.util.*

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val t=readLine().toInt()
    repeat(t){
        val n = readLine().toInt()
        val start = readLine().split(" ").map { it.toInt() }.toIntArray()
        val end = readLine().split(" ").map { it.toInt() }.toIntArray()
        println(BFS(n,start[0],start[1],end[0],end[1]))
    }

}
fun BFS(n:Int,fx:Int,fy:Int,ex:Int,ey:Int):Int{
    val dx = intArrayOf(-2,-2,-1,-1,1,1,2,2)
    val dy = intArrayOf(1,-1,2,-2,2,-2,1,-1)
    val queue = LinkedList<Triple<Int,Int,Int>>()
    val visited = HashSet<Pair<Int,Int>>()
    queue.add(Triple(fx,fy,0))
    visited.add(Pair(fx,fy))
    while(queue.isNotEmpty()){
        val (cx,cy,count) = queue.poll()
        if(cx==ex&&cy==ey)
            return count
        for(i in 0 until 8){
            val nx = cx+dx[i]
            val ny = cy+dy[i]
            if(nx in 0 until n && ny in 0 until n && Pair(nx,ny) !in visited){
                queue.add(Triple(nx,ny,count+1))
                visited.add(Pair(nx,ny))
            }
        }
    }
    return 0
}
