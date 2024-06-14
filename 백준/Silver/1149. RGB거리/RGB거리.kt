import java.util.*
lateinit var arr : Array<IntArray>

fun main(args: Array<String>)= with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    arr = Array(n){readLine().split(" ").map { it.toInt() }.toIntArray()}
    var answer = Int.MAX_VALUE
    for(i in 1 until n){
        for(j in 0 until 3){
            when(j){
                0 -> arr[i][j]+= minOf(arr[i-1][1],arr[i-1][2])
                1 -> arr[i][j]+= minOf(arr[i-1][0],arr[i-1][2])
                2 -> arr[i][j]+= minOf(arr[i-1][0],arr[i-1][1])
            }
            if(i ==n-1){
                answer = minOf(answer,arr[i][j])
            }
        }
    }
    println(answer)
}