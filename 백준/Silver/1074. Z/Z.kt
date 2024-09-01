import kotlin.math.pow
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    var (n,r,c) = readLine().split(" ").map { it.toInt() }
    var answer = 0

    for(i in n-1 downTo 0){
        val size = 2.0.pow(i.toDouble()).toInt()
        if(r<size&&c<size)
            continue
        else if(r<size&&c>=size){
            c-=size
            answer+=size*size
        }
        else if(r>=size&&c<size){
            r-=size
            answer+=2*(size*size)
        }else{
            c-=size
            r-=size
            answer+=3*(size*size)
        }
    }

    println(answer)
}