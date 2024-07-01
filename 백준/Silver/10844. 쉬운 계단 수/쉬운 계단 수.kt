lateinit var dp : Array<LongArray>
fun main(args: Array<String>)= with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    dp = Array(n+1){LongArray(10){if(it==0) 0 else 1}}
    for(i in 1 ..<n){
        for(j in 0 .. 9){
            when(j){
                0-> dp[i][j]=dp[i-1][1]
                9-> dp[i][j]=dp[i-1][8]
                else -> dp[i][j]=dp[i-1][j-1]+dp[i-1][j+1]
            }
            dp[i][j]= dp[i][j]%1000000000
        }
    }
    if(n==1)
        println("9")
    else
        println(dp[n-1].sum()%1000000000)
}