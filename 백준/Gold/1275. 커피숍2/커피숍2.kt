import java.util.*

lateinit var sumTree : LongArray
lateinit var arr : LongArray

fun main(args: Array<String>)= with(System.`in`.bufferedReader()) {
    val (n,k) = readLine().split(" ").map { it.toInt() }
    val temp = readLine().split(" ").map { it.toLong() }
    arr = LongArray(n+1){if(it==0)0L else temp[it-1]}
    sumTree = LongArray(4*n+1){0L}
    val sb = StringBuilder()
    init(1,n,1)

    repeat(k){
        val(x,y,a,b) = readLine().split(" ").map { it.toInt() }
        sb.append(findSum(1,n,1, minOf(x,y), maxOf(x,y)))
        sb.append("\n")
        update(1,n,1,a,b-arr[a])
        arr[a]=b.toLong()
    }
    println(sb)
}
fun init(start:Int,end:Int,node:Int):Long{
    if(start==end){
        sumTree[node]=arr[start]
        return sumTree[node]
    }
    val mid = (start+end)/2
    sumTree[node] = init(start,mid,node*2)+init(mid+1,end,node*2+1)
    return sumTree[node]
}

fun findSum(start:Int,end:Int,node:Int,left:Int,right:Int):Long{
    if(right<start||left>end)
        return 0L
    if(left<=start&&right>=end)
        return sumTree[node]
    val mid = (start+end)/2
    return findSum(start,mid,node*2,left,right) + findSum(mid+1,end,node*2+1,left,right)
}

fun update(start:Int,end:Int,node:Int,index:Int,diff:Long){
    if(index !in start .. end)
        return
    sumTree[node]+=diff
    if(start==end){
        return
    }
    val mid = (start+end)/2
    update(start,mid,node*2,index,diff)
    update(mid+1,end,node*2+1,index,diff)
}