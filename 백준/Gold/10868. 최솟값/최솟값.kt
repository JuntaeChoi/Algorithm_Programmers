import java.lang.StringBuilder

lateinit var minTree : LongArray
lateinit var arr : LongArray
fun main(args: Array<String>)= with(System.`in`.bufferedReader()) {
    val (n,m)=readLine().split(" ").map { it.toInt() }
    arr =  LongArray(n+1){if(it==0)1L else readLine().toLong()}
    minTree =LongArray(4*n+1){0}
    init(1,n,1)
    val sb = StringBuilder()
    repeat(m){
        val(a,b) = readLine().split(" ").map { it.toInt() }
        sb.append(findMin(1,n,1,a,b))
        sb.append("\n")
    }
    println(sb)
}
fun init(start:Int,end:Int,node:Int):Long{
    if(start==end){
        minTree[node]=arr[start]
        return minTree[node]
    }
    val mid = (start+end)/2
    minTree[node]= minOf(init(start,mid,node*2),init(mid+1,end,node*2+1))
    return minTree[node]
}
fun findMin(start:Int,end:Int,node:Int,left:Int,right:Int):Long{
    if(start>=left&&end<=right){
        return minTree[node]
    }else if(start>right||end<left){
        return Long.MAX_VALUE
    }
    val mid = (start+end)/2
    return minOf(findMin(start,mid,node*2,left,right),findMin(mid+1,end,node*2+1,left,right))
}