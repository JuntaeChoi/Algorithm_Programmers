import java.util.*

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val array = IntArray(301){-1}
    for(i in 0 until n){
        array[i]=readLine().toInt()
    }
    val dp = IntArray(301){-1}
    dp[0]= array[0]
    dp[1]=array[0]+array[1]
    dp[2]=Integer.max(array[0]+array[2],array[1]+array[2])
    for( i in 3 until n){
     dp[i]=array[i] +Integer.max(dp[i-2],array[i-1]+dp[i-3])
    }
    println(dp[n-1])
}