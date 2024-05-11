import java.util.*

lateinit var array : Array<IntArray>
var bugCount=0
val movex = intArrayOf(0,0,1,-1)
val movey = intArrayOf(1,-1,0,0)

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val t=readLine().toInt()

    for(i in 0 until t){
        bugCount=0
        val line = readLine().split(" ")
        val m = line[0].toInt()
        val n = line[1].toInt()
        val k = line[2].toInt()
        array = Array(n){IntArray(m){0} }
        for(i in 0 until k){
            val nums = readLine().split(" ")
            val x=nums[0].toInt()
            val y=nums[1].toInt()
            array[y][x]=1
        }
        for(i in 0 until n){
            for(j in 0 until m){
                if(array[i][j]==1)
                    BFS(j,i,m,n)
            }
        }
        println(bugCount)
    }
}

fun BFS(x:Int,y:Int,m:Int,n:Int){
    val queue = LinkedList<Pair<Int,Int>>()
    queue.add(Pair(x,y))
    while(queue.isNotEmpty()){
        val now = queue.poll()
        for(i in 0 until 4){
            if(now.first+movex[i] in 0 until m && now.second+movey[i] in 0 until n){
                if(array[now.second+movey[i]][now.first+movex[i]]==1){
                    queue.add(Pair(now.first+movex[i],now.second +movey[i]))
                    array[now.second+movey[i]][now.first+movex[i]]=0
                }
            }
        }
    }
    bugCount++
}