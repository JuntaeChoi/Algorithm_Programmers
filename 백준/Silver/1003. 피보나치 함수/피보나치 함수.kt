import java.util.*

lateinit var zeroDP : LongArray
lateinit var oneDP : LongArray
fun main(args: Array<String>)= with(System.`in`.bufferedReader()){
    zeroDP = LongArray(41){0}
    oneDP = LongArray(41){0}
    initDP()
    val t = readLine().toInt()
    repeat(t){
        val n = readLine().toInt()
        println("${zeroDP[n]} ${oneDP[n]}")
    }
}
fun initDP(){
    zeroDP[0]=1
    zeroDP[1]=0
    oneDP[0]=0
    oneDP[1]=1
    for(i in 2..40){
        zeroDP[i]=zeroDP[i-1]+zeroDP[i-2]
        oneDP[i]=oneDP[i-1]+oneDP[i-2]
    }
}