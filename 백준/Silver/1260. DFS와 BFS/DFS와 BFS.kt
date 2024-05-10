import java.util.*

lateinit var array: Array<BooleanArray>
lateinit var visited:BooleanArray
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val line = readLine().split(" ")
    val n = line[0].toInt()
    val m = line[1].toInt()
    val v = line[2].toInt()
    array = Array(n+1){BooleanArray(n+2){false} }
    visited = BooleanArray(n+2){false}

    for(i in 0 until m){
        val nums = readLine().split(" ")
        val first = nums[0].toInt()
        val second = nums[1].toInt()
        array[first][second]=true
        array[second][first]=true
    }
    DFS(v,n)
    println()
    visited = BooleanArray(n+1){false}
    BFS(v,n)
}
fun DFS(v:Int,n:Int){
    visited[v]=true
    print("$v ")
    for(i in 1 .. n){
        if(array[v][i]&&!visited[i]){
            DFS(i,n)
        }
    }
}
fun BFS(v:Int,n:Int){
    visited[v]=true
    print("$v ")
    val queue = LinkedList<Int>()
    queue.add(v)
    while(queue.isNotEmpty()){
        val now =queue.poll()
        for(i in 1 .. n){
            if(array[now][i]&&!visited[i]){
                visited[i]=true
                print("$i ")
                queue.add(i)
            }
        }
    }
}