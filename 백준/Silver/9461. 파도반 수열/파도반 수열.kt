import java.util.*

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val cache = LongArray(101){-1}
    cache[1]=1
    cache[2]=1
    cache[3]=1
    for(i in 4..100){
    cache[i]=cache[i-2]+cache[i-3]
    }
    val num = readLine().toInt()
    for(i in 1..num){
        val temp = readLine().toInt()
        println(cache[temp])
    }
}