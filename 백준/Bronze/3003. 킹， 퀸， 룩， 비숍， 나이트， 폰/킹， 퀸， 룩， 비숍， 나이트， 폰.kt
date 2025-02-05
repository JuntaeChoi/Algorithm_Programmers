import java.lang.StringBuilder

val target = intArrayOf(1,1,2,2,2,8)
val sb = StringBuilder()
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    var input = readLine().split(" ").map { it.toInt() }.toMutableList()
    for(i in 0..<6){
        input[i]= target[i] - input[i]
    }
    for(i in input){
        sb.append("$i ")
    }
    println(sb)
}