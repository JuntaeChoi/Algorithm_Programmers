import java.util.*

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    var result = n/5
    var temp = n%5
    while(temp!=0){
        if(temp%3==0){
            result+=temp/3
            break
        }
        else if(result>0){
            result-=1
            temp+=5
        }
        else{
            result=-1
            break
        }
    }
    println(result)
}