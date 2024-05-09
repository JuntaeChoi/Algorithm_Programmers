import java.util.*

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val nums = readLine().split(" ").map { it.toInt() }.toIntArray()
    val dp = IntArray(n + 1) { 0 }
    var answer = nums[0]
    dp[0]=nums[0]
    for (i in 1 until n) {
        dp[i] = Integer.max(dp[i-1]+nums[i],nums[i])
        answer = Integer.max(dp[i],answer)
    }
    println(answer)
}