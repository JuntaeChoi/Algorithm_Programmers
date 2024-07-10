
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
   val n = readLine().toInt()
    var answer=1
    for(i in 2 .. n){
        answer*=i
    }
    println(answer)
}
