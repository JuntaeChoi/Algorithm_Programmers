import java.util.*
lateinit var visited : BooleanArray
lateinit var arr : IntArray
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val nums = readLine().split(" ")
    val n = nums[0].toInt()
    val m = nums[1].toInt()
    visited = BooleanArray(n){false}
    arr = IntArray(m)
    DFS(n,m,0)
}

fun DFS(n:Int,m:Int,depth:Int){
    if(depth==m){
        arr.forEach {
            print("$it ")
        }
        println()
    }
    else if (depth==0){
        for(i in 0 until n){
            if(!visited[i]){
                arr[depth]=i+1
                visited[i]=true
                DFS(n,m,depth+1)
                visited[i]=false
            }
        }
    }
    else if (depth<m){
        for(i in arr[depth-1] until n){
            if(!visited[i]){
                arr[depth]=i+1
                visited[i]=true
                DFS(n,m,depth+1)
                visited[i]=false
            }
        }
    }
}
