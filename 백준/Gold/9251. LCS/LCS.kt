import java.lang.StringBuilder

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val firstWord = readLine().map { it }
    val secondWord = readLine().map { it }
    val dp = Array(firstWord.size){IntArray(secondWord.size){0} }

    for(i in firstWord.indices){
        for(j in secondWord.indices){
            if(firstWord[i]==secondWord[j]){
                if(i==0 || j ==0)
                    dp[i][j]=1
                else{
                    dp[i][j]=dp[i-1][j-1]+1
                }
            }else{
                if(i==0 &&j==0)
                    continue
                else if(i==0)
                    dp[i][j]=dp[i][j-1]
                else if(j==0)
                    dp[i][j]=dp[i-1][j]
                else{
                    dp[i][j]=maxOf(dp[i-1][j],dp[i][j-1])
                }
            }
        }
    }
    println(dp[firstWord.lastIndex][secondWord.lastIndex])
}