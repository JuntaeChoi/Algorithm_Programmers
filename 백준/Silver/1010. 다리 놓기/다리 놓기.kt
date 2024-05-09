import java.util.*

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val repeat = readLine().toInt()
    val array = Array(31){LongArray(31){it.toLong()} }
    for (i in 1..repeat) {
        val nums = readLine().split(" ").map { it.toInt() }.toIntArray()
        val n = nums[0]
        val k = nums[1]
        for( i in 2..n){
            for(j in i..k){
                if(j==i)
                    array[i][j]=1
                else
                    array[i][j]=array[i][j-1]+array[i-1][j-1]
            }
        }
        println(array[n][k])
    }
}