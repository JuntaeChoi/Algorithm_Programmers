import java.util.*

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    var result=0
    var n = readLine().toInt()
    val nums = readLine().split(" ").map { it.toInt() }.toIntArray().sorted()
    for(i in nums){
        result+=i*n--
    }
    println(result)
}