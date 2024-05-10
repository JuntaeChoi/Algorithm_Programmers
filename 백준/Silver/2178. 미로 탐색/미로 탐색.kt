import java.util.*

lateinit var array  : Array<IntArray>
val xmove = intArrayOf(1,-1,0,0)
val ymove = intArrayOf(0,0,-1,1)

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val line = readLine().split(" ")
    val n=line[0].toInt()
    val m=line[1].toInt()
    array = Array(n){IntArray(m)}
    for(i in 0 until n){
        val nums = readLine().map { it.toString().toInt() }.toIntArray()
        for(j in 0 until m){
            array[i][j] = nums[j]
        }
    }
    BFS(n,m)
    println(array[n-1][m-1])
}
fun BFS(n:Int,m:Int){
    val queue = LinkedList<IntArray>()
    queue.add(intArrayOf(0,0))
    while(queue.isNotEmpty()){
        val nums = queue.poll()
        val y = nums[0]
        val x = nums[1]
        for(i in 0 until 4){
            if((x+xmove[i] in 0 until m)&&y+ymove[i] in 0 until n){
                if(array[y+ymove[i]][x+xmove[i]]==1){
                    queue.add(intArrayOf(y+ymove[i],x+xmove[i]))
                    array[y+ymove[i]][x+xmove[i]]+=array[y][x]
                }
            }
        }
    }
}