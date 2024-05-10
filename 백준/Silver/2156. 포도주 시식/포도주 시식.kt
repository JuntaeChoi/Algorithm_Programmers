import java.util.*

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val dp = IntArray(10001){0}
    val array = IntArray(10001){0}
    for(i in 0 until n){
        val num = readLine().toInt()
        array[i]=num
    }
    dp[0]=array[0]
    dp[1]=array[0]+array[1]
    dp[2]=Integer.max(Integer.max(array[0]+array[2],array[1]+array[2]),dp[1])
    for(i in 3 until n){
        dp[i] = Integer.max(dp[i-2],dp[i-3]+array[i-1])+array[i]
        dp[i] = Integer.max(dp[i],dp[i-1])
    }
    println(dp[n-1])
}