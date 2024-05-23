import java.util.*

lateinit var arr : Array<IntArray>
private data class Robot(val x:Int,val y:Int,val direction:Int)
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (n,m) = readLine().split(" ").map{it.toInt()}
    val (y,x,d) = readLine().split(" ").map{it.toInt()}
    arr = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }

    println(runRobot(n,m,Robot(x,y,d)))
}
private fun runRobot(n:Int,m:Int,robot:Robot):Int{
    //북,동,남,서
    val dx= intArrayOf(0,1,0,-1)
    val dy= intArrayOf(-1,0,1,0)
    val queue = LinkedList<Robot>()
    queue.add(robot)
    var count=0
    while(queue.isNotEmpty()){
        val (x,y,d) = queue.poll()
        if(arr[y][x]==0){
            arr[y][x]=2
            count++
        }
        var isClean = true
        for(i in 3 downTo 0){
            val nd = (d+i)%4
            val nx = x+dx[nd]
            val ny = y+dy[nd]
            if(nx in 0 until m && ny in 0 until n &&arr[ny][nx]==0){
                isClean=false
                queue.add(Robot(nx,ny,nd))
                break
            }
        }
        if(isClean){
            val bx = x+dx[(d+2)%4]
            val by = y+dy[(d+2)%4]
            if(bx in 0 until m&&by in 0 until n&&arr[by][bx]!=1)
                queue.add(Robot(bx,by,d))
            else if(arr[by][bx]==1)
                return count
        }
    }
    return count
}

