lateinit var arr : Array<CharArray>
val dx = intArrayOf(1,-1,0,0)
val dy = intArrayOf(0,0,1,-1)
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
   val (n,m) = readLine().split(" ").map { it.toInt() }
    arr = Array(n){readLine().toCharArray()}
    val chars= mutableListOf<Char>()
    chars.add(arr[0][0])
    println(DFS(0,0,n,m,chars))
}

fun DFS(x:Int,y:Int,n:Int,m:Int,chars: MutableList<Char> ):Int{
    var max =chars.size
    for(i in 0 until 4){
        val nx = x+dx[i]
        val ny = y+dy[i]
        if(nx in 0 until m && ny in 0 until n &&arr[ny][nx] !in chars ) {
            chars.add(arr[ny][nx])
            max = maxOf(DFS(nx,ny,n,m,chars),max)
            chars.remove(arr[ny][nx])
        }
    }
    return max
}