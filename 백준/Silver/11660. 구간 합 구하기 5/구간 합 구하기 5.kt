import java.lang.StringBuilder
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (n,m) = readLine().split(" ").map { it.toInt() }
    val array = Array(n){readLine().split(" ").map { it.toInt() }.toIntArray()}
    val xy = Array(m){readLine().split(" ").map { it.toInt()-1 }}
    val sb = StringBuilder()
    val dp = Array(n){IntArray(n)}

    for(i in 0 until n){
        for(j in 0 until n){
            if(i==0&&j==0)
                dp[0][0]=array[0][0]
            else if(i==0)
                dp[0][j]= dp[0][j-1]+ array[0][j]
            else if(j==0)
                dp[i][0]= dp[i-1][0]+ array[i][0]
            else
                dp[i][j]=array[i][j]+dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]
        }
    }
    repeat(m){
        val(y1,x1,y2,x2) = xy[it]
        var sum = dp[y2][x2]
        if(x1>0){
            sum-=dp[y2][x1-1]
        }
        if(y1>0){
            sum-=dp[y1-1][x2]
        }
        if(x1>0 && y1>0){
            sum+=dp[y1-1][x1-1]
        }
        sb.append(sum)
        sb.append("\n")
    }
    println(sb)
}