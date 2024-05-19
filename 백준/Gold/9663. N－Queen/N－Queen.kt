import kotlin.math.abs

var count = 0
lateinit var arr : IntArray
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val num = readLine().toInt()
    arr = IntArray(num){-1}
    DFS(num,0)
    println(count)
}
fun DFS(n:Int,depth:Int){
    if(depth == n)
        count++
    else{
        for(i in 0 until n){
            arr[depth]=i
            if(isPossible(depth)){
                DFS(n,depth+1)
            }
        }
    }
}
fun isPossible(depth:Int):Boolean{
    for(i in 0 until depth){
        if(arr[i]==arr[depth]||abs(arr[i]-arr[depth])== abs(i-depth))
            return false
    }
    return true
}