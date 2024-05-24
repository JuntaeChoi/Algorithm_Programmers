import java.util.*


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()){
        val (x,y) = readLine().split(" ").map { it.toInt() }
        println(minMove(x,y))
    }
}
fun minMove(x:Int,y:Int):Int{
    val distance = y-x
    val max = Math.sqrt(distance.toDouble())*2-1
    return if(max%1==0.0){max.toInt()}
        else ((max+1).toInt())
}

