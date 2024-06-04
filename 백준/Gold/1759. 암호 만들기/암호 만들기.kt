import java.util.*

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (l,c) = readLine().split(" ").map { it.toInt() }
    val arr = readLine().split(" ").sorted()
    dfs(l,arr,"",0,0)
}
fun dfs(l:Int,arr:List<String>,now:String,mo:Int,start:Int){
    if(l==0&&mo>=1&&now.length-mo>=2){
        println(now)
        return
    }
    val regex = Regex("[aeiou]")
    for(i in start until arr.size){
        dfs(l-1,arr,now+arr[i],if(arr[i].matches(regex)) mo+1 else mo,i+1)
    }
}