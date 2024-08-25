val dx = intArrayOf(-1,1,0,0)
val dy = intArrayOf(0,0,1,-1)
lateinit var array : Array<IntArray>
lateinit var dp : Array<IntArray>
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (n,m) = readLine().split(" ").map { it.toInt() }
    array = Array(n){ readLine().split(" ").map { it.toInt() }.toIntArray() }
    dp = Array(n){ IntArray(m){-1} }
    println(DFS(n,m,0,0))
}

fun DFS(n:Int,m:Int,x:Int,y:Int) : Int{

    if(x==m-1&&y==n-1)
        return 1

    if(dp[y][x]!=-1){
        return dp[y][x]
    }
    dp[y][x]=0
    for(i in 0 until 4){
        val nx = x+dx[i]
        val ny = y+dy[i]
        if(ny in 0 until n &&nx in 0 until m && array[ny][nx]<array[y][x])
            dp[y][x]+=DFS(n,m,nx,ny)
    }

    return dp[y][x]
}