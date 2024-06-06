lateinit var maxTree :Array<Long>
lateinit var minTree :Array<Long>
lateinit var arr:Array<Long>

fun main(args: Array<String>)= with(System.`in`.bufferedReader()) {
    val (n,m) = readLine().split(" ").map { it.toInt() }
    arr = Array(n+1){if(it==0)0L else readLine().toLong()}
    maxTree = Array(n*4+1){0}
    minTree = Array(n*4+1){0}
    minTreeInit(1,n,1)
    maxTreeInit(1,n,1)
    repeat(m){
        val (a,b) = readLine().split(" ").map { it.toInt() }
        println("${findMin(1,n,1,a,b)} ${findMax(1,n,1,a,b)}")
    }
}

fun minTreeInit(start:Int,end:Int,node:Int):Long{
    if(start==end){
        minTree[node]=arr[start]
        return minTree[node]
    }

    val mid = (start+end)/2
    minTree[node]=minOf(minTreeInit(start,mid,node*2),minTreeInit(mid+1,end,node*2+1))
    return minTree[node]
}

fun maxTreeInit(start:Int,end:Int,node:Int):Long{
    if(start==end){
        maxTree[node]=arr[start]
        return maxTree[node]
    }
    val mid = (start+end)/2
    maxTree[node]=maxOf(maxTreeInit(start,mid,node*2),maxTreeInit(mid+1,end,node*2+1))
    return maxTree[node]
}

fun findMin(start:Int,end:Int,node:Int,a:Int,b:Int):Long{
    if(start>b||end<a)
        return Long.MAX_VALUE
    else if(a<=start&&b>=end)
        return minTree[node]

    val mid = (start+end)/2
    return minOf(findMin(start,mid,node*2,a,b),findMin(mid+1,end,node*2+1,a,b))
}

fun findMax(start:Int,end:Int,node:Int,a:Int,b:Int):Long{
    if(start>b||end<a)
        return 0
    else if(a<=start&&b>=end)
        return maxTree[node]

    val mid = (start+end)/2
    return maxOf(findMax(start,mid,node*2,a,b),findMax(mid+1,end,node*2+1,a,b))
}