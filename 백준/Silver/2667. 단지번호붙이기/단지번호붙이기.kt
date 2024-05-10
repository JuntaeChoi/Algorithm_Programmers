import java.util.*

lateinit var array : Array<IntArray>
var homeCount=0
var houses = mutableListOf<Int>()
val movex = intArrayOf(0,0,1,-1)
val movey = intArrayOf(1,-1,0,0)

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n=readLine().toInt()
    array = Array(n){IntArray(n)}
    for (i in 0 until n){
        val nums = readLine().map { it.toString().toInt() }.toIntArray()
        for (j in 0 until n){
            array[j][i]=nums[j]
        }
    }
    for(i in 0 until n){
        for(j in 0 until n){
            if(array[j][i]==1)
                BFS(j,i,n)
        }
    }
    println(homeCount)
    val answer = houses.sorted()
    for(i in answer)
        println(i)
}
fun BFS(x:Int,y:Int,n:Int){
    val queue = LinkedList<IntArray>()
    var count=0
    queue.add(intArrayOf(x,y))
    array[x][y]=0
    while(queue.isNotEmpty()){
        count++
        val nums = queue.poll()
        val x = nums[0]
        val y = nums[1]
        for(i in 0 until 4){
            if(x+movex[i] in 0 until n && y+movey[i] in 0 until n ){
                if(array[x+movex[i]][y+movey[i]]==1){
                    queue.add(intArrayOf(x+movex[i],y+movey[i]))
                    array[x+movex[i]][y+movey[i]]=0
                }
            }
        }
    }
    homeCount++
    houses.add(count)
}