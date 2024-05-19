import java.lang.StringBuilder
import kotlin.math.abs
import kotlin.math.pow

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val num = readLine().toInt()
    val sb = StringBuilder()
    sb.append("${((2.0).pow(num)-1).toInt()}\n")
    hanoi(num,1,2,3,sb)
    print(sb)
}
fun hanoi(num:Int,start:Int,mid:Int,end:Int,sb:StringBuilder){
    if(num==1){
        sb.append("$start $end\n")
        return
    }
    hanoi(num-1,start,end,mid,sb)
    sb.append("$start $end\n")
    hanoi(num-1,mid,start,end,sb)
}