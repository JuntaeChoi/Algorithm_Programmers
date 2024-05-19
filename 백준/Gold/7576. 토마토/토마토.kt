import java.util.*
lateinit var arr : Array<IntArray>
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val nums = readLine().split(" ")
    val m = nums[0].toInt()
    val n = nums[1].toInt()
    arr = Array(n){ IntArray(m) }
    val queue = LinkedList<Triple<Int,Int,Int>>()
    for(i in 0 until n){
        val line = readLine().split(" ").map { it.toInt() }.toIntArray()
        arr[i]=line
        for(j in 0 until m){
            if(arr[i][j]==1){
                queue.add(Triple(j,i,2))
            }
        }
    }
    println(BFS(queue,n,m))
}
fun BFS(queue:Queue<Triple<Int,Int,Int>>,n:Int,m:Int):Int{
    val dx = intArrayOf(1,-1,0,0)
    val dy = intArrayOf(0,0,1,-1)
    while(queue.isNotEmpty()){
        val (cx,cy,count) = queue.poll()
        for(i in 0 until 4){
            val nx = cx+dx[i]
            val ny = cy+dy[i]
            if(nx in 0 until m && ny in 0 until n && (arr[ny][nx]== 0 || (arr[ny][nx]>1 && arr[ny][nx]>count))){
                queue.add(Triple(nx,ny,count+1))
                arr[ny][nx]=count
            }
        }
    }
    return answer(n,m)
}

fun answer(n:Int,m:Int):Int{
    var max=0
    for(i in 0 until n){
        for(j in 0 until m){
            val now = arr[i][j]
            if(now==0)
                return -1
            else if(now==-1)
                continue
            else
                max = Integer.max(now,max)
        }
    }
    return max-1
}