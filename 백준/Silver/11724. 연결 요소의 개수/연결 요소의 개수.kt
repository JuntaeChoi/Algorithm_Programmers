import java.util.*

lateinit var visited : BooleanArray
lateinit var array : Array<BooleanArray>
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val line= readLine().split(" ")
    val n = line[0].toInt()
    val k = line[1].toInt()
    visited = BooleanArray(n+1){false}
    array = Array(n+1){BooleanArray(n+1){false} }
    for(i in 0 until k){
        val nums = readLine().split(" ")
        val first = nums[0].toInt()
        val second = nums[1].toInt()
        array[first][second]=true
        array[second][first]=true
    }
    var count=0
    for(i in 1 .. n){
        if(!visited[i]){
            count++
            DFS(i)
        }
    }
    println(count)
}
fun DFS(n:Int){
    visited[n]=true
    for(i in 1 until array.size){
        if(array[n][i]&&!visited[i]){
            DFS(i)
        }
    }
}