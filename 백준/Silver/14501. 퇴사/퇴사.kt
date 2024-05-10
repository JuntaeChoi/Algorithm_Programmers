import java.util.*

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val dp = Array(17){0}
    var last =0
    for(i in 1..n){
        val nums = readLine().split(" ")
        val t=nums[0].toInt()
        val p=nums[1].toInt()
        last = Integer.max(dp[i],last)
        dp[i] = Integer.max(dp[i],last)
        if(i+t<=n+1)
            dp[i+t]=Integer.max(dp[i+t],dp[i]+p)
    }
    println(dp.max())
}