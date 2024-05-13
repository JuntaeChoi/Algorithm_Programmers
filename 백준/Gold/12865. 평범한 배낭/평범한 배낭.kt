import java.util.*


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val line= readLine().split(" ")
    val n = line[0].toInt()
    val k = line[1].toInt()
    val array = IntArray(k+1){0}
    for (i in 0 until n){
        val num = readLine().split(" ")
        val w = num[0].toInt()
        val v = num[1].toInt()
        for(j in k downTo 1){
            if(w<=j)
                array[j]=Integer.max(array[j],array[j-w]+v)
        }
    }
    println(array[k])
}