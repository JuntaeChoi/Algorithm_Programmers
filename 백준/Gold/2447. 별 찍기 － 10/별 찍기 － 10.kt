
val sb = StringBuilder()
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    var num = readLine().toInt()
    for(i in 0 until num){
        for(j in 0 until num){
            drawStar(i,j,num/3)
        }
        sb.append("\n")
    }
    println(sb)
}
fun drawStar(i:Int,j:Int,n:Int){
    if((i/n)%3==1&&(j/n)%3==1)
        sb.append(" ")
    else if(n==1)
        sb.append("*")
    else
        drawStar(i,j,n/3)
}